package com.example.day_11_01_popupmenu_k

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    internal var viewClickListener = View.OnClickListener { v -> showPopupMenu(v) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(viewClickListener)
        textView.setOnClickListener(viewClickListener)
        imageView.setOnClickListener(viewClickListener)
    }

    private fun showPopupMenu(v: View) {
        val popupMenu = PopupMenu(this, v)
        popupMenu.inflate(R.menu.popupmenu) // Для Android 4.0
        // для версии Android 3.0 нужно использовать длинный вариант:
        // popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());

        popupMenu
                .setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.menu1 -> {
                            Toast.makeText(applicationContext,
                                    "Вы выбрали PopupMenu 1",
                                    Toast.LENGTH_LONG).show()
                            true
                        }
                        R.id.menu2 -> {
                            Toast.makeText(applicationContext,
                                    "Вы выбрали PopupMenu 2",
                                    Toast.LENGTH_LONG).show()
                            true
                        }
                        R.id.menu3 -> {
                        Toast.makeText(applicationContext,
                                "Вы выбрали PopupMenu 3",
                                Toast.LENGTH_LONG).show()
                        true
                        }
                        R.id.submenu -> {
                            Toast.makeText(applicationContext,
                                    "Вы выбрали submenu",
                                    Toast.LENGTH_LONG).show()
                            true
                        }
                        R.id.menu4 -> {
                            Toast.makeText(applicationContext,
                                    "Вы выбрали PopupMenu 4",
                                    Toast.LENGTH_LONG).show()
                            true
                        }
                        R.id.menu5 -> {
                            Toast.makeText(applicationContext,
                                    "Вы выбрали PopupMenu 5",
                                    Toast.LENGTH_LONG).show()
                            true
                        }
                        R.id.menu6 -> {
                            Toast.makeText(applicationContext,
                                    "Вы выбрали PopupMenu 6",
                                    Toast.LENGTH_LONG).show()
                            true
                        }
                        else -> false
                    }
                }

        popupMenu.setOnDismissListener {
            Toast.makeText(applicationContext, "onDismiss",
                    Toast.LENGTH_SHORT).show()
        }
        popupMenu.show()
    }
    // Программное добавление  PopupMenu
    fun onClick(view: View) {
        val popupMenu = PopupMenu(this, view) // создать новое меню
        popupMenu.menu.add(1, R.id.menu1, 1, "slot1")
        popupMenu.menu.add(1, R.id.menu2, 2, "slot2")
        popupMenu.show()
    }
    // Программное добавление пкнктов существующего PopupMenu
    fun onClick7(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.popupmenu); // если добавлять к существующему меню
        popupMenu.menu.add(2, R.id.menu1, 1, "Programm7")
       // popupMenu.menu.add(1, R.id.Programm7, 2, "slot2")
        popupMenu.show()
        // обработку писать заново или вызывать сверху - сама не вызывается
    }
}
