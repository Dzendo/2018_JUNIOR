package com.example.day_23_2_foto_video_k

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.provider.MediaStore
import android.widget.Toast
import android.content.Intent

import android.os.Environment.DIRECTORY_PICTURES
import android.net.Uri
import android.os.Environment

import android.view.View
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import androidx.core.app.ActivityCompat.startActivityForResult






class MainActivity : AppCompatActivity() {

    val REQUEST_TAKE_PHOTO = 1
    private var mCurrentPhotoPath: String? = null
    // private var imageView: ImageView? = null
    private var photoURI: Uri? = null
    private var photoFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //imageView = findViewById(R.id.imageView)
    }
  // Вызов по кнопке
    fun onClick1(view: View) {
       // Toast.makeText(this, "onClick1", Toast.LENGTH_SHORT).show()
        dispatchTakePictureIntent()
    }
        // После камеры по выходу выполняется:
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            // сохраненное в файле изображение вывести на первый экран:
           // imageView!!.setImageURI(photoURI)  // через provider у меня вылетает
              imageView!!.setImageURI(Uri.fromFile(photoFile))   // так работает - это устаревшее
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File? {
         // Create an image file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"

  //  Методы getExternalFilesDir() и getFilesDir() работают с папками приложения,
  // поэтому фотографии будут удалены во время деинсталяции.
  // Иногда такой подход может пригодиться, если фотки специфичны для приложения
  // и нет необходимости сохранять их в общей папке:
       var storageDir = getExternalFilesDir(DIRECTORY_PICTURES)

   // стандартный путь для фотографий: (папка будет хранить фотографии даже после удаления приложения)
       /* var storageDir = File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES),getAlbumName())  */

       val image = File.createTempFile(
               imageFileName, /* prefix */
               ".jpg", /* suffix */
               storageDir      /* directory */
       )

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath()

        //Toast.makeText(this, "$mCurrentPhotoPath ", Toast.LENGTH_LONG).show()
        return image
    }

    private fun dispatchTakePictureIntent() {
         //Toast.makeText(this, MediaStore.ACTION_IMAGE_CAPTURE, Toast.LENGTH_SHORT).show()
         val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Ensure that there's a camera activity to handle the intent
       // Toast.makeText(this, "dispatchTakePictureIntent_Start", Toast.LENGTH_SHORT).show()

        if (takePictureIntent.resolveActivity(packageManager) != null) {
            // Create the File where the photo should go
            //Toast.makeText(this, " 57 ${takePictureIntent.resolveActivity(packageManager)}", Toast.LENGTH_LONG).show()
            photoFile = null
            try {
                photoFile = createImageFile()
            } catch (ex: IOException) {
                // Error occurred while creating the File
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }

            // Continue only if the File was successfully created

            if (photoFile != null) {
                //Toast.makeText(this, "58 ${photoFile} ${photoFile!!} ", Toast.LENGTH_LONG).show()
                // Это устаревший вызов без провайдера но работает:
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile))
                    // вызов провайдера вылетает:
               /* photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.provider",
                        photoFile!!)
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                */
                //Toast.makeText(this, "59 ${photoURI}", Toast.LENGTH_LONG).show()
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                //Toast.makeText(this, "60 return", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun onClick2(view: View) {   // не работает - не уведомляет , но и не вылетает
        // Уведомляем приложение Галерея
        Toast.makeText(this, "onClick2 - в галерею $mCurrentPhotoPath", Toast.LENGTH_SHORT).show()
        galleryAddPic()
    }
    // Уведомляем приложение Галерея - не работает
    private fun galleryAddPic() {
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        val file = File(mCurrentPhotoPath)
        val contentUri = Uri.fromFile(file)
        mediaScanIntent.data = contentUri
        this.sendBroadcast(mediaScanIntent)
        // MediaStore.Images.Media.insertImage(getContentResolver(), yourBitmap, yourTitle , yourDescription);
    }
    fun onClick3(view: View) {
        // декодируем
        Toast.makeText(this, "onClick - декодируем $mCurrentPhotoPath", Toast.LENGTH_SHORT).show()
        setPic()
    }
    // Декодирование масштабированого изображения
    //Работа с большими изображениями может вызвать проблемы на устройстве с ограниченным объемом памяти.
    // Если ваше приложение вызывает нехватку памяти после вывода нескольких изображений,
    // вы можете значительно уменьшить объем занимаемой памяти,
    // использовав во время распаковки JPEG-файлов в память масштабирование,
    // которое учитывает размеры вашего View для просмотра картинок:
    private fun setPic() {
        // Get the dimensions of the View
        val targetW = imageView.width /2
        val targetH = imageView.height /2

        // Get the dimensions of the bitmap
        val bmOptions = BitmapFactory.Options()
        bmOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions)
        val photoW = bmOptions.outWidth
        val photoH = bmOptions.outHeight

        // Determine how much to scale down the image
        val scaleFactor = Math.min(photoW / targetW, photoH / targetH)

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false
        bmOptions.inSampleSize = scaleFactor
        bmOptions.inPurgeable = true

        val bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions)
        imageView.setImageBitmap(bitmap)
        Toast.makeText(this, "scaleFactor = $scaleFactor", Toast.LENGTH_SHORT).show()
    }

    // фотосъёмка
    fun capturePhoto(view: View) {
        val intent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 1)
        }
    }

    // видеосъёмка
    fun captureVideo(view: View) {
        val intent = Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent,1)
        }
    }
}
