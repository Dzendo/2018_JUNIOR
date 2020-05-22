package com.example.singleton


import android.content.Intent
import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity :  AppCompatActivity() {
    val ms_j = MySingleton_j.getInstance()
    val ms_k = MySingleton_k.instance
    val ms_java = MySingleton_java.getInstance()
    val ms_kotlin = MySingleton_kotlin.mInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        /*text_j.text = ms_j.myVariable
        text_k.text = ms_k.myVariable
        text_java.text = ms_java.myVariable
        text_kotlin.text = ms_kotlin!!.myVariable*/


        onCLASSSecondIN.setOnClickListener { v: View ->
            ms_j.myVariable = etext_j.text.toString()
            ms_k.myVariable = etext_k.text.toString()
            ms_java.myVariable = etext_java.text.toString()
            ms_kotlin!!.myVariable = etext_kotlin.text.toString()
        }

        onCLASSSecondOUT.setOnClickListener { v: View ->
            text_j.text = ms_j.myVariable
            text_k.text = ms_k.myVariable
            text_java.text = ms_java.myVariable
            text_kotlin.text = ms_kotlin!!.myVariable
        }

        onClickActivitySecond.setOnClickListener { v: View ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
