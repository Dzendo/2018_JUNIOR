package com.example.day_20_1_lang_k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import android.content.res.Configuration
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // В коде вы обращаетесь к нужным ресурсам следующим образом:
        val hello = resources.getString(R.string.hello_world)
        val app = resources.getString(R.string.app_name)
        // или так
        val textView : TextView= TextView(this)
        textView.setText(R.string.hello_world)

        hello2.text = app

        // как всё-таки задействовать локальный ресурс.
        val locale = Locale("nl")
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        baseContext.resources.updateConfiguration(configuration, null)
        // выводим английский немецкий текст на русской локали устройства
        setTitle(R.string.app_name)

        // Есть ещё один вариант, когда непереводимые строки размещаются не в ресурсе strings.xml,
        // а в другом файле под именем donottranslate.xml.

       /* defaultConfig {
            ... добавить в build.gradle для двухлокальных Android 7.0 (API 24)

            resConfigs "auto"
        }*/
    }
}
