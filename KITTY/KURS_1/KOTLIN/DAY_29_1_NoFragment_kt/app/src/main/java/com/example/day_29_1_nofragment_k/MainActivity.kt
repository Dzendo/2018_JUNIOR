package com.example.day_29_1_nofragment_k

import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import com.example.day_29_1_nofragment_k.R.string.*
import com.example.day_29_1_nofragment_k.R.drawable.*

import androidx.appcompat.app.AppCompatActivity

// Работаем по старинке
class MainActivity : AppCompatActivity() {
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun OnClick(view: View) {
        when (view) {
            button1 ->{
                textView.text = getString(Button1)
                imageView.setImageDrawable(getDrawable(chicken))
            }
            button2 -> {
                textView.text = getString(Button2)
                imageView.setImageDrawable(getDrawable(dog))
            }
            button3 ->{
                textView.text = getString(Button3)
                imageView.setImageDrawable(getDrawable(duck))
            }
        }
    }
    fun OnClick1(view: View) {

        textView.text = getString(Button1)
        imageView.setImageDrawable(getDrawable(chicken))
    }

    fun OnClick2(view: View) {
        textView.text = getString(Button2)
        imageView.setImageDrawable(getDrawable(dog))
    }

    fun OnClick3(view: View) {
        textView.text = getString(Button3)
        imageView.setImageDrawable(getDrawable(duck))
    }
}
