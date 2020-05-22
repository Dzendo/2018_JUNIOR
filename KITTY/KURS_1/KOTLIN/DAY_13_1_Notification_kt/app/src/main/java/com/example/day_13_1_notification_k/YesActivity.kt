package com.example.day_13_1_notification_k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.graphics.Typeface
import android.widget.TextView



class YesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = LinearLayout(this)
        val textView1 = TextView(this)
        // установка фонового цвета
        textView1.setBackgroundColor(-0x17150a)
        // установка цвета текста
        textView1.setTextColor(-0xa39440)
        // делаем все буквы заглавными
        textView1.isAllCaps = true
        // устанавливаем вравнивание текста по центру
        textView1.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        // устанавливаем текста
        textView1.text = "Ответ ДА"
        // установка шрифта
        textView1.typeface = Typeface.create("casual", Typeface.NORMAL)
        // устанавливаем высоту текста
        textView1.textSize = 26f

        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        // установка внешних отступов
        layoutParams.setMargins(20, 20, 20, 20)
        // устанавливаем размеры
        textView1.layoutParams = layoutParams
        linearLayout.addView(textView1)
        setContentView(linearLayout)
    }
}
