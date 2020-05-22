package com.example.day_32_2_sql_k

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

import com.example.day_32_2_sql_k.data.HotelContract
import com.example.day_32_2_sql_k.data.HotelContract.GuestEntry
import com.example.day_32_2_sql_k.data.HotelDbHelper

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils

class EditorActivity : AppCompatActivity() {

    private var mNameEditText: EditText? = null
    private var mCityEditText: EditText? = null
    private var mAgeEditText: EditText? = null

    private var mGenderSpinner: Spinner? = null

    /**
     * Пол для гостя. Возможные варианты:
     * 0 для кошки, 1 для кота, 2 - не определен.
     */
    private var mGender = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        mNameEditText = findViewById<View>(R.id.edit_guest_name) as EditText
        mCityEditText = findViewById<View>(R.id.edit_guest_city) as EditText
        mAgeEditText = findViewById<View>(R.id.edit_guest_age) as EditText
        mGenderSpinner = findViewById<View>(R.id.spinner_gender) as Spinner

        setupSpinner()
    }

    /**
     * Настраиваем spinner для выбора пола у гостя.
     */
    private fun setupSpinner() {

        val genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item)

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        mGenderSpinner!!.adapter = genderSpinnerAdapter
        mGenderSpinner!!.setSelection(2)

        mGenderSpinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selection = parent.getItemAtPosition(position) as String
                if (!TextUtils.isEmpty(selection)) {
                    if (selection == getString(R.string.gender_female)) {
                        //                        mGender = 0; // Кошка
                        mGender = HotelContract.GuestEntry.GENDER_FEMALE // Кошка
                    } else if (selection == getString(R.string.gender_male)) {
                        //                        mGender = 1; // Кот
                        mGender = HotelContract.GuestEntry.GENDER_MALE // Кот
                    } else {
                        //                        mGender = 2; // Не определен
                        mGender = HotelContract.GuestEntry.GENDER_UNKNOWN // Не определен
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                mGender = 2 // Unknown
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        menuInflater.inflate(R.menu.menu_editor, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // User clicked on a menu option in the app bar overflow menu
        return when (item.itemId) {
            // Respond to a click on the "Save" menu option
            R.id.action_save -> {
                insertGuest()
                // Закрываем активность
                finish()
                return true
            }
            // Respond to a click on the "Delete" menu option
            R.id.action_delete ->
                // Do nothing for now
                return true
            // Respond to a click on the "Up" arrow button in the app bar
            android.R.id.home -> {
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this)
                return true

            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    /**
     * Сохраняем введенные данные в базе данных.
     */
    private fun insertGuest() {
        // Считываем данные из текстовых полей
        val name = mNameEditText!!.text.toString().trim { it <= ' ' }
        val city = mCityEditText!!.text.toString().trim { it <= ' ' }
        val ageString = mAgeEditText!!.text.toString().trim { it <= ' ' }
        val age = Integer.parseInt(ageString)

        val mDbHelper = HotelDbHelper(this)

        val db = mDbHelper.writableDatabase

        val values = ContentValues()
        values.put(GuestEntry.COLUMN_NAME, name)
        values.put(GuestEntry.COLUMN_CITY, city)
        values.put(GuestEntry.COLUMN_GENDER, mGender)
        values.put(GuestEntry.COLUMN_AGE, age)

        // Вставляем новый ряд в базу данных и запоминаем его идентификатор
        val newRowId = db.insert(GuestEntry.TABLE_NAME, null, values)

        // Выводим сообщение в успешном случае или при ошибке
        if (newRowId == -1L) {
            // Если ID  -1, значит произошла ошибка
            Toast.makeText(this, "Ошибка при заведении гостя", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Гость заведён под номером: $newRowId", Toast.LENGTH_SHORT).show()
        }
    }
}


// Вставка данных. Общая информация

// Наполняем базу данных
// Создадим вспомогательный метод для вставки записи в базу данных.
// Для этого считываем данные, которые вводятся в текстовые поля,
// а далее по предыдущему учебному примеру.
//  private fun insertGuest() {
//Метод вызывается в меню для значка с галочкой, которая выводится на панели действия активности.
