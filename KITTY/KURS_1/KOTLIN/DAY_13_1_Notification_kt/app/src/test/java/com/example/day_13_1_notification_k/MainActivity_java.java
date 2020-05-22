package com.example.day_13_1_notification_k;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity_java extends AppCompatActivity {
    private static final int NOTIFY_ID = 101;
    private static int counter = 101;
    // Это просто номер уведомления чтобы они отличались друг от друга.
    // Ведь вы можете создать идеальное приложение, которое уведомляло бы хозяина,
    // что кота надо покормить (первое уведомление), погладить (второе уведомление),
    // почистить лоток (третье уведомление). Если у вас будет один идентификатор,
    // то каждое новое уведомление затрёт предыдущее. Тогда нужно разные номера.836

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0,notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = this.getResources();

        // до версии Android 8.0 API 26 NotificationCompat
        Notification.Builder builder = new Notification.Builder(this);

        builder.setContentIntent(contentIntent)
                // обязательные настройки
                .setSmallIcon(R.drawable.ic_launcher_cat)
                //.setContentTitle(res.getString(R.string.notifytitle)) // Заголовок уведомления
                .setContentTitle("Напоминание")
                //.setContentText(res.getString(R.string.notifytext))
                .setContentText("Пора покормить кота") // Текст уведомления
                // необязательные настройки
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hungrycat)) // большая
                // картинка
                //.setTicker(res.getString(R.string.warning)) // текст в строке состояния
                .setTicker("Последнее китайское предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setColor(Color.GREEN)
                .setAutoCancel(true); // автоматически закрыть уведомление после нажатия

       // NotificationManager notificationManager =
         //       (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // Альтернативный вариант
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        //NotificationManager notificationManager = NotificationManager.from(this);

        //notificationManager.notify(NOTIFY_ID, builder.build());
        notificationManager.notify(counter++, builder.build());

    }

    public void onClick2(View view) {
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.alexanderklimov.ru/android/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Посетите мой сайт")
                .setContentText("http://developer.alexanderklimov.ru/android/")
                .setTicker("Внимание!")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)

                //Можно установить бесконечное выполнение:
                 .setProgress(100, 50, false);;

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFY_ID, builder.build());
    }

    public void onProsto(View view) {
        Intent intent = new Intent();

        Notification.Builder builder = new Notification.Builder(this);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setContentIntent(contentIntent)
        // обязательные настройки особенно превая
                .setSmallIcon(R.drawable.alert)
                //.setContentTitle(res.getString(R.string.notifytitle))
                .setContentTitle("Напоминание Просто")  // Заголовок уведомления необязателен
                //.setContentText(res.getString(R.string.notifytext))
               // .setContentText("Пора покормить Собак") // Текст уведомления необязателен

                    ;
        long[] vibrate = new long[] { 1000, 1000, 1000, 1000, 1000 };
        builder.setVibrate(vibrate);
        //builder.setDefaults(DEFAULT_ALL);//  = DEFAULT_ALL;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFY_ID-10, builder.build());

    }

    public void onClear(View view) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // Удаляем конкретное уведомление
       // notificationManager.cancel(NOTIFY_ID);

// Удаляем все свои уведомления
        notificationManager.cancelAll();
    }

    public void onAnime(View view) {
        Context context = getApplicationContext();

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(android.R.drawable.stat_sys_upload)
                //.setSmallIcon(R.   drawable.stat_notify_wifi_in_range)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hungrycat))
                .setTicker("Последнее китайское предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота"); // Текст уведомления

        Notification n = builder.getNotification();

        nm.notify(NOTIFY_ID, n);

    }

    public void sendActionNotification(View view) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // Намерение для запуска второй активности
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Строим уведомление
        Notification builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Посылка")
                .setContentText(
                        "Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.drawable.ic_add_circle_outline_black_24dp).setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_add_circle_outline_black_24dp, "Да", pendingIntent)
                .addAction(R.drawable.ic_add_circle_outline_black_24dp, "Нет", pendingIntent)
                .addAction(R.drawable.ic_add_circle_outline_black_24dp, "Другой вариант", pendingIntent)
                .build();

        // убираем уведомление, когда его выбрали
        builder.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, builder);
    }

    public void sendBigTextStyleNotification(View view) {
    }

    public void sendBigPictureStyleNotification(View view) {
    }

    public void sendInboxStyleNotification(View view) {
    }
}
    /* new Notification.Builder(this.getApplicationContext())
        .setAutoCancel(boolean autoCancel)
        .setContent(RemoteViews views)
        .setContentInfo(CharSequence info)
        .setContentIntent(PendingIntent intent)
        .setContentText(CharSequence text)
        .setContentTitle(CharSequence title)
        .setDefaults(int defaults)
        .setDeleteIntent(PendingIntent intent))
        .setFullScreenIntent(PendingIntent intent, boolean highPriority)
        .setLargeIcon(Bitmap icon)
        .setLights(int argb, int onMs, int offMs)
        .setNumber(int number)
        .setOngoing(boolean ongoing)
        .setOnlyAlertOnce(boolean onlyAlertOnce)
        .setPriority(int pri)
        .setProgress(int max, int progress, boolean indeterminate)
        .setShowWhen(boolean show)
        .setSmallIcon(int icon, int level)
        .setSmallIcon(int icon)
        .setSound(Uri sound)
        .setSound(Uri sound, int streamType)
        .setStyle(Notification.Style style)
        .setSubText(CharSequence text)
        .setTicker(CharSequence tickerText, RemoteViews views)
        .setTicker(CharSequence tickerText)
        .setUsesChronometer(boolean b)
        .setVibrate(long[] pattern)
        .setWhen(long when)
        .addAction(int icon, CharSequence title, PendingIntent intent)
        .build()

        setSmallIcon() устанавливает маленький значок, который выводится в строке состояния, а также в правой части открытого уведомления.
        setLargeIcon() устанавливает большой значок, который выводится в открытом уведомлении слева.
        setWhen() определяет время для уведомления, по умолчанию время создания уведомления
        setTicker() выводит временную строку в строке состояния, которая затем исчезает. Остаётся только маленький значок (см. выше)
        setNumber() добавляет число справа от уведомления (не везде работает)
        setShowWhen() - показывать ли время в уведомлении (в Android 7.0 по умолчанию не показывается)
        setUsesChronometer() выводит счётчик вместо времени, показывающий сколько прошло от времени when. Полезно для уведомления секундомера или звонка
        setContentInfo() добавляет текст справа от уведомления (в новых версиях сверху)
        setColor() закрашивает значок и название приложения указанным цветом
        setOngoing() выводит уведомление поверх обычных уведомлений, такое уведомление нельзя закрыть или смахнуть.
        setVibrate() - виброзвонок
        setSound() - звук
        setLights() - цвет LED-индикатора
        setPriority() устанавливает приоритет от -2 (NotificationCompat.PRIORITY_MIN) до 2 (NotificationCompat.PRIORITY_MAX)
        setTimeoutAfter() (появилось в API 26) - устанавливает таймаут, после которого уведомление удалится
        setProgress() - индикатор прогресса
    */