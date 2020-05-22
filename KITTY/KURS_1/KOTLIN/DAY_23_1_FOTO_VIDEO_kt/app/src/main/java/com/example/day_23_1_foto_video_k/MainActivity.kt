package com.example.day_23_1_foto_video_k

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent.KEYCODE_CAMERA
import android.content.Intent
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.os.Environment.getExternalStorageDirectory
import java.io.File


class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST = 0
   // private val imageView: ImageView? = null
   private val TAKE_PICTURE_REQUEST = 1
    private var outputFileUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
     fun onClick1 (view:View) {
         // Вы можете программно запустить из своей программы системное приложение "Камера"
         // (в этом случае вам не понадобятся дополнительные разрешения) через намерение.
         val intent = Intent()
         intent.action = Intent.ACTION_CAMERA_BUTTON
         intent.putExtra(Intent.EXTRA_KEY_EVENT, KeyEvent(KeyEvent.ACTION_DOWN,
                 KEYCODE_CAMERA))
         sendOrderedBroadcast(intent, null)

         // А вообще у пользователя могут стоять разные приложения, способные фотографировать.
         // Тогда у вас будет появляться диалоговое окно с выбором нужного приложения.
         // Они все имеют в своём составе такую запись в манифесте (для общего развития):
         // <action android:name="android.media.action.IMAGE_CAPTURE"/>
         // <category android:name="android.intent.category.DEFAULT"/>
     }
    fun onClick2 (view:View) {
        // У Гугла есть своя программа Google Камера. Запустим её, зная имя пакета.
        val intent = getIntent()

        intent.component = null
        intent.setPackage("com.google.android.GoogleCamera")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        // При вызове метода getIntent() вместо new Intent() приложение запускалось сразу,
        // иначе - выводилось диалоговое окно выбора программы из списка.
        // Также нужно быть уверенным, что программа установлена, в примере нет кода проверки.
    }

    fun onClick3(v: View) {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST)

        // Длинный вариант
        // Intent cameraIntent = new Intent();
        // cameraIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        // startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // По умолчанию фотография возвращается в виде объекта Bitmap, содержащего миниатюру.
        // Этот объект находится в параметре data, передаваемом в метод onActivityResult().
        // Чтобы получить миниатюру в виде объекта Bitmap, нужно вызвать метод getParcelableExtra()
        // из намерения, передав ему строковое значение data.
        // В примере использовался упрощённый вариант, ниже показан пример другого варианта кода.
        if (requestCode == CAMERA_REQUEST && resultCode == AppCompatActivity.RESULT_OK) {
            // Фотка сделана, извлекаем картинку
            val thumbnailBitmap = data!!.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(thumbnailBitmap)
        }
        // Если вы укажете исходящий путь URI с помощью параметра MediaStore.
        // EXTRA_OUTPUT в запущенном намерении, полноразмерное изображение,
        // снятое камерой, сохранится в заданном месте.
        // В таком случае в метод onActivityResult() не будет передана миниатюра,
        // а итоговое намерение продемонстрирует значение null.

        // В следующем примере показано, как при создании снимка получать
        // миниатюру или полноценное изображение, используя намерение.
        // изображение будет сохранено во внешнем хранилище под именем test.jpg.
        //    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == AppCompatActivity.RESULT_OK) {
            // Проверяем, содержит ли результат маленькую картинку
            if (data != null) { // вызывается из onClick4
                if (data.hasExtra("data")) {
                    val thumbnailBitmap = data.getParcelableExtra<Bitmap>("data")
                    // Какие-то действия с миниатюрой
                    imageView.setImageBitmap(thumbnailBitmap)
                }
            } else { // вызывается из onClick5
                // Какие-то действия с полноценным изображением,
                // сохраненным по адресу outputFileUri
                imageView.setImageURI(outputFileUri)
            }
        }
    }

    fun onClick4(v: View) {
        getThumbnailPicture();
        //saveFullImage()
    }

    fun onClick5(v: View) {
        //getThumbnailPicture();
        saveFullImage()
    }
    private fun getThumbnailPicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, TAKE_PICTURE_REQUEST)
    }

    private fun saveFullImage() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file = File(Environment.getExternalStorageDirectory(),"test.jpg")
        outputFileUri = Uri.fromFile(file)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
        startActivityForResult(intent, TAKE_PICTURE_REQUEST)
    }
    // В реальных приложениях для создания имён файлов используют текущую дату,
    // чтобы обеспечить уникальность и не затереть существующую фотографию.
}
// В Android 6.0 Marshmallow пример перестал работать из-за новых правил с разрешениями.
// Новый вариант представлен в соответствующей статье.
// У меня все работает на реальном телефоне 5,1 API 22 Lollipop
// На этом неприятности не закончились. В Lollipop для Uri нужно использовать метод setClipData(),
// а в Nougat запретили и сам URI, заставляя переходить на FileProvider.