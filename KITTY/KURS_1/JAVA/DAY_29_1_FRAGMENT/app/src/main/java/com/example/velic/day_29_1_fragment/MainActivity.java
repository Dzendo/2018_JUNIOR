package com.example.velic.day_29_1_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private ImageView mNameImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.textView);
        mNameImageView = findViewById(R.id.imageView);
    }

    public void OnClick1(View view) {

        String simpleString  =  getString (R.string.Button1);
        mHelloTextView.setText(simpleString);
        Drawable simpleView = getDrawable(R.drawable.chicken);
        mNameImageView.setImageDrawable(simpleView);

    }

    public void OnClick2(View view) {
         mHelloTextView.setText(getString (R.string.Button2));
         mNameImageView.setImageDrawable(getDrawable(R.drawable.dog));
    }

    public void OnClick3(View view) {
        String simpleString  =  getString (R.string.Button3);
        mHelloTextView.setText(simpleString);
        Drawable simpleView = getDrawable(R.drawable.duck);
        mNameImageView.setImageDrawable(simpleView);
    }
}
