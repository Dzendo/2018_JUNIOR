package com.example.velic.day_23_camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static int TAKE_PICTURE_REQUEST = 1;
    private ImageView imageView;
    private Uri outputFileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onFoto(View view) {
        //getThumbnailPicture();
        saveFullImage();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
            // Проверяем, содержит ли результат маленькую картинку
            if (data != null) {
                if (data.hasExtra("data")) {
                    Bitmap thumbnailBitmap = data.getParcelableExtra("data");
                    // Какие-то действия с миниатюрой
                    imageView.setImageBitmap(thumbnailBitmap);
                }
            } else {
                // Какие-то действия с полноценным изображением,
                // сохраненным по адресу outputFileUri
                imageView.setImageURI(outputFileUri);
            }
        }
    }

    private void getThumbnailPicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TAKE_PICTURE_REQUEST);
    }

    private void saveFullImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(Environment.getExternalStorageDirectory(),
                "test.jpg");
        outputFileUri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, TAKE_PICTURE_REQUEST);
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, TAKE_PICTURE_REQUEST);
        }
    }
    private void handleSmallCameraPhoto(Intent intent) {
        Bundle extras = intent.getExtras();
       // Bitmap mImageBitmap = (Bitmap) extras.get("data");
       // mImageView.setImageBitmap(mImageBitmap);
    }
}
