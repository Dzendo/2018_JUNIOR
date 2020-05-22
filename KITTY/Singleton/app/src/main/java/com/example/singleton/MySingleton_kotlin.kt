package com.example.singleton

import android.util.Log

//Это класс в котором определен статический экземпляр этого же класса.
// В методе getInstance (), если этот экземпляр еще не был инициализирован,
// то вызывается конструктор. Сам конструктор определен как private,
// а значит мы не можем вне этого класса создать экземпляр с помощью оператора new.

class MySingleton_kotlin {
    var myVariable: String = "This is my Variable MySingleton_kotlin  "


   /* init {
        Log.w("MY_TAG", "MySingleton_k::MySingleton_k()")
        myVariable = "This is my Variable MySingleton_kotlin $i "
    }*/

    companion object {
        @JvmStatic
        val mInstance: MySingleton_kotlin = MySingleton_kotlin()
        //var mInstance: MySingleton_kotlin? = null

        /* public static MySingleton_java getInstance() {
        Log.w("MY_TAG", "MySingleton_k::getInstance()");
        if (mInstance == null) {
            mInstance = new MySingleton_java();
        }
        return mInstance;
    }*/
      /*  @JvmStatic
        fun initInstance() {
            Log.d("MY", "MySingleton_k::InitInstance() MySingleton_kotlin")
            if (mInstance == null) {
                mInstance = MySingleton_kotlin()
            }

        }


        @JvmStatic
        val instance: MySingleton_kotlin?
            get() {
                Log.d("MY", "MySingleton_k::getInstance() MySingleton_kotlin")
                return mInstance
            }*/
    }
}
