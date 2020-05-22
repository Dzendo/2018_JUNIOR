package com.example.day_26_1_texteditor_k

import android.os.Bundle
import android.preference.PreferenceActivity

class SettingsActivity : PreferenceActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // загружаем предпочтения из ресурсов
        addPreferencesFromResource(R.xml.preferences)
    }
}