package com.example.velic.day__28_broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    public static final String NEW_CAT_DETECTED = "com.example.velic.day__28_broadcast";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";
    private String CatName="Бандит";
    private double currentLongitude=0.0, currentLatitude=0.0;

    public static final String WHERE_MY_CAT_ACTION = "com.example.velic.day__28_broadcast.action.CAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent intent = new Intent(NEW_CAT_DETECTED);
        intent.putExtra("catname", CatName);
        intent.putExtra("longitude", currentLongitude);
        intent.putExtra("latitude", currentLatitude);
        //начиная с Android 3.0, в целях безопасности сообщения будут игнорироваться
        // остановленными приложениями, чтобы они не запускались.
        // Поэтому следует добавлять дополнительный флаг, разрешающий запуск активности.
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

        //Существуют также родственные методы sendStickyBroadcast() и sendOrderedBroadcast().
        sendBroadcast(intent); */
        Log.d("DAY_28", "onCreate: ");
    }

    public void onSend(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.velic.day__28_broadcast");
        intent.putExtra("com28", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
        Log.d("DAY_28", "onSend: "+intent +ALARM_MESSAGE);
    }
}
