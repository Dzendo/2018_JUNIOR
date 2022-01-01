package com.example.day_31_3_fragment_mulyi_k

import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.forEach

import androidx.fragment.app.ListFragment

class SingleListFragment : ListFragment() {

    // определяем массив типа String
    internal val catNames = arrayOf("Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
            "Томасина", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Масяня", "Симба",
            "Томасин2", "Кристин2", "Пушок2", "Дымка2", "Кузя2", "Китти2", "Масяня2", "Симба2")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // создаем новый адаптер со стандартной разметкой и ссылкой на массив catNames
        val adapter = activity?.let {
            ArrayAdapter(
                it.applicationContext,
                android.R.layout.simple_list_item_multiple_choice, catNames)
        }
        listAdapter = adapter
        //  java: setListAdapter(adapter); связываем адапртер с массивом
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.listfragment, null)
        // затем прямо поверх-вместо стандартной разметки загружаем свою из xml
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        // Шаг 3 подключение через стандартный слушатель onListItemClick

        var prompt = ("Вы выбрали: "
                + listView.getItemAtPosition(position).toString() + "\n\n")

        prompt += "Выбранные элементы: \n"
        val sparseBooleanArray = listView.checkedItemPositions

        val count = listView.count
        for (i in 0 until count) {
            if (sparseBooleanArray.get(i)) {
                prompt += listView.getItemAtPosition(i).toString() + "\n"
            }
        }
        Toast.makeText(activity, prompt, Toast.LENGTH_LONG).show()

    }
}