package com.example.day_31_1_list_fragment_k


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter

import androidx.fragment.app.ListFragment

class SingleListFragment_1 : ListFragment() {
    // определяем массив типа String
    internal val catNames = arrayOf("Рыжик", "Барсик", "Мурзик", "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Масяня", "Симба")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = ArrayAdapter(activity!!,
                android.R.layout.simple_list_item_1, catNames)
        listAdapter = adapter
    }
}
