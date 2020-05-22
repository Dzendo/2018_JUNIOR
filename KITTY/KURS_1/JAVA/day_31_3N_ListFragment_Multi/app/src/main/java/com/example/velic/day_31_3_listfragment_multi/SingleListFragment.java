package com.example.velic.day_31_3_listfragment_multi;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

public class SingleListFragment extends ListFragment {

    // определяем массив типа String
    final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
            "Кузя", "Китти", "Масяня", "Симба"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
// создаем новый адаптер со стандартной разметкой и ссылкой на массив catNames
        ListAdapter adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, catNames);
        setListAdapter(adapter);
        //  java: setListAdapter(adapter); связываем адапртер с массивом
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment, null);
        // затем прямо поверх-вместо стандартной разметки загружаем свою из xml
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Шаг 3 подключение через стандартный слушатель onListItemClick

        String prompt = "Вы выбрали: "
                + getListView().getItemAtPosition(position).toString() + "\n\n";

        prompt += "Выбранные элементы: \n";
        SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();

        int count = getListView().getCount();
        for (int i = 0; i < count; i++) {
            if (sparseBooleanArray.get(i)) {
                prompt += getListView().getItemAtPosition(i).toString() + "\n";
            }
        }
        Toast.makeText(getActivity(), prompt, Toast.LENGTH_LONG).show();
    }
}