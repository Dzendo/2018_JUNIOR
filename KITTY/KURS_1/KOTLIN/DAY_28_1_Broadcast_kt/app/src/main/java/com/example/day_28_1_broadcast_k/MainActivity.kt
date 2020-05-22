package com.example.day_28_1_broadcast_k

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val NEW_CAT_DETECTED = "com.example.day_28_1_broadcast_k"
    val ALARM_MESSAGE = "Срочно пришлите кота!"
    private val CatName = "Бандит"
    private val currentLongitude = 0.0
    private val currentLatitude = 0.0

    val WHERE_MY_CAT_ACTION = "com.example.day_28_1_broadcast_k.action.CAT"

    private val mTimeBroadCastReceiver = TimeBroadcastReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val intent = Intent(NEW_CAT_DETECTED)
        intent.putExtra("catname", CatName)
        intent.putExtra("longitude", currentLongitude)
        intent.putExtra("latitude", currentLatitude)
        //начиная с Android 3.0, в целях безопасности сообщения будут игнорироваться
        // остановленными приложениями, чтобы они не запускались.
        // Поэтому следует добавлять дополнительный флаг, разрешающий запуск активности.
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)

        //Существуют также родственные методы sendStickyBroadcast() и sendOrderedBroadcast().
        sendBroadcast(intent) */
    }

    fun onSend(view: View) {

        val intent = Intent()
        intent.action = "com.example.day_28_1_broadcast_k"
        intent.putExtra("com28", ALARM_MESSAGE)
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent)
        Log.d("DAY_28", "onSend: $intent  $ALARM_MESSAGE")
    }
    // эта регистрация без Манифеста
    // регистрируем широковещательный приёмник
    // для намерения "android.intent.action.TIME_TICK".
    // Данное намерение срабатывает каждую минуту
    fun registerBroadcastReceiver(view: View) {
        this.registerReceiver(mTimeBroadCastReceiver, IntentFilter(
                "android.intent.action.TIME_TICK"))
        Toast.makeText(applicationContext, "Приёмник включен",
                Toast.LENGTH_SHORT).show()
    }

    // Отменяем регистрацию
    fun unregisterBroadcastReceiver(view: View) {
        this.unregisterReceiver(mTimeBroadCastReceiver)

        Toast.makeText(applicationContext, "Приёмник выключён", Toast.LENGTH_SHORT)
                .show()
    }
}
