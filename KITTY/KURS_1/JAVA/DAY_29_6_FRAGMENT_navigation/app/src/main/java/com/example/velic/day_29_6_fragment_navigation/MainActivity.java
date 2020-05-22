package com.example.velic.day_29_6_fragment_navigation;
//Здесь заведен навигатор с рисунком, ничего не делает

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
//kitty 29_6_2018 Fragment. Не убивание фрагментов
// Фрагментам сказано не умирать с активностью
// следующая активность опятиь присоеденит их к себе
// видимый текст при перерисовке Фрагмента я просто восстанавливаю
// Итого количество насчитаных не забывает приаовороте без запоминания



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
}
