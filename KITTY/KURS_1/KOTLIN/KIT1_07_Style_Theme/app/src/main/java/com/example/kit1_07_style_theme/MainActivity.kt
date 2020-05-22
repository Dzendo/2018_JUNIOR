package com.example.kit1_07_style_theme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onClickAbout(view: View) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun onClickDialog(view: View) {
        val builder = AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle)
        builder.setTitle("Dialog")
        builder.setMessage("Покормить кота?")
        builder.setPositiveButton("OK", null)
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    // Стили для компонентов
   // Динамическое изменение стилей
    /*
    // in LayoutInflater
    var view = LayoutInflater.from(themedContext)
            .inflate(R.layout.mylayout, null)

    // in constructor
    var view = View(themedContext)
    */
}
