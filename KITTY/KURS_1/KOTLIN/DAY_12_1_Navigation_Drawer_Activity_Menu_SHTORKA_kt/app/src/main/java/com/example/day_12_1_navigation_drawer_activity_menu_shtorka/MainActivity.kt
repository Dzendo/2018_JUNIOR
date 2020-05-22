package com.example.day_12_1_navigation_drawer_activity_menu_shtorka

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import android.widget.TextView
import androidx.core.view.MenuItemCompat
import android.graphics.Typeface
import android.view.Gravity

import kotlinx.android.synthetic.main.content_main_constraint.*



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // 2 и 3 пункт меню <!-- app:actionViewClass="android.widget.TextView"
    // - элементы связан с текстовыми метками -->
    private var mSlideshowTextView: TextView? = null
    private var mGalleryTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) // activity_main_layout - чтобы не закрывать бар
        setContentView(R.layout.activity_main_layout) // activity_main_layout - чтобы не закрывать бар
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

       val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer_layout.addDrawerListener(toggle)  // кажется разрешает анимацию бургера-стрелки
        toggle.syncState()
        // Затемнение и тень
        // выбираем цвет
        drawer_layout.setScrimColor(Color.TRANSPARENT);
        //Тень от шторки убирается также просто.
        drawer_layout.drawerElevation = 0f;

        // показываем в открытом состоянии в onCreate()
        drawer_layout.openDrawer(GravityCompat.START);
        nav_view.setNavigationItemSelectedListener(this)

       // val navigationView = findViewById<NavigationView>(R.id.nav_view)
        mGalleryTextView = MenuItemCompat.getActionView(nav_view.menu.findItem(R.id.nav_gallery)) as TextView
        mSlideshowTextView = MenuItemCompat.getActionView(nav_view.menu.findItem(R.id.nav_slideshow)) as TextView

        // метод для счетчиков
        initializeCountDrawer()
    }

    private fun initializeCountDrawer() {
        // Добавляем счётчик в меню 2 и 3 шторки
        // 2 и 3 пункт меню <!-- app:actionViewClass="android.widget.TextView"
        mGalleryTextView?.gravity = Gravity.CENTER_VERTICAL
        mGalleryTextView?.setTypeface(null, Typeface.BOLD)
        mGalleryTextView?.setTextColor(resources.getColor(R.color.colorAccent))
        mGalleryTextView?.setText("99+")
        mSlideshowTextView?.gravity = Gravity.CENTER_VERTICAL
        mSlideshowTextView?.setTypeface(null, Typeface.BOLD)
        mSlideshowTextView?.setTextColor(resources.getColor(R.color.colorAccent))
        mSlideshowTextView?.setText("7")

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
        fragmentClass = FirstFragment::class.java
        when (item.itemId) {
            R.id.nav_camera -> {

                // Handle the camera action
                Toast.makeText(applicationContext, "Вы выбрали камеру", Toast.LENGTH_SHORT).show()
                fragmentClass = FirstFragment::class.java
                textViewFragment_id = "Камера"
            }
            R.id.nav_gallery -> {

                fragmentClass = FirstFragment::class.java
                textViewFragment_id = "Галерея"
            }
            R.id.nav_slideshow -> {
                textViewFragment_id = "Слайд Шоу"
                fragmentClass = FirstFragment::class.java
            }
            R.id.nav_manage -> {
                textViewFragment_id = " Управление"
                fragmentClass = FirstFragment::class.java
            }
            R.id.nav_share -> {
                textViewFragment_id = " Шаре "
                fragmentClass = FirstFragment::class.java
            }
            R.id.nav_send -> {
                textViewFragment_id = " Переслать "
                fragmentClass = FirstFragment::class.java
            }
            R.id.nav_switch -> {
                textViewFragment_id = " nav_switch "
                fragmentClass = FirstFragment::class.java
            }
            else -> {
                textViewFragment_id = " Другое"
                fragmentClass = FirstFragment::class.java}
        }

        try {
            fragment = (fragmentClass.newInstance() as Fragment)
        } catch (e: Exception) {
            Toast.makeText(getApplicationContext(), "Вылет по фрагменту", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
            return false
        }

        // Вставляем фрагмент, заменяя текущий фрагмент
        supportFragmentManager.beginTransaction().replace(R.id.content_relative, fragment).commit()
        //textViewFragment.text = textViewFragment_id //- Вылетает непонятно почему ДО???

        // Выделяем выбранный пункт меню в шторке
        item.isChecked = true
        // Выводим выбранный пункт в заголовке
        title = item.title

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
