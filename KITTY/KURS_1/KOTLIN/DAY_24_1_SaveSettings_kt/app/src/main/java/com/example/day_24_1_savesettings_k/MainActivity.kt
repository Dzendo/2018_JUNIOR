package com.example.day_24_1_savesettings_k

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = "ОТЛАДКА MainActivity"

    // имя файла настройки:
    val APP_PREFERENCES = "mysettings"
    // переменную, представляющую экземпляр класса SharedPreferences,
    // который отвечает за работу с настройками:
    private lateinit var pref: SharedPreferences

    var mCountCrows = 0
    var mCountCats  = 0

    private val KEY_COUNT_Cats  = "COUNT_CATS"
    private val KEY_COUNT_Crows = "COUNT_CROWS"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        button_Counter_Crows.setOnClickListener { textView.text = "Я насчитал " + ++mCountCrows + " ворон" }
        button_Сounter_Сats. setOnClickListener { textView.text = "Я насчитал " + ++mCountCats + " котов" }

    }

    fun onClick(view: View) {
        textView.text = "Hello Kitty! "
    }

    fun onClickClear(view: View) {
        mCountCrows = 0
        mCountCats = 0
        textView.text =""
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    // поднятие из сохранение для переворота вызывается только если bundle != null и идет рестарт
    // по-моему если прибита была активность андроидом а не пользователем
    // после закрытия программы восстановления не будет
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
        // Если экран певернули:
        //if (savedInstanceState != null) {
        mCountCats  = savedInstanceState.getInt(KEY_COUNT_Cats, 0)
        mCountCrows = savedInstanceState.getInt(KEY_COUNT_Crows, 1)
        textView.text = ("Восстановили из savedInstanceState \n"
                + "$mCountCats Котов $mCountCrows  ворон")
        //}
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    // поднятие из сохранение  вызывается
    // после закрытия программы восстановление будет
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        //Настройка для сохранения Settings в файле
        pref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        //getPreferences() — внутри активности, чтобы обратиться к определенному для активности предпочтению;
        //getSharedPreferences() — внутри активности, чтобы обратиться к предпочтению на уровне приложения;
        //getDefaultSharedPreferences() — из объекта PreferencesManager, чтобы получить общедоступную настройку,
        // предоставляемую Android.
        if (pref.contains(KEY_COUNT_Cats)) {
            // Получаем число из настроек
            mCountCats  = pref.getInt(KEY_COUNT_Cats,  0)
            mCountCrows = pref.getInt(KEY_COUNT_Crows, 0)
            // Выводим на экран данные из настроек
            textView.text = ("Восстановили из Settings \n"
                    + "$mCountCats Котов $mCountCrows ворон")
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        // Запоминаем данные
        val editor = pref.edit()
        editor.putInt(KEY_COUNT_Cats,  mCountCats)
        editor.putInt(KEY_COUNT_Crows, mCountCrows)
        editor.apply()

    }

    // Сохранение для переворота вызывается только если  идет рестарт например переворот
    // по-моему если прибивает активность андроид а не пользователь
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT_Cats,  mCountCats )
        outState.putInt(KEY_COUNT_Crows, mCountCrows)
        Log.d(TAG, "onSaveInstanceState")
    }

    // Сохранение вызывается всегда
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        // Запоминаем данные Setting
        val editor = pref.edit()

        editor.putInt(KEY_COUNT_Cats, mCountCats)
        editor.putInt(KEY_COUNT_Crows, mCountCrows)
        editor.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
