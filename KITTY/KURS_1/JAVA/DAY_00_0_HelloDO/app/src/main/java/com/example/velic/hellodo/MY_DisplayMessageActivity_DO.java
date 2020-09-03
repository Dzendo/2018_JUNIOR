package com.example.velic.hellodo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MY_DisplayMessageActivity_DO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Получаем сообщение из объекта intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Создаем текстовое поле
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Устанавливаем текстовое поле в системе компоновки activity
        setContentView(textView);

        //setContentView(R.layout.activity_my__display_message__do);
    }
}
