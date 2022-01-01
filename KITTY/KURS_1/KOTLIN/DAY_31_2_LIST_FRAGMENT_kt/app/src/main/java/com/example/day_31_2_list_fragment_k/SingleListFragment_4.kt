package com.example.day_31_2_list_fragment_k


import android.content.Context
import android.os.Bundle

import androidx.fragment.app.ListFragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.Gravity
import android.widget.*
import androidx.core.content.ContextCompat.getSystemService











// Если подклюить этот модуль к разметке activity_main то будет список без выбора - шаг 1
// нужны только MainActivity -стандарт
// activity_main.xml с <fragment
// и подключение android:name="com.example.day_31_2_list_fragment_k.SingleListFragment_1"
// больше ничего не надо но и ничего не выбирается
// продолжение в SingleListFragment

class SingleListFragment_4 : ListFragment() {
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
        val myListAdapter = MyListAdapter(context,
                R.layout.listfragment_row, catNames)
        listAdapter = myListAdapter

    }
// затем прямо поверх-вместо стандартной разметки загружаем свою из xml
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.listfragment, null)
    }
// Шаг 3 подключение через стандартный слушатель onListItemClick
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

    Toast.makeText(activity, "Вы выбрали позицию: $position", Toast.LENGTH_SHORT).show()
    // этот TOAST работает всегда но забивается нижним

    /*val textView = v as TextView // только для варианта 3 без разметки со значками
    val itemText = textView.text.toString() // получаем текст нажатого элемента
    Toast.makeText(activity, "Вы выбрали $position $itemText", Toast.LENGTH_SHORT).show()
     */

    // только для варианта 4 с разметкой со значками listfragment_row и listadapter myListAdapter
    val toast = Toast.makeText(activity,"Вы выбрали: $position = " +
            listView.getItemAtPosition(position).toString(),
            Toast.LENGTH_LONG)
    toast.setGravity(Gravity.TOP, 0, 0);
    toast.show();

    }

    inner class MyListAdapter(private val mContext: Context?, textViewResourceId: Int,
          objects: Array<String>) : ArrayAdapter<String>(mContext!!, textViewResourceId, objects) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // return super.getView(position, convertView, parent);

            val inflater = mContext!!
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row = inflater.inflate(R.layout.listfragment_row, parent,
                    false)
            val catNameTextView = row.findViewById(R.id.textViewName) as TextView
            catNameTextView.text = catNames[position]
            val iconImageView = row.findViewById(R.id.imageViewIcon) as ImageView

            // Присваиваем значок
            iconImageView.setImageResource(R.drawable.ic_launcher_cat)

            return row
        }
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

