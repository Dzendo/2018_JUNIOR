package com.example.day_31_1_list_fragment_k
// проект сконвертирован из 31_1 с трудом запущен - правильный лежит в 31_2_к

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

//Начнём с простых примеров.
// Мы знаем, что для создания списка используется компонент ListView.
// Если наш экран должен состоять только из списка,
// то можно использовать готовую активность ListActivity,
// в которой уже встроен список и реализованы необходимые методы.
//
//ListFragment работает по такому же принципу.
// По сути это обычный фрагмент, в который встроили ListView,
// избавив нас от написания лишнего кода.

//Как правило, ListFragment используют в паре с другим обычным фрагментом.
// А пока мы попробуем обойтись одним фрагментом.

//Посмотрим, как выглядит данный фрагмент по умолчанию.
// Мы не будем создавать свою разметку и свой адаптер,
// так как списочный фрагмент уже включает в себя необходимые компоненты.

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"", Toast.LENGTH_SHORT).show();
    }
}

//Не будем ничего выдумывать,
// а просто скопируем массив строк из урока про ListView и вставим его в класс фрагмента.
// А в методе onActivityCreated() свяжем массив с адаптером и передадим его списочному фрагменту.

//Если вы хотите видеть выбранный элемент постоянно активным, то используйте другую системную разметку simple_list_item_activated_1
//Если нужна своя разметка для списка, то поступаем точно также, как в уроке с ListActivity.
// Создаём в папке res/layout новый файл, скажем listfragment.xml и размещаем нужные элементы: