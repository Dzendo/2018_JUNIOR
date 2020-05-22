package com.example.day_32_0_sql_kitty_k

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


import kotlinx.android.synthetic.main.activity_main_stand.*


class MainActivity_Stand : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_stand)
       /* val toolbar_stand1 = findViewById<View>(R.id.toolbar_stand) as Toolbar
                setSupportActionBar(toolbar_stand1)
              Вылетает ??? */
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main_stand, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> {
             startActivity( Intent(this@MainActivity_Stand, MainActivity_Stand_k::class.java))
            //startActivity(intent)
              true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}
