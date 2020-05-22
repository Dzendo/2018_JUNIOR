package com.example.day_18_3_trird_browser_k

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
      /*  val intent0 = Intent("ru.alexanderklimov.Browser")
        intent0.data = Uri.parse("http://developer.alexanderklimov.ru/android/")
        startActivity(intent0)
      */
        // public static final java.lang.String ACTION_VIEW = "android.intent.action.VIEW";
        val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.alexanderklimov.ru/android/"))
        // startActivity(intent)
        // Эта строка чтобы не было краха если нет браузеров
        startActivity(Intent.createChooser(intent, "Мяу 3..."))
    }
}
