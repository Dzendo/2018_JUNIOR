package com.example.velic.day_05_2x_startactivityforresust

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View


class ChooseActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
    }

    fun onRadioClick(v: View) {
        val answerIntent = Intent()
        when (v.id) {
            R.id.radioDog -> answerIntent.putExtra(THIEF, "Песик")
            R.id.radioCrow -> answerIntent.putExtra(THIEF, "Ворона")
            R.id.radioCat -> answerIntent.putExtra(THIEF, "Сраный котик")
            else -> {
            }
        }
        //answerIntent.putExtra("1", "Песик");
        setResult(Activity.RESULT_OK, answerIntent)
        finish()
    }

    companion object {

        val THIEF = "com.example.velic.day_5_startactivityforresult.THIEF"
    }
}
