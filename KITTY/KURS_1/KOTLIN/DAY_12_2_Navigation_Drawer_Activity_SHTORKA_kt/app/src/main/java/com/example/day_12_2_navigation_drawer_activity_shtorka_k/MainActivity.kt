package com.example.day_12_2_navigation_drawer_activity_shtorka_k


import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   <!-- Вариант чтобы шторка не закрывала верхнее меню -->: работает слишком высоко
        // setContentView(R.layout.activity_main_layout)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)   // выводит верхнее правое меню setting

        fab.setOnClickListener { view ->  // действие на кнопку внизу справа плавающая
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // Сдвигаем содержимое экрана
        val content = findViewById<ConstraintLayout>(R.id.content)

        val toggle = object : ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)

                val slideX = drawerView.width * slideOffset
                content.translationX = slideX

                // а также меняем размер
                content.scaleX = 1 - slideOffset
                content.scaleY = 1 - slideOffset
            }
        }
        drawer_layout.addDrawerListener(toggle)  // слушатель сдвижки шторки
        toggle.syncState()              // drawer_layout это корневой контейнер activity_main
        nav_view.setNavigationItemSelectedListener(this) // слушатель нажатия на кнопки шторки

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Создадим новый фрагмент
        var fragment: Fragment
        var fragmentClass: Class<*>
        var textViewFragment_id : String = " Ничего "
        // Handle navigation view item clicks here.
        val id = item.itemId

        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                Toast.makeText(applicationContext, "Вы выбрали камеру", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        fragmentClass = FirstFragment::class.java
        fragment = (fragmentClass.newInstance() as Fragment)

        // Вставляем фрагмент, заменяя текущий фрагмент
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit()
        //textViewFragment.text = textViewFragment_id //- Вылетает непонятно почему ДО???
        // Выделяем выбранный пункт меню в шторке
        item.isChecked = true
        // Выводим выбранный пункт в заголовке
        title = item.title

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
