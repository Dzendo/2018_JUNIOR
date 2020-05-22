package com.example.day_25_1_set_preference_k;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity_java extends Activity {
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
