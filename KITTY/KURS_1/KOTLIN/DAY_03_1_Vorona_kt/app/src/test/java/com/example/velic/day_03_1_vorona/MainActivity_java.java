package com.example.velic.day_03_1_vorona;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity_java extends Activity {
    private Button mCrowsCounterButton;
    private Button mCatsCounterButton;
    private TextView helloTextView;
    public int mCountCrows = 0;
    public int mCountCats = 0;

    private static final String KEY_COUNT_Cats = "COUNT_CATS";
    private static final String KEY_COUNT_Crows = "COUNT_CROWS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloTextView = findViewById(R.id.textView);
        mCrowsCounterButton = findViewById(R.id.button_Counter_Crows);
        mCatsCounterButton = findViewById(R.id.button_Сounter_Сats);
        /*mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
          helloTextView.setText("Я насчитал " + ++mCount + " ворон");
                                                   }
                                               });
         */
        mCrowsCounterButton.setOnClickListener(v ->
                helloTextView.setText("Я насчитал " + ++mCountCrows + " ворон"));
        mCatsCounterButton.setOnClickListener(v ->
                helloTextView.setText("Я насчитал " + ++mCountCats + " котов"));
        if (savedInstanceState != null) {
            mCountCats = savedInstanceState.getInt(KEY_COUNT_Cats, 0);
            mCountCrows = savedInstanceState.getInt(KEY_COUNT_Crows,1);
           // helloTextView.setText("Я насчитал " + mCountCats + " котов");
            //helloTextView.setText("Я насчитал " + mCountCrows + " ворон");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT_Cats, mCountCats);
        outState.putInt(KEY_COUNT_Crows, mCountCrows);

    }

    public void onClick(View view) {

        helloTextView.setText("Hello Kitty! ");
    }
}
