package com.example.kit1_05_2_kotlin_two_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_birthday.*
import com.example.kit1_05_2_kotlin_two_activity.R.layout.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Всплывающее окно
        showToast()

    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast toast = Toast.makeText(getApplicationContext(),
        //        "Прощай, День Рождения", Toast.LENGTH_SHORT);
        //toast.show();
        Toast.makeText(this@MainActivity, "Прощай, День Рождения 1000$", Toast.LENGTH_SHORT).show()

    }


    fun OnClick_Send(view: View) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        // в ключ adress пихаем текст из поля адресса
        intent.putExtra("adress", adress_text.text.toString())
        // в ключ letter пихаем тест сообщения
        intent.putExtra("letter", letter_text.text.toString())
        startActivity(intent)
    }

    fun onClick(view: View) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun onClickBirthday(view: View) {
        val intent = Intent(this@MainActivity, BirthdayActivity::class.java)
        startActivity(intent)
    }

    fun showToast() {     // Всплывающее окно
        //создаем и отображаем текстовое уведомление
        val toast = Toast.makeText(applicationContext,
            R.string.Birrthday,
            Toast.LENGTH_SHORT)

        toast.setGravity(Gravity.CENTER, 0, 0)

        val toastContainer = toast.view as LinearLayout
        val doImageView = ImageView(applicationContext)
        doImageView.setImageResource(R.drawable.aa1020921738)
        toastContainer.addView(doImageView, 0)
        toast.show()

    }

    fun onToast(view: View) {

        val toast: Toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layoutInflater.inflate(activity_birthday,BirthdayLayout_BD)
        toast.show()
    }
}
