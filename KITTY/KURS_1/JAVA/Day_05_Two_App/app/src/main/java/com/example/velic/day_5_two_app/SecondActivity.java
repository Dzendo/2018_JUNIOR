package com.example.velic.day_5_two_app;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String adress;
        String letter;

        adress = getIntent().getExtras().getString("adress");
        letter = getIntent().getExtras().getString("letter");

        // или переписать так:

        adress = getIntent().getStringExtra("adress");
        letter = getIntent().getStringExtra("letter");


        TextView infoTextView = findViewById(R.id.textViewInfo);
        infoTextView.setText(adress + " , вам передали " + letter);


    }

}
