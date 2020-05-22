package com.example.velic.day_25_set_preference;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MyPreferenceScreen extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencescreen);
    }

}
