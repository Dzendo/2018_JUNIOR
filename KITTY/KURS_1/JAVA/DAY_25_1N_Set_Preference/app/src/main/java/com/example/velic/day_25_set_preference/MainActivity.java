package com.example.velic.day_25_set_preference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private final static String TAG = "ОТЛАДКА MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSettings(View view) {
        Log.d(TAG, "onCreate");
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
    }

    public void onRing(View view) {
        Intent intent = new Intent(this, RingtonePreferenceActivity.class);
        startActivity(intent);
    }

    public void onEdit(View view) {
        Intent intent = new Intent(this, MyPreferenceScreen.class);
        startActivity(intent);
    }
}
