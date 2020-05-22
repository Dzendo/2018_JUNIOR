package com.example.kit1_05_java_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {
    public final static String THIEF ="com.example.kit1_05_java_startactivityforresult.THIEF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void onRadioClick(View v) {
        Intent answerIntent = new Intent();
        switch (v.getId()) {
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "Песик");
                break;
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF,"Ворона");
                break;
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "Kотик");
                break;
            default:
                break;

        }
        //answerIntent.putExtra("1", "Песик");
        setResult(RESULT_OK, answerIntent);
        finish();
    }
}
