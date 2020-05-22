package com.example.day_gson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String json = "{\"p_result\":\"ok\"}";
       //  Result result = new Gson().fromJson(json, Result.class);




    }

    public void To_Json(View view) {
        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.age = 9;
        murzik.color = Color.BLACK;

       // GsonBuilder builder = new GsonBuilder();
       // Gson gson = builder.create();
        Gson gson = new Gson();
        Log.i("GSON", gson.toJson(murzik));
        Toast.makeText(this, "GSON="+gson.toJson(murzik), Toast.LENGTH_LONG).show();
    }

    public void From_Json(View view) {

        String jsonText = "{'name':'Мурзик','color':-16777216,'age':8}";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Cat murzik = gson.fromJson(jsonText, Cat.class);
        Log.i("GSON", "Имя: " + murzik.name + "\nВозраст: " + murzik.age);
        Toast.makeText(this, "GSON="+"Имя: " + murzik.name + "\nВозраст: " + murzik.age, Toast.LENGTH_LONG).show();
    }

    public class Cat {

        public String name; // имя
        public int age; // возраст
        public int color; // цвет

        // Конструктор
        public Cat(){

        }
    }

}
