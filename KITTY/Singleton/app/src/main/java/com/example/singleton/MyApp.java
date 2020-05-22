package com.example.singleton;

import android.app.Application;
import android.util.Log;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("MY", "onCreate MyApp");

        MySingleton_java.initInstance();
       // MySingleton_kotlin.initInstance();
        new MySingleton_kotlin();
    }
}
