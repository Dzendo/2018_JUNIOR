package com.example.day_04_3_svetofor_x_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGreen.setOnClickListener{
            setTitle("Светофор listener")
            textView.text = getText(R.string.green)
            constraintLayout.background =  getDrawable(R.color.greenColor)
        }
        // Только для JAVA 8 :
        buttonYellow.setOnClickListener{ v ->
            setTitle("Светофор Лямбда")
            textView.text = getString(R.string.yellow)
            constraintLayout.background =  getDrawable(R.color.yellowColor)
        }

    }

    fun onRedButtonClick(view: View) {
        setTitle("Светофор Fun")
        textView.text = getText(R.string.red)
        constraintLayout.background =  getDrawable(R.color.redColor)

    }

    fun onYellowButtonClick(view: View) {
        setTitle("Светофор Fun")
        textView.text = getText(R.string.yellow)
        constraintLayout.background =  getDrawable(R.color.yellowColor)
    }

    fun onGreenButtonClick(view: View) {
        setTitle("Светофор Fun")
        textView.text = getText(R.string.green)
        constraintLayout.background =  getDrawable(R.color.greenColor)
    }
}
