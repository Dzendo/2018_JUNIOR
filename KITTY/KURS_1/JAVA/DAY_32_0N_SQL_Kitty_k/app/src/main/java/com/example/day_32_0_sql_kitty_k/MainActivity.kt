package com.example.day_32_0_sql_kitty_k

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

import com.example.day_32_0_sql_kitty_k.data.HotelContract.GuestEntry
import com.example.day_32_0_sql_kitty_k.data.HotelDbHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var mDbHelper: HotelDbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mDbHelper = HotelDbHelper(this)
        fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, EditorActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        displayDatabaseInfo()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_insert_new_data -> {
                insertGuest()
                displayDatabaseInfo()
                true
            }
            R.id.action_delete_all_entries -> true
            // Do nothing for now
            R.id.action_settings -> {
                startActivity(Intent(this@MainActivity, MainActivity_Stand::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun displayDatabaseInfo() {
        // Создадим и откроем для чтения базу данных
        val db = mDbHelper!!.readableDatabase

        // Зададим условие для выборки - список столбцов
        val projection = arrayOf(GuestEntry._ID, GuestEntry.COLUMN_NAME, GuestEntry.COLUMN_CITY, GuestEntry.COLUMN_GENDER, GuestEntry.COLUMN_AGE)

        // Делаем запрос
        val cursor = db.query(
                GuestEntry.TABLE_NAME, // таблица
                projection, null, null, null, null, null)// столбцы
        // столбцы для условия WHERE
        // значения для условия WHERE
        // Don't group the rows
        // Don't filter by row groups
        // The sort order

        try {
            text_view_info.text = "Таблица содержит ${cursor.count} гостей.\n\n"
            text_view_info.append(
                    GuestEntry._ID + " - " +
                    GuestEntry.COLUMN_NAME + " - " +
                    GuestEntry.COLUMN_CITY + " - " +
                    GuestEntry.COLUMN_GENDER + " - " +
                    GuestEntry.COLUMN_AGE + "\n")

            // Узнаем индекс каждого столбца
            val idColumnIndex     = cursor.getColumnIndex(GuestEntry._ID)
            val nameColumnIndex   = cursor.getColumnIndex(GuestEntry.COLUMN_NAME)
            val cityColumnIndex   = cursor.getColumnIndex(GuestEntry.COLUMN_CITY)
            val genderColumnIndex = cursor.getColumnIndex(GuestEntry.COLUMN_GENDER)
            val ageColumnIndex    = cursor.getColumnIndex(GuestEntry.COLUMN_AGE)

            // Проходим через все ряды
            while (cursor.moveToNext()) {
                // Используем индекс для получения строки или числа
                val currentID        = cursor.getInt(idColumnIndex)
                val currentName   = cursor.getString(nameColumnIndex)
                val currentCity   = cursor.getString(cityColumnIndex)
                val currentGender    = cursor.getInt(genderColumnIndex)
                val currentAge       = cursor.getInt(ageColumnIndex)
                // Выводим значения каждого столбца
                text_view_info.append("\n" +
                        currentID + " - " +
                        currentName + " - " +
                        currentCity + " - " +
                        currentGender + " - " +
                        currentAge)
            }
        } finally {
            // Всегда закрываем курсор после чтения
            cursor.close()
        }
    }

    /**
     * Вспомогательный метод для вставки записи
     */
    private fun insertGuest() {

        // Gets the database in write mode
        val db = mDbHelper!!.writableDatabase
        // Создаем объект ContentValues, где имена столбцов ключи,
        // а информация о госте является значениями ключей
        val values = ContentValues()
        values.put(GuestEntry.COLUMN_NAME, "Мурзик")
        values.put(GuestEntry.COLUMN_CITY, "Мурманск")
        values.put(GuestEntry.COLUMN_GENDER, GuestEntry.GENDER_MALE)
        values.put(GuestEntry.COLUMN_AGE, 7)

        val newRowId = db.insert(GuestEntry.TABLE_NAME, null, values)

        //        Uri newUri = getContentResolver().insert(GuestEntry.CONTENT_URI, values);
    }
}