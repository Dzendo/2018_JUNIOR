package com.example.velic.day_29_3_fragmrnt;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DAY_29_3_11", "SecondActivity : ");
        setContentView(R.layout.activity_second);
        Log.d("DAY_29_3_11A", "SecondActivity : ");
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("DAY_29_3_12", "SecondActivity : LANDSCAPE");
            finish();
            Log.d("DAY_29_3_13", "SecondActivity : LANDSCAPE");
            return;
        }
        Log.d("DAY_29_3_14", "SecondActivity : NON LANDSCAPE");
        // Получим индекс из намерения активности
        Intent intent = getIntent();
        int buttonIndex = intent.getIntExtra("buttonIndex", -1);
        if (buttonIndex != -1) {
            Log.d("DAY_29_3_15", "SecondActivity : NON LANDSCAPE "+buttonIndex);
            FragmentManager fragmentManager = getFragmentManager();
            Fragment2 fragment2 = (Fragment2) fragmentManager
                    .findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }
}
