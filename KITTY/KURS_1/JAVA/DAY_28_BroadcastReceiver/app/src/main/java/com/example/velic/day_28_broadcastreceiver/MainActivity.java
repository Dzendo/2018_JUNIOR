package com.example.velic.day_28_broadcastreceiver;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TimeBroadcastReceiver mTimeBroadCastReceiver = new TimeBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // регистрируем широковещательный приёмник
    // для намерения "android.intent.action.TIME_TICK".
    // Данное намерение срабатывает каждую минуту
    public void registerBroadcastReceiver(View view) {
        this.registerReceiver(mTimeBroadCastReceiver, new IntentFilter(
                "android.intent.action.TIME_TICK"));
        Toast.makeText(getApplicationContext(), "Приёмник включен",
                Toast.LENGTH_SHORT).show();
    }

    // Отменяем регистрацию
    public void unregisterBroadcastReceiver(View view) {
        this.unregisterReceiver(mTimeBroadCastReceiver);

        Toast.makeText(getApplicationContext(), "Приёмник выключён", Toast.LENGTH_SHORT)
                .show();
    }
}
