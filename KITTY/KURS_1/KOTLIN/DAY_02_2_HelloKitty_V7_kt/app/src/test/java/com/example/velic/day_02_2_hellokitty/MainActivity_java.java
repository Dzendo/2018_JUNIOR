package com.example.velic.day_02_2_hellokitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity_java extends AppCompatActivity {
    private TextView mHelloTextView; // переменная для ссылки на поле типа TextView
    private EditText mNameEditText;  // переменная для ссылки на поле типа EditText
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = (TextView)findViewById(R.id.textView);
       // mHelloTextView = findViewById(R.id.textView);
        mNameEditText = findViewById(R.id.editText); // переменная указывет на поле editText
    }

    public void onClick(View view) {
        if (mNameEditText.getText().length() == 0) {
            mHelloTextView.setText("Hello Kitty!");
        } else {
            mHelloTextView.setText("Привет, " + mNameEditText.getText() );
        }
    }
}
