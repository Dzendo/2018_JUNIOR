package com.example.day_28_1_broadcast_k

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date

class BootReceiver : BroadcastReceiver() {
    private lateinit var mContext: Context
    private val BOOT_ACTION = "android.intent.action.BOOT_COMPLETED"
    override fun onReceive(context: Context, intent: Intent) {
        mContext = context
        val action = intent.action
        if (action!!.equals(BOOT_ACTION, ignoreCase = true)) {
            // здесь ваш код
            // например, запускаем уведомление
            //Intent intent = new Intent(context, ru.alexanderklimov.NotifyService.NotifyService.class);
            //context.startService(intent);
            // в общем виде
            //для Activity
            val activivtyIntent = Intent(context, MainActivity::class.java)
            activivtyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(activivtyIntent)

            //для Service
            //Intent serviceIntent = new Intent(context, MyService.class);
            //context.startService(serviceIntent);
            Log.d("DAY_28", "onStart: ")
            val msgStr = StringBuilder("Текущее время: ")
            val formatter = SimpleDateFormat("hh:mm:ss a")
            msgStr.append(formatter.format(Date()))
            Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show()
            Log.d("DAY_28", "AUTOSTART: $msgStr")
        }
    }
}
