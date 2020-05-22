package com.example.kit1_05_kotlin_startactivityforresult


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChooseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
    }

    fun onRadioClick(v: View) {
        val answerIntent = Intent()
        when (v.id) {
            R.id.radioDog -> answerIntent.putExtra(THIEF, "DOG-Песик")
            R.id.radioCrow -> answerIntent.putExtra(THIEF, "CROW-Ворона")
            R.id.radioCat -> answerIntent.putExtra(THIEF, "CAT-Котик")
            else -> {
            }
        }
        //answerIntent.putExtra("1", "Песик");
        setResult(RESULT_OK, answerIntent)
        finish()
    }

    companion object {

        val THIEF = "com.example.kit1_05_kotlin_startactivityforresult.THIEF"
    }
}
