package com.example.velic.day_24_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "ОТЛАДКА MainActivity";

    // имя файла настройки
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;

    private Button mCrowsCounterButton;
    private Button mCatsCounterButton;
    private TextView helloTextView;
    public int mCountCrows = 0;
    public int mCountCats = 0;

    private static final String KEY_COUNT_Cats = "COUNT_CATS";
    private static final String KEY_COUNT_Crows = "COUNT_CROWS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");




        helloTextView = findViewById(R.id.textView);
        mCrowsCounterButton = findViewById(R.id.button_Counter_Crows);
        mCatsCounterButton = findViewById(R.id.button_Сounter_Сats);
        /*mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
          helloTextView.setText("Я насчитал " + ++mCount + " ворон");
                                                   }
                                               });
         */
        mCrowsCounterButton.setOnClickListener(v ->
                helloTextView.setText("Я насчитал " + ++mCountCrows + " ворон"));
        mCatsCounterButton.setOnClickListener(v ->
                helloTextView.setText("Я насчитал " + ++mCountCats + " котов"));

    }
    public void onClick(View view) {
        helloTextView.setText("Hello Kitty! ");
    }

    public void onClickClear(View view) {
        mCountCrows = 0;
        mCountCats = 0;
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    // поднятие из сохранение для переворота вызывается только если bundle != null и идет рестарт
    // по-моему если прибита была активность андроидом а не пользователем
    // после закрытия программы восстановления не будет
    @Override
    protected  void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
        // Если экран певернули:
        //if (savedInstanceState != null) {
            mCountCats  = savedInstanceState.getInt(KEY_COUNT_Cats, 0);
            mCountCrows = savedInstanceState.getInt(KEY_COUNT_Crows,1);
            helloTextView.setText("Восстановили из savedInstanceState "
                    + mCountCats + " Котов " + mCountCrows + " ворон");
        //}
    }


        @Override
        protected void onRestart(){
            super.onRestart();
            Log.d(TAG, "onRestart");
        }
    // поднятие из сохранение  вызывается
    // после закрытия программы восстановление будет
        @Override
        protected void onResume(){
            super.onResume();
            Log.d(TAG, "onResume");
            //Настройка для сохранения Settings в файле
            mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            //getPreferences() — внутри активности, чтобы обратиться к определенному для активности предпочтению;
            //getSharedPreferences() — внутри активности, чтобы обратиться к предпочтению на уровне приложения;
            //getDefaultSharedPreferences() — из объекта PreferencesManager, чтобы получить общедоступную настройку,
            // предоставляемую Android.
            if (mSettings.contains(KEY_COUNT_Cats)) {
                // Получаем число из настроек
                mCountCats = mSettings.getInt(KEY_COUNT_Cats, 0);
                mCountCrows = mSettings.getInt(KEY_COUNT_Crows, 0);
                // Выводим на экран данные из настроек
                helloTextView.setText("Восстановили из Settings "
                        + mCountCats + " Котов " + mCountCrows + " ворон");
            }
        }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }
    // Сохранение для переворота вызывается только если  идет рестарт например переворот
    // по-моему если прибивает активность андроид а не пользователь
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT_Cats, mCountCats);
        outState.putInt(KEY_COUNT_Crows, mCountCrows);
        Log.d(TAG, "onSaveInstanceState");
    }
    // Сохранение вызывается всегда
       @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
        // Запоминаем данные Setting
        SharedPreferences.Editor editor = mSettings.edit();
        //editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
        editor.putInt(KEY_COUNT_Cats, mCountCats);
        editor.putInt(KEY_COUNT_Crows, mCountCrows);
        editor.apply();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}

