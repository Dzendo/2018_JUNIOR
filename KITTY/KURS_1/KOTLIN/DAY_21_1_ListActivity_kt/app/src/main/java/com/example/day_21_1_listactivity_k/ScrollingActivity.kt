package com.example.day_21_1_listactivity_k

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*
import java.util.Arrays.asList



class ScrollingActivity : ListActivity() {


    private val mMonthArray = arrayOf("Январь", "Февраль", "Котомарт", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")

    private val mDayOfWeekArray = arrayOf("Понедельник", "Вторник", "Среда",
            "Четверг", "Котопятница", "Субкота", "Воскресенье")



    // У нас есть намерение создать экран со списком и сами слова для списка.
    // Необходим некий посредник, который свяжет эти звенья в одно целое.
    // Для подобных целей в Android существует понятие адаптера данных и
    // его определение для работы с массивами строк выглядит так:
    // new ArrayAdapter(Context context, int textViewResourceId, String[] objects)

    // Создадим два адаптера
    private var mMonthAdapter: ArrayAdapter<String>? = null
    private var mWeekOfDayAdapter: ArrayAdapter<String>? = null
    private var mMonth: String? = null
    private var mDayOfWeek: String? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // android.R.layout.simple_list_item_1
        // В ней уже содержится необходимая разметка для отдельного элемента списка,
        // которая состоит из одного компонента TextView
        mMonthAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, mMonthArray)
        mWeekOfDayAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, mDayOfWeekArray)

        listAdapter = mMonthAdapter
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        if (listAdapter === mMonthAdapter) {
            mMonth = l.getItemAtPosition(position) as String
            listAdapter = mWeekOfDayAdapter
            mWeekOfDayAdapter!!.notifyDataSetChanged()
        } else {
            mDayOfWeek = l.getItemAtPosition(position) as String
            listAdapter = mMonthAdapter
            mMonthAdapter!!.notifyDataSetChanged()
            Toast.makeText(baseContext, "$mMonth: $mDayOfWeek",
                    Toast.LENGTH_LONG).show()
        }
    }
}
