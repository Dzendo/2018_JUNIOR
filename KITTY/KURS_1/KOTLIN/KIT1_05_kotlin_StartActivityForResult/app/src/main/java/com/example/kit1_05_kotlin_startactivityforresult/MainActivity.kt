package com.example.kit1_05_kotlin_startactivityforresult


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val CHOOSE_THIEF = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val questionIntent = Intent(this@MainActivity, ChooseActivity::class.java)
        startActivityForResult(questionIntent, CHOOSE_THIEF)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    //override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    //    super.onActivityResult(requestCode, resultCode, data)
        // data это обратный INMTENT

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                val thiefname = data!!.getStringExtra(ChooseActivity.THIEF)
                //String thiefname = data.getStringExtra("1");
                //infoTextView.setText(ChooseActivity.THIEF);
                textViewInfo.text = thiefname
                // infoTextView.text = thiefname
            } else {
                textViewInfo.text = "" // стираем текст
            }
        }
    }
}
