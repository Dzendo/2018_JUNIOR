package com.example.day_29_11_fragment_onclick_k


import android.os.Bundle
import android.view.View


import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment2.*
import com.example.day_29_11_fragment_onclick_k.R.drawable.*
import com.example.day_29_11_fragment_onclick_k.R.string.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OnClick1(view: View) {
        textView.text = getString(Button1)
        imageView.setImageResource(chicken)
    }

    fun OnClick2(view: View) {
        textView.text = getString(Button2)
        imageView.setImageResource(dog)
    }

    fun OnClick3(view: View) {
        textView.text = getString(Button3)
        imageView.setImageResource(duck)
    }
}