package com.example.singleton;

import android.util.Log;

//Это класс в котором определен статический экземпляр этого же класса.
// В методе getInstance (), если этот экземпляр еще не был инициализирован,
// то вызывается конструктор. Сам конструктор определен как private,
// а значит мы не можем вне этого класса создать экземпляр с помощью оператора new.
public class MySingleton_j {
    private static MySingleton_j mInstance;
    private String MyVariable;

    public static MySingleton_j getInstance() {
        Log.w("MY_TAG", "MySingleton::getInstance()");
        if (mInstance == null) {
            mInstance = new MySingleton_j();
        }
        return mInstance;
    }

    private MySingleton_j() {
        Log.w("MY_TAG", "MySingleton::MySingleton()");
        MyVariable = "This is my Variable";
    }

    public String getMyVariable() {
        return MyVariable;
    }

    public void setMyVariable(String var) {
        MyVariable = var;
    }


}
