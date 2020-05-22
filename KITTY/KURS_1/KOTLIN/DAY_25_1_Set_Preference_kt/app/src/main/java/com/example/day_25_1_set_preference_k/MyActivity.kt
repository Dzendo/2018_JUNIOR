package com.example.day_25_1_set_preference_k

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity

/* Отслеживание изменений в Общих настройках */
class MyActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Регистрируем этот OnSharedPreferenceChangeListener
        val context = applicationContext
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, s: String) {
        // TODO Проверять общие настройки, ключевые параметры и изменять UI
        // или поведение приложения, если потребуется.
    }
}
