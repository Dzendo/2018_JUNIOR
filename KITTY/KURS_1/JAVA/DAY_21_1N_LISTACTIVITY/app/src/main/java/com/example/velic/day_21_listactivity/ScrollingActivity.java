package com.example.velic.day_21_listactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ScrollingActivity extends ListActivity {

    private String[] mMonthArray = { "Январь", "Февраль", "Котомарт", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь",
            "Декабрь", "Январь", "Февраль", "Котомарт", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь",
            "Декабрь" };

    private String[] mDayOfWeekArray = new String[] { "Понедельник", "Вторник", "Среда",
            "Четверг", "Котопятница", "Субкота", "Воскресенье" };

    // У нас есть намерение создать экран со списком и сами слова для списка.
    // Необходим некий посредник, который свяжет эти звенья в одно целое.
    // Для подобных целей в Android существует понятие адаптера данных и
    // его определение для работы с массивами строк выглядит так:
    // new ArrayAdapter(Context context, int textViewResourceId, String[] objects)

    // Создадим два адаптера
    private ArrayAdapter<String> mMonthAdapter, mWeekOfDayAdapter;
    private String mMonth, mDayOfWeek;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // android.R.layout.simple_list_item_1
        // В ней уже содержится необходимая разметка для отдельного элемента списка,
        // которая состоит из одного компонента TextView
        mMonthAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mMonthArray);
        mWeekOfDayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mDayOfWeekArray);

        setListAdapter(mMonthAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (getListAdapter() == mMonthAdapter) {
            mMonth = (String) l.getItemAtPosition(position);
            setListAdapter(mWeekOfDayAdapter);
            mWeekOfDayAdapter.notifyDataSetChanged();
        } else {
            mDayOfWeek = (String) l.getItemAtPosition(position);
            Toast.makeText(getBaseContext(), mMonth + ": " + mDayOfWeek,
                    Toast.LENGTH_LONG).show();
            setListAdapter(mMonthAdapter);
            mMonthAdapter.notifyDataSetChanged();
        }
    }
}
