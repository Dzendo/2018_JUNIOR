package com.example.kit1_05_2_kotlin_two_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val adress = intent.getStringExtra("adress")
        val letter = intent.getStringExtra("letter")
        textViewInfo.text = "$adress , вам передали $letter"
    }
}
