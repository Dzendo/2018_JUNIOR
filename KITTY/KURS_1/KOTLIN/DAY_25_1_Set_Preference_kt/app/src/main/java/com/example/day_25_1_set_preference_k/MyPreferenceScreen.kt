package com.example.day_25_1_set_preference_k

import android.os.Bundle
import android.preference.PreferenceActivity

class MyPreferenceScreen : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferencescreen)
    }

}
