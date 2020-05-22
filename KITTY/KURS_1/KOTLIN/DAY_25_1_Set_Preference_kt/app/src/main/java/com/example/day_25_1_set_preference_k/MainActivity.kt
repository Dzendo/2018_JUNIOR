package com.example.day_25_1_set_preference_k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val TAG = "ОТЛАДКА MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showSettings(view: View) {
        Log.d(TAG, "onCreate")
        val intent = Intent(this, MyPreferenceActivity::class.java)
        startActivity(intent)
    }

    fun onRing(view: View) {
        val intent = Intent(this, RingtonePreferenceActivity::class.java)
        startActivity(intent)
    }

    fun onEdit(view: View) {
        val intent = Intent(this, MyPreferenceScreen::class.java)
        startActivity(intent)
    }
}
