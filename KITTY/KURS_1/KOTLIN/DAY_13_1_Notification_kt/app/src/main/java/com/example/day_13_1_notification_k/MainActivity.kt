package com.example.day_13_1_notification_k

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Это просто номер уведомления чтобы они отличались друг от друга.
    // Ведь вы можете создать идеальное приложение, которое уведомляло бы хозяина,
    // что кота надо покормить (первое уведомление), погладить (второе уведомление),
    // почистить лоток (третье уведомление). Если у вас будет один идентификатор,
    // то каждое новое уведомление затрёт предыдущее. Тогда нужно разные номера.836
    private val NOTIFY_ID = 101
    private var counter = 101


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickCreate(view: View) {
        textView.text = "Create"
        // простое нпоминание с возрастающим номером
        // - размножается при повторном уведомлении
        // чистится или вручную или CLEAR
        // при нажатии на него тсчезает - считается что прочитали
        val res = this.resources
        val notificationIntent = Intent(this, MainActivity::class.java)
        val contentIntent = PendingIntent.getActivity(this,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT)

        // до версии Android 8.0 API 26 NotificationCompat
        val builder = Notification.Builder(this)

        builder
                .setContentIntent(contentIntent)
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
                .setAutoCancel(true) // автоматически закрыть уведомление после нажатия

        // NotificationManager notificationManager =
        //       (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // Альтернативный вариант
        val notificationManager = NotificationManagerCompat.from(this)
        //NotificationManager notificationManager = NotificationManager.from(this);

        //notificationManager.notify(NOTIFY_ID, builder.build());
        notificationManager.notify(counter++, builder.build())

    }

    fun onClickSite(view: View) {
        textView.text = "Site"
        // предложение с бляком и без вибратора
        // когда появляется в уведомлениях то подгружает сайт пока ждет
        // при нажатии на него зовет браузер и открывает им сайт Kitty
        // после использования - исчезает
        val notificationIntent = Intent(Intent.ACTION_VIEW,
               // Uri.parse("http://developer.alexanderklimov.ru/android/"))
                Uri.parse("https://developer.android.com/guide/topics/ui/notifiers/notifications?hl=ru"))
        val pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT)

        val builder = Notification.Builder(this)
                .setContentTitle("Посетите мой сайт")
               // .setContentText("http://developer.alexanderklimov.ru/android/")
                .setContentText("https://developer.android.com/guide/topics/ui/notifiers/notifications?hl=ru")
                .setTicker("Внимание!")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)

                //Можно установить бесконечное выполнение:
                .setProgress(100, 50, false)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFY_ID, builder.build())
    }

    fun onProsto(view: View) {
        textView.text = "Prosto"
        // Напоминание просто текст с вибрацией и значком колокольчика
        // если приходят несколько то замещается - номер тот же - так можно обновлять
        // при нажатии на него не чистится - надо или направо или clear или очистка вручную
        val intent = Intent()

        val builder = Notification.Builder(this)
        val contentIntent = PendingIntent.getActivity(this,
                0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT)

        builder.setContentIntent(contentIntent)
                // обязательные настройки особенно превая
                .setSmallIcon(R.drawable.alert)
                //.setContentTitle(res.getString(R.string.notifytitle))
                .setContentTitle("Напоминание Просто")  // Заголовок уведомления необязателен
        //.setContentText(res.getString(R.string.notifytext))
        // .setContentText("Пора покормить Собак") // Текст уведомления необязателен
        val vibrate = longArrayOf(1000, 1000, 1000, 1000, 1000)
        builder.setVibrate(vibrate)
        //builder.setDefaults(DEFAULT_ALL);//  = DEFAULT_ALL;
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFY_ID - 10, builder.build())

    }

    fun onClear(view: View) {
        textView.text = "Clear"
        val notificationManager = NotificationManagerCompat.from(this)
        // Удаляем конкретное уведомление
        // notificationManager.cancel(NOTIFY_ID);

        // Удаляем все свои уведомления
        notificationManager.cancelAll()
    }

    fun onAnime(view: View) {
        textView.text = "Anime"
        val context = applicationContext

        val notificationIntent = Intent(context, MainActivity::class.java)
        val contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT)

        val nm = context
                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val res = context.resources
        val builder = Notification.Builder(context)

        builder.setContentIntent(contentIntent)
                .setSmallIcon(android.R.drawable.stat_sys_upload)
                //.setSmallIcon(R.   drawable.stat_notify_wifi_in_range)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hungrycat))
                .setTicker("Последнее китайское предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота") // Текст уведомления

        val n = builder.notification

        nm.notify(NOTIFY_ID, n)

    }

    fun sendActionNotification(view: View) {
        textView.text = "Ask"
        // Уведомление с вопросом и кнопками ответа да/нет/другое
        // прием ответа здесь не приведен
        val notificationManager = NotificationManagerCompat.from(this)
        // Намерение для запуска второй активности - т.е. готовим ответ на кнопки
        val intent = Intent(this, YesActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        // Строим уведомление
        val builder = Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Посылка")
                .setContentText(
                        "Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.drawable.ic_add_circle_outline_black_24dp)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_add_circle_outline_black_24dp, "Да", pendingIntent)
                .addAction(R.drawable.ic_add_circle_outline_black_24dp, "Нет", pendingIntent)
                .addAction(R.drawable.ic_add_circle_outline_black_24dp, "Другой вариант", pendingIntent)
                .build()

        // убираем уведомление, когда его выбрали
        builder.flags = builder.flags or Notification.FLAG_AUTO_CANCEL

        notificationManager.notify(0, builder)
    }

    fun sendBigTextStyleNotification(view: View) {
        textView.text = "Text+Text"
        // Уведомление с длинным текстом: BigTextStyle().bigText()
        run {
            val intent = Intent(this, YesActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            val builder = Notification.Builder(this)
                    .setTicker("Пришла посылка!")
                    .setContentTitle("Уведомление с большим текстом")
                    .setContentText(
                            "01 Это я, почтальон Печкин. Принес для вас посылку")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .addAction(R.mipmap.ic_launcher, "Запустить активность",
                            pendingIntent).setAutoCancel(true)

            val bigText = "1 Это я, почтальон Печкин. Принес для вас посылку. " + "Только я вам ее не отдам. Потому что у вас документов нету. "

            val notification = Notification.BigTextStyle(builder)
                    .bigText(bigText).build()

            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(1, notification)
        }
        /* мы разбили построение уведомления на две части.
         Настройка самого уведомления происходит в объекте типа Notification.Builder (cам код остался без изменений),
          а стиль уведомления задаётся уже для объекта типа Notification.
           В данном случае мы используем стиль BigTextStyle().bigText().
            В этом случае текст в setContentText() игнорируется,
             а вместо него используется отдельно заданный нами текст в строковой переменной bigText.
          */
      //  Можно добиться такого же эффекта через метод setStyle():

        run {
            val bigText = "2 Это я, почтальон Печкин. Принес для вас посылку. " + "Только я вам ее не отдам. Потому что у вас документов нету. "

            val intent = Intent(this, YesActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            val builder = NotificationCompat.Builder(this)
                    .setTicker("Пришла посылка!")
                    .setContentTitle("Уведомление с большим текстом")
                    .setContentText(
                            "02Это я, почтальон Печкин. Принес для вас посылку")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setStyle(NotificationCompat.BigTextStyle().bigText(bigText))
                    .addAction(R.mipmap.ic_launcher, "Запустить активность",
                            pendingIntent).setAutoCancel(true)

            val notification = builder.build()

            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(2, notification)
        }

    }

    fun sendBigPictureStyleNotification(view: View) {
        textView.text = "Picture"
        // Уведомление с большой картинкой: BigPictureStyle().bigPicture()
        //Пример с большой картинкой аналогичен с предыдущим примером.
        // Только мы задаём уже другой стиль для уведомления.
        // Вместо стиля длинного текста используется стиль BigPictureStyle().bigPicture():
        val intent = Intent(this, YesActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,
                0, intent, 0)

        val builder = NotificationCompat.Builder(this)

        builder.setContentTitle("Большая посылка")
                .setTicker("Пришла посылка!")
                .setContentText("Уведомление с большой картинкой")
                .setSmallIcon(R.mipmap.ic_launcher)
                // большая картинка из ресурсов
                .setStyle(NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(resources,
                                R.drawable.hungrycat)))
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher, "Запустить активность",
                        pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(22, builder.build())
    }

    fun sendInboxStyleNotification(view: View) {
        textView.text = "BOX"
        // Уведомление в стиле InboxStyle
        //Есть ещё один стиль InboxStyle, напоминающий стиль писем в папке Входящие.
        // Стиль разместит до пяти ваших строк в виде списка.
        val intent = Intent(this, YesActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,
                0, intent, 0)

        val builder = NotificationCompat.Builder(this)

        builder.setContentTitle("Большая посылка")
                .setTicker("Пришла посылка!")
                .setContentText("Уведомление с большой картинкой")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(NotificationCompat.InboxStyle()
                        .addLine("Первое сообщение").addLine("Второе сообщение")
                        .addLine("Третье сообщение").addLine("Четвертое сообщение")
                        .setSummaryText("+2 more"))
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher, "Запустить активность",
                        pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(2, builder.build())
    }
     fun MessagingStyle(view: View) {
         textView.text = "ЧАТ"
         //Уведомление в стиле мессенджера: MessagingStyle
         //Стиль MessagingStyle пригодится для отображения сообщений из мессенджера или чата.
         // Появился в Android Nougat.
         val intent = Intent(this, YesActivity::class.java)
         val pendingIntent = PendingIntent.getActivity(this,
                 0, intent, 0)

         val messagingStyle = NotificationCompat.MessagingStyle("Вы")
         messagingStyle.setConversationTitle("Android chat")
                 .addMessage("Привет котаны!", System.currentTimeMillis(), "Мурзик")
                 .addMessage("А вы знали, что chat по-французски кошка?", System
                         .currentTimeMillis(),
                         "Мурзик")
                 .addMessage("Круто!", System.currentTimeMillis(),
                         "Васька")
                 .addMessage("Ми-ми-ми", System.currentTimeMillis(),
                        "DO")
                 .addMessage("Мурзик, откуда ты знаешь французский?", System.currentTimeMillis(), "DO")
                 .addMessage("Шерше ля фам, т.е. ищите кошечку!", System.currentTimeMillis(),
                         "Мурчик")

         val builder = NotificationCompat.Builder(this)

         builder.setContentTitle("Уютный чатик")
                 .setSmallIcon(R.mipmap.ic_launcher)
                 .setStyle(messagingStyle)
                 .setAutoCancel(true)
                 .addAction(R.mipmap.ic_launcher, "Запустить активность",
                         pendingIntent)

         val notificationManager = NotificationManagerCompat.from(this)
         notificationManager.notify(2, builder.build())

         //В конструкторе MessagingStyle вы должны указать имя текущего пользователя,
         // который будет видеть свои сообщения.

         //В setConversationTitle() указываем название беседы
         // , удобно при разговоре двух и более котов.

         //Разговор строится через цепочку вызовов методов addMessage(),
         // в которых указывается текст сообщения, время, отправитель.
         // Для текущего пользователя можно указать null и будет использоваться имя,
         // указанное в конструкторе MessagingStyle (см. выше).

         //Количество сообщений может быть любым.
         // При большом количестве (задано в MessagingStyle.MAXIMUM_RETAINED_MESSAGES)
         // старые сообщения начнут удаляться автоматически.

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