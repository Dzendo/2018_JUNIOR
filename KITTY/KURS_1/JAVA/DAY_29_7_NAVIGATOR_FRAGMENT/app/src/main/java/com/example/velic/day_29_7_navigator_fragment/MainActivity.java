package com.example.velic.day_29_7_navigator_fragment;
//Здесь заведен навигатор с рисунком, ничего не делает

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
//kitty 29_6_2018 Fragment. Пробная для NAVIGATOR
// Фрагментам сказано не умирать с активностью
// Не сделана : надо еще фрагментов и Навигации архитектуры

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void count(String data) {
        FragmentManager manager = getSupportFragmentManager();
        WithTextViewFragment withTextViewFragment =
                (WithTextViewFragment) manager.findFragmentById(R.id.fragment_withTextView);
        withTextViewFragment.changeText(data);
    }
    public void onClickButton(View view) {
        Toast.makeText(this, "MainActivity",
                Toast.LENGTH_SHORT).show();

    }
}
