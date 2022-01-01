package com.example.day_31_2_list_fragment_k


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter

import androidx.fragment.app.ListFragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


// Если подклюить этот модуль к разметке activity_main то будет список без выбора - шаг 1
// нужны только MainActivity -стандарт
// activity_main.xml с <fragment
// и подключение android:name="com.example.day_31_2_list_fragment_k.SingleListFragment_1"
// больше ничего не надо но и ничего не выбирается
// продолжение в SingleListFragment

class SingleListFragment_2 : ListFragment() {
    // определяем массив типа String
    internal val catNames = arrayOf("Рыжик", "Барсик", "Мурзик", "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Масяня", "Симба")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // создаем новый адаптер со стандартной разметкой и ссылкой на массив catNames
        val adapter = activity?.let {
            ArrayAdapter(
                it.applicationContext,
                //   android.R.layout.simple_list_item_1, catNames)
                android.R.layout.simple_list_item_activated_1, catNames)
        }
        listAdapter = adapter
        //  java: setListAdapter(adapter); связываем адапртер с массивом
        // если не связать - не будет списка и будет empty - по умолчанию
    }
// затем прямо поверх-вместо стандартной разметки загружаем свою из xml
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.listfragment, null)
    }
}

// Для связывания данных используются
// адаптеры ListAdapter, ArrayAdapter, SimpleAdapter, SimpleCursorAdapter и т.д.
// Подключение следует производить в методе onActivityCreated().
// Стандартная разметка подгружается автоматически, simple_list_item_1
//Если вы хотите видеть выбранный элемент постоянно активным,
// то используйте другую системную разметку simple_list_item_activated_1.
// для собственной разметки используйте метод onCreateView().
// создадим свою разметку listfragment_2.xml и подключим ее в SingleListFragment_2
// см SingleListFragment_2

