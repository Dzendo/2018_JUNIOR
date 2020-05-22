package com.example.velic.day_28_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BootReceiver extends BroadcastReceiver {
    Context mContext;
    private final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        String action = intent.getAction();
        if (action.equalsIgnoreCase(BOOT_ACTION)) {
            // здесь ваш код
            // например, запускаем уведомление
            //Intent intent = new Intent(context, ru.alexanderklimov.NotifyService.NotifyService.class);
            //context.startService(intent);
            // в общем виде
            //для Activity
            Intent activivtyIntent = new Intent(context, MainActivity.class);
            activivtyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activivtyIntent);

            //для Service
            //Intent serviceIntent = new Intent(context, MyService.class);
            //context.startService(serviceIntent);
            Log.d("DAY_28", "onStart: ");
            StringBuilder msgStr = new StringBuilder("Текущее время: ");
            Format formatter = new SimpleDateFormat("hh:mm:ss a");
            msgStr.append(formatter.format(new Date()));
            Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show();
            Log.d("DAY_28", "AUTOSTART: "+msgStr);
        }
    }
}
