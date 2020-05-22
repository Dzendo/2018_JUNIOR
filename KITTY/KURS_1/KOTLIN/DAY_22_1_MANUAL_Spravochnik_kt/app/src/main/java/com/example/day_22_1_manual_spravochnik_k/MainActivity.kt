package com.example.day_22_1_manual_spravochnik_k

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.listView

// Как сделать простой список из массива, используя ListView
//Как загрузить текст из ресурсов
//Как загрузить html-текст в WebView
//Как передать данные из одной активности в другую

class MainActivity : AppCompatActivity() {

    //Создаем массив разделов:
    private val titles = arrayOf("00. Начало", "01. Чем кормить кота.", "02. Как гладить кота.", "03. Как спит кот.", "04. Как играть с котом.", "05. Как разговаривать с котом", "06. Интересные факты из жизни котов.", "07. Как назвать кота.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Получим идентификатор ListView
        //val listView = findViewById<ListView>(R.id.listView)
        //устанавливаем массив в ListView
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, titles)
        listView.isTextFilterEnabled = true

        //Обрабатываем щелчки на элементах ListView:
        listView.onItemClickListener = AdapterView.OnItemClickListener { a, v, position, id ->
            val intent = Intent()
            intent.setClass(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("title", position)
            //запускаем вторую активность
            startActivity(intent)
        }
    }
}
