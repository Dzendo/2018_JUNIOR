package com.example.velic.day_02_2_hellokitty

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView

class MainActivity_Java_from_Kitty : AppCompatActivity() {

    private lateinit var mHelloTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHelloTextView = findViewById(R.id.textView)

        var imageButton: ImageButton = findViewById(R.id.imageButton)
        // альтернативный вариант
        // val imageButton = findViewById<ImageButton>(R.id.imageButton)

        imageButton.setOnClickListener {
            mHelloTextView.setText("Hello Kitty")
        }
    }
}
