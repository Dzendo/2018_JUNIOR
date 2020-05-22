package com.example.kit1_02_java_hello_afalina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = (TextView)findViewById(R.id.textView);
        mHelloTextView = findViewById(R.id.textView);
        mNameEditText = findViewById(R.id.editText);

    }
    private TextView mHelloTextView;
    private EditText mNameEditText;
    public void onClick(View view) {
        if (mNameEditText.getText().length() == 0) {
            mHelloTextView.setText("Hello AFALINA!");
        } else {
            mHelloTextView.setText("Привет, " + mNameEditText.getText() );
        }
    }
}
