package com.example.velic.day_28_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeBroadcastReceiver extends BroadcastReceiver {
    public TimeBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder msgStr = new StringBuilder("Текущее время: ");
        Format formatter = new SimpleDateFormat("hh:mm:ss a");
        msgStr.append(formatter.format(new Date()));
        Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show();
        Log.d("DAY_28", "onReceive: "+msgStr);
    }
}