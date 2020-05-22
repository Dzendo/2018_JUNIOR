package com.example.velic.day_21_adapter;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity implements AdapterView.OnItemLongClickListener {
    final String[] catNamesArray = new String[] { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
            "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> catNamesList = new ArrayList<>(Arrays.asList(catNamesArray));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlist);
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNamesList);
        setListAdapter(mAdapter);
        getListView().setOnItemLongClickListener(this);

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(),
          //      "Вы выбрали " + (position + 1) + " элемент", Toast.LENGTH_SHORT).show();
              "Вы выбрали " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?>parent, View view,int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();

        mAdapter.remove(selectedItem);
        mAdapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(),
                selectedItem + " удалён.",
                Toast.LENGTH_SHORT).show();
        return true;

    }
}
