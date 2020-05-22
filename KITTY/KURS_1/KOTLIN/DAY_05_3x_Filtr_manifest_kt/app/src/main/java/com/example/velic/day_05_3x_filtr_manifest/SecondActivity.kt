package com.example.velic.day_05_3x_filtr_manifest

import android.app.Activity
import android.os.Bundle
import com.example.velic.day_05_3x_filtr_manifest.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val adress = intent.getStringExtra("adress")
        val letter = intent.getStringExtra("letter")
        textViewInfo.text = "$adress , вам передали $letter"
    }

}
