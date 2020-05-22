package com.example.day_28_1_broadcast_k

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

import java.text.SimpleDateFormat
import java.util.Date

class TimeBroadcastReceiver : BroadcastReceiver() {
        // Регистрируется программно затем слушает время
    override fun onReceive(context: Context, intent: Intent) {
        val msgStr = StringBuilder("Текущее время: ")
        val formatter = SimpleDateFormat("hh:mm:ss a")
        msgStr.append(formatter.format(Date()))
        Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show()
        Log.d("DAY_28", "onReceive: $msgStr")
    }
}
