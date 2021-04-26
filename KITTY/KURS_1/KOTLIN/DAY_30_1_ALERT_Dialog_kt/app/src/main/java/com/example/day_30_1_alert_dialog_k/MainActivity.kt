package com.example.day_30_1_alert_dialog_k

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.day_30_1_alert_dialog_k.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        // Надувает главный экран из своего activity_sky.xml и запоминает адрес в переменной
        setContentView(mainBinding.root)
    }
        // Диалог с одной кнопкой
    fun onClickDialogButton1(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment1()
        myDialogFragment.show(manager, "dialog")

    }
    //пример создания диалогового окна с двумя кнопками на основе иллюстрации
    //альтернативный вариант показа окна через транзакцию
    fun onClickDialogTransac(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment2()
        val transaction = manager.beginTransaction()
        myDialogFragment.show(transaction, "dialog")
    }
// Три кнопки
    fun onClickDialog3(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment3()
        myDialogFragment.show(manager, "dialog")
    }
// AlertDialog со списком
    fun onClickList(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment4()
        myDialogFragment.show(manager, "dialog")
    }
// AlertDialog с переключателями
    fun onClick5(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment5()
        myDialogFragment.show(manager, "dialog")
    }
// AlertDialog с флажками
    fun onClick6(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment6()
        myDialogFragment.show(manager, "dialog")
    }
// Передать данные в активность
    fun onClick7(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment7()
        myDialogFragment.show(manager, "dialog")
    }
// AlertDialog с собственной разметкой
    fun okClicked() {
        Toast.makeText(applicationContext, "Вы выбрали кнопку OK!",
                Toast.LENGTH_LONG).show()
    }

    fun cancelClicked() {
        Toast.makeText(applicationContext, "Вы выбрали кнопку отмены!",
                Toast.LENGTH_LONG).show()
    }

    fun onClick8(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment8()
        myDialogFragment.show(manager, "dialog")

    }

    fun onClickYes(view: View) {
        Toast.makeText(applicationContext, "Уже купил билет!",
                Toast.LENGTH_LONG).show()
    }

    fun onClickAll(view: View) {
        Toast.makeText(applicationContext, "Без денег нечего хотеть!",
                Toast.LENGTH_LONG).show()
    }

    fun onClickNon(view: View) {
        Toast.makeText(applicationContext, "Правильно, там одни негры!",
                Toast.LENGTH_LONG).show()

    }
    fun onClick9(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment9()
        myDialogFragment.show(manager, "dialog")
    }
    fun onClick10(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment10()
        myDialogFragment.show(manager, "dialog")
    }
    fun onClick11(view: View) {
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment11()
        myDialogFragment.show(manager, "dialog")
    }
    fun onClick12(view: View) {
        val url = "https://d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480"
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment12(url)
        myDialogFragment.show(manager, "dialog")
    }
    fun onClick13(view: View) {
        val uri = "//d2zkmv5t5kao9.cloudfront.net/images/5ce160bf580717f540be3e725753d802.png?w=640&h=480"
        //val uri = "//d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480"
        val manager = supportFragmentManager
        val myDialogFragment = MyDialogFragment13(uri)
        myDialogFragment.show(manager, "dialog")
    }
    //алерт диалог не закрывает
}
