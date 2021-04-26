package com.example.day_08_01_toast

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.example.day_08_01_toast.databinding.ActivityMainBinding
import com.example.day_08_01_toast.databinding.CustomLayoutBinding
import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.custom_layout.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        // Надувает главный экран из своего activity_sky.xml и запоминает адрес в переменной
        setContentView(mainBinding.root)
    }

    fun showToast1(view: View) {
        Toast.makeText(applicationContext, "Пора вставать! Утро!", Toast.LENGTH_SHORT).show()

                //.gravity(Gravity.CENTER,0,0)
               // .setGravity(Gravity.CENTER,0,0)
               // .show()
    }
        fun showToast2(view: View) {
            val duration = Toast.LENGTH_LONG;
            val toast:Toast = Toast.makeText(applicationContext,
                R.string.show_toast,
                    duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    // Добавляем картинку
    fun showToast3(view: View) {

        val toast = Toast.makeText(applicationContext,R.string.show_toast, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
        val toastContainer = toast.view as LinearLayout
        val catImageView = ImageView(applicationContext)
            catImageView.setImageResource(R.drawable.soley)
            toastContainer.addView(catImageView, 0)
            toast.show()

    }
    // Создание собственных всплывающих уведомлений
    fun showToast4(view: View) {
        val toast = Toast(applicationContext)
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            toast.view = CustomLayoutBinding.inflate(layoutInflater).toastLayout
            toast.show()
    }

    fun showToast5(view: View) {
        val skyToast = Toast.makeText(applicationContext, "Chair --> Стул", Toast.LENGTH_LONG)
        skyToast.setGravity(Gravity.CENTER, 0, 0)
        val skyToastContainer = skyToast.view as LinearLayout
        skyToastContainer.minimumWidth = 1280
        val skyImageView = ImageView(applicationContext)
        val url = "https://d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480"
        Picasso.with(applicationContext)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground) //    .user_placeholder)
            .error(R.drawable.ic_launcher_foreground) // .user_placeholder_error)
            .resize(1280, 960 )
            .into(skyImageView)
        Thread.sleep(1000) // Костыль
        skyToastContainer.addView(skyImageView, 0)
        //Thread.sleep(1000)
        skyToast.show()
    }

        fun showToast_thread(view: View) {
        mainProcessing()
    }

    // Использование уведомлений Toast в рабочих потоках
    // Запустил работает не понял
    private fun mainProcessing() {
        val thread = Thread(null, doBackgroundThreadProcessing,
                "Background")
            thread.start()
    }

    private val doBackgroundThreadProcessing = Runnable { backgroundThreadProcessing() }

    private fun backgroundThreadProcessing()  {
        //val handler = Handler(Looper.getMainLooper())  // DO
        //return;
        //handler.post(doUpdateGUI)
        Handler(Looper.getMainLooper()).post(doUpdateGUI)
    }

    // Объект Runnable, который вызывает метод из потока GUI
    private val doUpdateGUI = Runnable {
        val context = applicationContext
        val msg = "Открыли мобильную разработку! из потока"
        val duration = Toast.LENGTH_LONG
        Toast.makeText(context, msg, duration).show()
    }
    /*Как элемент графического интерфейса Toast должен быть вызван в потоке GUI,
    иначе существует риск выброса межпотокового исключения.
    В листинге объект Handler используется для гарантии того,
    что уведомление Toast было вызвано в потоке GUI.
    */
}
/*
Напоследок хочу предупредить об одной потенциальной проблеме.
При вызове сообщения нужно указывать контекст в первом параметре метода makeText().
В интернете и, возможно и у меня на сайте будет попадаться пример makeText(MainActivity.this, ...).
Ошибки в этом нет, так как класс Activity является потомком Context
и в большинстве случаев пример будет работать.
Но иногда я получаю письма от пользователей, которые жалуются на непонятное поведение сообщения,
когда текст не выравнивается, обрезается и т.д.
Это связано с тем, что активность может использовать определённую тему или стиль,
которые вызывают такой побочный эффект.
Поэтому я рекомендую вам использовать метод getApplicationContext().

Второй момент - фрагменты, которые будете изучать позже, не являются потомками контекста.
Если вы захотите вызвать всплывающее сообщение в фрагменте, то проблема может поставить вас в тупик.
Вам нужно добавить новую переменную класса Activity через метод getActivity():


Activity activity = getActivity();
Toast.makeText(activity, "Кота покормили?", Toast.LENGTH_SHORT).show();

Такое же может случиться при вызове всплывающих сообщений из диалоговых окон,
которые тоже не относятся к классу Context.
Вместо getApplicationContext() также можно вызывать метод getBaseContext().
*/
