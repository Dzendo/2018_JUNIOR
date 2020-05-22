package com.example.velic.lessons_do;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends Activity {
String paket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void World(View view) {
        String paket="helloworld";
        StartLesson(paket);
    }

    public void Kitty(View view) {
        String paket="hellokitty";
        StartLesson(paket);
    }

    public void Vorona(View view) {
        String paket="vorona";
        StartLesson(paket);
    }

    public void Свет(View view) {
        String paket="svetofor";
        StartLesson(paket);

    }

    public void Экран2(View view) {
        String paket="day_5_two_app";
        StartLesson(paket);
    }

    public void Шерлок(View view) {
        String paket="day_5_startactivityforresult";
        StartLesson(paket);
    }
    private void StartLesson (String paket) {
        String velic="com.example.velic.";
        String main=".MainActivity";
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(velic+paket, velic+paket+main));
        startActivity(intent);
    }

    public void Orient_1(View view) {
        String paket="day_6_3_orient";
        StartLesson(paket);
    }

    public void Orient_2(View view) {
        String paket="day_6_1_orient";
        StartLesson(paket);
    }
}
