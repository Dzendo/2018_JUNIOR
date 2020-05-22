package com.example.kit1_05_kotlin_filtr_manifest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Всплывающее окно
        showToast()

    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast toast = Toast.makeText(getApplicationContext(),
        //        "Прощай, День Рождения", Toast.LENGTH_SHORT);
        //toast.show();
        Toast.makeText(this@MainActivity, "Прощай, День Рождения 1000$", Toast.LENGTH_SHORT).show()

    }


    fun OnClick_Send(view: View) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        // в ключ adress пихаем текст из поля адресса
        intent.putExtra("adress", adress_text.text.toString())
        // в ключ letter пихаем тест сообщения
        intent.putExtra("letter", letter_text.text.toString())
        startActivity(intent)
    }

    fun onClick(view: View) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun onClickBirthday(view: View) {
        val intent = Intent(this@MainActivity, BirthdayActivity::class.java)
        startActivity(intent)
    }

    fun showToast() {     // Всплывающее окно
        //создаем и отображаем текстовое уведомление
        val toast = Toast.makeText(applicationContext,
            R.string.Birrthday,
            Toast.LENGTH_SHORT)

        toast.setGravity(Gravity.CENTER, 0, 0)

        val toastContainer = toast.view as LinearLayout
        val doImageView = ImageView(applicationContext)
        doImageView.setImageResource(R.drawable.aa1020921738)
        toastContainer.addView(doImageView, 0)
        toast.show()

    }

    fun onFilter(view: View) {

        startActivity(Intent("com.example.kit1_05_kotlin_filtr_manifest.SecondActivity"))

    }
}
/*
Итак, что мы сделали.
Для второй активности мы прописали фильтр и указали имя для action в атрибуте android:name.
Для удобства я просто поместил в него полное имя активности с названием пакета.
Конструктор класса Intent имеет несколько перегруженных версий.
В одной из версий можно указать строку для действия.
Мы указали своё созданное действие, которое прописано у второй активности.
Система во время работы просматривает манифесты всех установленных приложений.
При поиске соответствия система находит наш фильтр и запускает нужную активность.

По такому же принципу можно запустить другие активности.
Посмотрите на пример Открываем окно настроек для автономного режима.
Если вы скопируете пример к себе и посмотрите на документацию по
android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS,
то увидите, что этому коду соответствует строковая константа
public static final java.lang.String ACTION_AIRPLANE_MODE_SETTINGS = "android.settings.AIRPLANE_MODE_SETTINGS".
Сравните с нашим кодом.
Вы можете предположить, что у активности настроек для автономного режима в фильтре прописана эта строка.

Имя категории фильтра android.intent.category.DEFAULT
говорит системе, что следует выполнить действие по умолчанию,
а именно, запустить активность. Существует и другие имена, которые пока нас не интересуют.

А теперь вопрос на засыпку.
Что произойдёт, если создать ещё одну активность и указать такой же фильтр, как у второй активности?
А давайте проверим.
Создайте у себя третью активность и скопируйте блок с фильтром от второй активности в него.

 */
