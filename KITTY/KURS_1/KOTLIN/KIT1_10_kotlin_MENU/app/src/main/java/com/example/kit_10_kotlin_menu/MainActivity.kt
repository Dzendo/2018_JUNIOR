package com.example.kit_10_kotlin_menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cat1 -> {
                textView.text = "Вы выбрали кота!"
                true
            }
            R.id.action_cat2 -> {
                textView.text = "Вы выбрали кошку!"
                true
            }
            R.id.action_cat3 -> {
                textView.text = "Вы выбрали котёнка!"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onSettingsMenuClick(item: MenuItem)  {
        textView.text = "Вы выбрали пункт Settings,\n лучше бы выбрали кота"
    }
    fun onClickAbout(item: MenuItem)  {
        textView.text = "Вы выбрали пункт About,\n лучше бы выбрали котенка"
    }
}

