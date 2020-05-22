package com.example.day_32_2_sql_k

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

import com.example.day_32_2_sql_k.data.HotelContract.GuestEntry
import com.example.day_32_2_sql_k.data.HotelDbHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var mDbHelper: HotelDbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        //val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //                        .setAction("Action", null).show();
            val intent = Intent(this@MainActivity, EditorActivity::class.java)
            startActivity(intent)
        }

        mDbHelper = HotelDbHelper(this)
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
            R.id.action_delete_all_entries ->
                // Do nothing for now
                 true
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

        //val displayTextView = findViewById<View>(R.id.text_view_info) as TextView

        try {
            text_view_info.text = "Таблица содержит " + cursor.count + " гостей.\n\n"
            text_view_info.append(GuestEntry._ID + " - " +
                    GuestEntry.COLUMN_NAME + " - " +
                    GuestEntry.COLUMN_CITY + " - " +
                    GuestEntry.COLUMN_GENDER + " - " +
                    GuestEntry.COLUMN_AGE + "\n")

            // Узнаем индекс каждого столбца
            val idColumnIndex = cursor.getColumnIndex(GuestEntry._ID)
            val nameColumnIndex = cursor.getColumnIndex(GuestEntry.COLUMN_NAME)
            val cityColumnIndex = cursor.getColumnIndex(GuestEntry.COLUMN_CITY)
            val genderColumnIndex = cursor.getColumnIndex(GuestEntry.COLUMN_GENDER)
            val ageColumnIndex = cursor.getColumnIndex(GuestEntry.COLUMN_AGE)

            // Проходим через все ряды
            while (cursor.moveToNext()) {
                // Используем индекс для получения строки или числа
                val currentID = cursor.getInt(idColumnIndex)
                val currentName = cursor.getString(nameColumnIndex)
                val currentCity = cursor.getString(cityColumnIndex)
                val currentGender = cursor.getInt(genderColumnIndex)
                val currentAge = cursor.getInt(ageColumnIndex)
                // Выводим значения каждого столбца
                text_view_info.append("\n" + currentID + " - " +
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

// Вставка данных. Общая информация

// Первый способ. ContentValues
//Для вставки сначала подготавливаются данные с помощью класса ContentValues.
// Вы указываете имя колонки таблицы и значение для неё, т.е. работает по принципу "ключ-значение".
// Когда подготовите все данные во все столбцы, то вызывайте метод insert(),
// который сразу раскидает данные по столбцам.
//
//Способ очень удобен, требует мало кода и легко читаем.
// Вы создаёте экземпляр класса,
// а затем с помощью метода put() записываете в нужную колонку нужные данные.
// После чего вызывается метод insert(), который помещает подготовленные данные в таблицу.
//
//У метода insert() три аргумента.
// В первом указывается имя таблицы, в которую будут добавляться записи.
// В третьем указывается объект ContentValues, созданный ранее.
// Второй аргумент используется для указания колонки.
// SQL не позволяет вставлять пустую запись,
// и если будет использоваться пустой ContentValue,
// то укажите во втором аргументе null во избежание ошибки.

// Второй способ. SQL-запрос
//Существует также другой способ вставки через метод execSQL(),
// когда подготавливается нужная строка и запускается скрипт.
// Этот способ возможно понравится PHP-кодерам, которые привыкли к такому синтаксису.
//
//В этом варианте используется традиционный SQL-запрос INSERT INTO....
// Основное неудобство при этом способе - не запутаться в кавычках.
// Если что-то не вставляется, то смотрите логи сообщений.

// / Абстрактный пример
//db = new DatabaseHelper(this);
//SQLiteDatabase sqdb = db.getWritableDatabase();
//
//String insertQuery = "INSERT INTO " +
//        DatabaseHelper.DATABASE_TABLE +
//        " (" + DatabaseHelper.CAT_NAME_COLUMN + ") VALUES ('Васька')";
//sqdb.execSQL(insertQuery);

// Научившись вставлять данные, можно заняться второй активностью,
// которая и предназначена для этих целей.
// private void insertGuest() {
// Метод вызывается в меню для значка с галочкой, которая выводится на панели действия активности.
// case R.id.action_save:
//    insertGuest();
//    // Закрываем активность
//    finish();
//    return true;
//Запускаем проект и проверяем работу кода.

// Изменение данных DAY_32_3 SQL

