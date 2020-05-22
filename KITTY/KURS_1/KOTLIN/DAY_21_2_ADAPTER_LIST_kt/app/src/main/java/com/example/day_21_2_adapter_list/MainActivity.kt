package com.example.day_21_2_adapter_list

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*
// Долгое нажатие и удаление элемента списка
class MainActivity : ListActivity(), AdapterView.OnItemLongClickListener {

    internal val catNamesArray = arrayOf("Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
    "Томасина", "Бобик", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба")
    // Сам по себе массив строк является неизменяемым, и чтобы мы могли удалять пункты из списка,
    // необходимо сконвертировать его в специальный объект ArrayList<String>,
    // который является изменяемым, а уже новый объект отдадим адаптеру.
    private var mAdapter: ArrayAdapter<String>? = null
    private val catNamesList = ArrayList(Arrays.asList(*catNamesArray))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customlist)

        mAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, catNamesList)
        listAdapter = mAdapter
        listView.onItemLongClickListener = this
    }
    // нажатие и и выбор элемента списка
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        Toast.makeText(applicationContext,
                //      "Вы выбрали " + (position + 1) + " элемент", Toast.LENGTH_SHORT).show();
           "Вы выбрали " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
    }
    // Долгое нажатие и удаление элемента списка
    override fun onItemLongClick(parent: AdapterView<*>, view: View, position: Int, id: Long): Boolean {
        val selectedItem = parent.getItemAtPosition(position).toString()

        mAdapter!!.remove(selectedItem)
        mAdapter!!.notifyDataSetChanged()

        Toast.makeText(applicationContext,
                "$selectedItem удалён.",
                Toast.LENGTH_SHORT).show()
        return true

    }
}
