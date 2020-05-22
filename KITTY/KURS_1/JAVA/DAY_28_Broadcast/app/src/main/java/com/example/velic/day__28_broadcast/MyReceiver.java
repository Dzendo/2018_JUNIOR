package com.example.velic.day__28_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//приведенный   пример на 85% работает на Android 5.1.1(реал+емулятор) и 7.1.1
//приведенный пример на 85% НЕ работает на Android 8,1 и 9 (8+)
// Эмулятор 28,0,1 на x86
// Если Target SDK Version 8 или 9 то под емулятором 8 и 9 НЕ работает
// Если Target SDK Version 7,1,1 то под емулятором 8 и 9  РАБОТАЕТ
//Как одно из изменений, которые вводит Android 8.0 (API level 26) улучшите время работы от батарей,
// когда Ваше приложение входит в кэшированные состояние, без активного компоненты,
// система выпускает любые wakelockss, что приложение держит.
//
// В добавлении, для того чтобы улучшить представление прибора,
// система ограничивает некоторое поведение приложений, которые не работают на переднем плане.
// Конкретно:
//        Приложения, которые работают в фоновом режиме теперь имеют ограничения на то,
//          как свободно они могут получить доступ к фоновым службам.
//  !!!      Приложения не могут использовать свои манифесты для регистрации
//          для большинства неявных трансляций
//          (то есть, трансляции, которые не направлены специально на приложение).
//  !!!      По умолчанию эти ограничения применяются только к приложениям, предназначенным для O.
//           однако, пользователи могут включить эти ограничения для любого приложения из настроек
//           экрана, даже если приложение не targetted О.


public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d("DAY_28", "onReceive: "+intent);

        if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            String message = "Обнаружено сообщение "
                    + intent.getAction();

            Toast.makeText(context, message,
                    Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(context, "Обнаружено сообщение: " +
                            intent.getStringExtra("com28"),
                    Toast.LENGTH_LONG).show();
    }
}
