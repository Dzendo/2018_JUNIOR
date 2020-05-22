package com.example.velic.day_02_2_hellokitty

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity_Java_from_DO : AppCompatActivity() {
    private var mHelloTextView: TextView? = null
    private var mNameEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHelloTextView = findViewById<View>(R.id.textView) as TextView
        mHelloTextView = findViewById(R.id.textView)
        mNameEditText = findViewById(R.id.editText)

    }

    fun onClick() {
        if (mNameEditText!!.text.length == 0) {
            mHelloTextView!!.text = "Hello Kotlin!"
        } else {
            mHelloTextView!!.text = "Привет от KOTLINa, " + mNameEditText!!.text
        }
    }
}
