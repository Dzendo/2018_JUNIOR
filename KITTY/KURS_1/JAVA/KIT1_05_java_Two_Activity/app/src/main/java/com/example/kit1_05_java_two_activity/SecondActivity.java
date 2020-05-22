package com.example.kit1_05_java_two_activity;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

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
