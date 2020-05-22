package com.example.velic.day_29_2_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements Fragment1.OnSelectedButtonListener{
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

        String simpleString  =  getString (R.string.Button1)+ "CLICK";
        mHelloTextView.setText(simpleString);
        Drawable simpleView = getDrawable(R.drawable.chicken);
        mNameImageView.setImageDrawable(simpleView);

    }

    public void OnClick2(View view) {
        mHelloTextView.setText(getString (R.string.Button2)+ "CLICK");
        mNameImageView.setImageDrawable(getDrawable(R.drawable.dog));
    }

    public void OnClick3(View view) {
        String simpleString  =  getString (R.string.Button3)+ "CLICK";
        mHelloTextView.setText(simpleString);
        Drawable simpleView = getDrawable(R.drawable.duck);
        mNameImageView.setImageDrawable(simpleView);
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        // подключаем FragmentManager
        FragmentManager fragmentManager = getFragmentManager();

        // Получаем ссылку на второй фрагмент по ID
        Fragment2 fragment2 = (Fragment2) fragmentManager
                .findFragmentById(R.id.fragment2);

        // Выводим нужную информацию
        if (fragment2 != null)
            fragment2.setDescription(buttonIndex);
    }
}
