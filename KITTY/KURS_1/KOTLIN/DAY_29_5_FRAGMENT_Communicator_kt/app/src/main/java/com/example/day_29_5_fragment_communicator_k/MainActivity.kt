package com.example.day_29_5_fragment_communicator_k

//Здесь заведен навигатор с рисунком, ничего не делает

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

//kitty 29_5_2018 Fragment. Сохранение данных
//Наша задача - научить фрагменты обмениваться данными через активность.
//Один фрагмент кликает, второй считает и показывает сколько накликали
//Первый отправляет второму клик через интефейс и главную активность
//дополнительно сделано запоминание и вспоминание накликанного перед поворотом экрана
//в том числе запоминаем и вспоминаем видимый текст

// Напоминаю, мы не связываем два фрагмента между собой напрямую. Создаём интерфейс для этих целей.

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
// Фрагмент передаёт через метод count() данные data,
// а активность их принимает и передаёт их в метод второго фрагмента changeText().
    override fun count(data: String) {
        val manager = supportFragmentManager
        val withTextViewFragment = manager.findFragmentById(R.id.fragment_withTextView) as WithTextViewFragment?
        withTextViewFragment!!.changeText(data)
    }
}
