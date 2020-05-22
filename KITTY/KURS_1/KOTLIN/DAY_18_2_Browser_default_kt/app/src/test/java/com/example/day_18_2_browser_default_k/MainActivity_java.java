package com.example.day_18_2_browser_default_k;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_java extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
       /* Intent intent = new
                Intent("ru.alexanderklimov.Browser");
        intent.setData(Uri.parse("http://developer.alexanderklimov.ru/android/"));
        startActivity(intent);
        */
       // public static final java.lang.String ACTION_VIEW = "android.intent.action.VIEW";
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.alexanderklimov.ru/android/"));
        // startActivity(intent);
        // Эта строка чтобы не было краха если нет браузеров
        startActivity(Intent.createChooser(intent, "Мяу..."));
    }
}
