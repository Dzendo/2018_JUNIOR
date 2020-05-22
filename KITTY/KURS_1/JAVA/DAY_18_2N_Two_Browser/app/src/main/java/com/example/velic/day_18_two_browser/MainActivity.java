package com.example.velic.day_18_two_browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://navalny.com/"));
                //Uri.parse("http://developer.alexanderklimov.ru/android/"));
        // startActivity(intent);
        // Эта строка чтобы не было краха если нет браузеров
        startActivity(Intent.createChooser(intent, "Мяу..."));
    }
}
