package com.example.singleton

import android.util.Log
//Это класс в котором определен статический экземпляр этого же класса.
// В методе getInstance (), если этот экземпляр еще не был инициализирован,
// то вызывается конструктор. Сам конструктор определен как private,
// а значит мы не можем вне этого класса создать экземпляр с помощью оператора new.

class MySingleton_k private constructor() {
    var myVariable: String? = null

    init {
        Log.w("MY_TAG", "MySingleton_k::MySingleton_k()")
        myVariable = "This is my Variable = MySingleton_k $i "
    }

    companion object {
        var i=0
        @JvmStatic
        private var mInstance: MySingleton_k? = null

        @JvmStatic
        val instance: MySingleton_k
            get() { i++
                Log.w("MY_TAG", "MySingleton_k::getInstance()")
                if (mInstance == null) {
                    mInstance = MySingleton_k()
                }
                return mInstance!!
            }
    }
}
