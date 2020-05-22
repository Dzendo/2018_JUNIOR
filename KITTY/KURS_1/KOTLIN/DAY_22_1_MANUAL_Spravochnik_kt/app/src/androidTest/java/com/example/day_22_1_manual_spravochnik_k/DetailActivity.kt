package com.example.day_22_1_manual_spravochnik_k

import android.content.Context
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.webView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //val webView = findViewById<WebView>(R.id.webView)

        val intent = intent
        //получаем строку и формируем имя ресурса
        val resName = "n" + intent.getIntExtra("title", 0)
        Log.i("name", resName)
        val context = baseContext //получаем контекст

        //читаем текстовый файл из ресурсов по имени
        val text = readRawTextFile(context, resources.getIdentifier(resName,
                "raw", "com.example.day_22_1_manual_spravochnik_k"))

        this.webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null)
    }

    //читаем текст из raw-ресурсов
    private fun readRawTextFile(context: Context, resId: Int): String? {
        val inputStream = context.resources.openRawResource(resId)

        val inputReader = InputStreamReader(inputStream)
        val buffReader = BufferedReader(inputReader)

        val builder = StringBuilder()
        var line: String =buffReader.readLine()

        try {
           do {
                builder.append(line)
                builder.append("\n")
               line = buffReader.readLine()
            } while (line != null)
        } catch (e: IOException) {
            return null
        }
        return builder.toString()
    }
}
