package com.example.day_25_1_set_preference_k;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MyPreferenceScreen_java extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencescreen);
    }

}
