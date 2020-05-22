package com.example.singleton;

import android.util.Log;

//Это класс в котором определен статический экземпляр этого же класса.
// В методе getInstance (), если этот экземпляр еще не был инициализирован,
// то вызывается конструктор. Сам конструктор определен как private,
// а значит мы не можем вне этого класса создать экземпляр с помощью оператора new.

public class MySingleton_java {
    private static MySingleton_java mInstance;
    private String MyVariable;
    private static  int i = 0;

   /* public static MySingleton_java getInstance() {
        Log.w("MY_TAG", "MySingleton_k::getInstance()");
        if (mInstance == null) {
            mInstance = new MySingleton_java();
        }
        return mInstance;
    }*/
   public static void initInstance() {
       Log.d("MY", "MySingleton_k::InitInstance()");
       if (mInstance == null) {
           mInstance = new MySingleton_java();
       }

   }
    public static MySingleton_java getInstance() {
        Log.d("MY", "MySingleton_k::getInstance() MySingleton_java");
        return mInstance;
    }


    private MySingleton_java() {
        Log.w("MY_TAG", "MySingleton_k::MySingleton_k()");
        MyVariable = "This is my Variable MySingleton_java";
    }

    public String getMyVariable() {
        return MyVariable;
    }

    public void setMyVariable(String var) {
        MyVariable = var;
    }
}
