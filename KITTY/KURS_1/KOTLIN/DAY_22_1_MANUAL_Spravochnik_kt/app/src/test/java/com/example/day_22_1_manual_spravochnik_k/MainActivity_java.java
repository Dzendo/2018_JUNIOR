package com.example.day_22_1_manual_spravochnik_k;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
// Как сделать простой список из массива, используя ListView
//Как загрузить текст из ресурсов
//Как загрузить html-текст в WebView
//Как передать данные из одной активности в другую

public class MainActivity_java extends AppCompatActivity {

    //Создаем массив разделов:
    private String titles[] = {
            "00. Начало",
            "01. Чем кормить кота.",
            "02. Как гладить кота.",
            "03. Как спит кот.",
            "04. Как играть с котом.",
            "05. Как разговаривать с котом",
            "06. Интересные факты из жизни котов.",
            "07. Как назвать кота.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity_java.this, DetailActivity.class);

                intent.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }
}
