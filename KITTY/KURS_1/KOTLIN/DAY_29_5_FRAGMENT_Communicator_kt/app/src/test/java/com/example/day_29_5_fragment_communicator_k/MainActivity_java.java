package com.example.day_29_5_fragment_communicator_k;
//Здесь заведен навигатор с рисунком, ничего не делает

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
//kitty 29_5_2018 Fragment. Сохранение данных
//Наша задача - научить фрагменты обмениваться данными через активность.
//Один фрагмент кликает, второй считает и показывает сколько накликали
//Первый отправляет второму клик через интефейс и главную активность
//дополнительно сделано запоминание и вспоминание накликанного перед поворотом экрана
//в том числе запоминаем и вспоминаем видимый текст


public class MainActivity_java extends AppCompatActivity implements Communicator{

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
}
