package com.example.day_23_3_foto_video_kadr_k

import android.widget.Toast
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {
    val CAMERA_REQUEST = 1
    val PIC_CROP = 2
    private var picUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Съёмка и Кадрирование"
    }

    fun onClick(v: View) {
        try {
            // Намерение для запуска камеры
            //  public final static String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
            val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(captureIntent, CAMERA_REQUEST)
        } catch (e: ActivityNotFoundException) {
            // Выводим сообщение об ошибке
            val errorMessage = "Ваше устройство не поддерживает съемку"
            val toast = Toast
                    .makeText(this, errorMessage, Toast.LENGTH_SHORT)
            toast.show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == AppCompatActivity.RESULT_OK) {
            // Вернулись от приложения Камера
            if (requestCode == CAMERA_REQUEST) {
                // Получим Uri снимка
                picUri = data!!.data  // ЭТО НЕ СРАБАТЫВАЕТ picUri=null
                Toast.makeText(this, "Вернулись от приложения Камера $picUri", Toast.LENGTH_SHORT).show()
                // кадрируем его
                val thumbnailBitmap = data!!.extras!!.get("data") as Bitmap
                val picView = findViewById(R.id.picture) as ImageView
                picView.setImageBitmap(thumbnailBitmap)
               // return
                performCrop()
            } else if (requestCode == PIC_CROP) {
                Toast.makeText(this, "Вернулись от приложения Кадрирование", Toast.LENGTH_SHORT).show()
                val extras = data!!.extras
                // Получим кадрированное изображение
                val thePic = extras!!.getParcelable<Bitmap>("data")
                // передаём его в ImageView
                val picView = findViewById(R.id.picture) as ImageView
                picView.setImageBitmap(thePic)
            }// Вернулись из операции кадрирования
        }
    }

    private fun performCrop() {
        Toast.makeText(this, "Вызвали кадрирование $picUri", Toast.LENGTH_SHORT).show()
        try {
            // Намерение для кадрирования. Не все устройства поддерживают его
            val cropIntent = Intent("com.android.camera.action.CROP")
            cropIntent.setDataAndType(picUri, "image/*")
            cropIntent.putExtra("crop", "true")
            cropIntent.putExtra("aspectX", 1)
            cropIntent.putExtra("aspectY", 1)
            cropIntent.putExtra("outputX", 256)
            cropIntent.putExtra("outputY", 256)
            cropIntent.putExtra("return-data", true)
         Toast.makeText(this, "кадрирование $picUri $PIC_CROP", Toast.LENGTH_SHORT).show()
            startActivityForResult(cropIntent, PIC_CROP)
        } catch (anfe: ActivityNotFoundException) {
            val errorMessage = "Извините, но ваше устройство не поддерживает кадрирование"
            val toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}
