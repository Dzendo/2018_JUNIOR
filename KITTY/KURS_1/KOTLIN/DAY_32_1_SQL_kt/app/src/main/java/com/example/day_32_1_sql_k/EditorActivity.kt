package com.example.day_32_1_sql_k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.example.day_32_1_sql_k.data.HotelContract
import com.example.day_32_1_sql_k.data.HotelContract.GuestEntry
import kotlinx.android.synthetic.main.activity_editor.*

// активность предназначена для добавления новых гостей, которые поселяются в наш отель
//  шаблона Empty Activity
class EditorActivity : AppCompatActivity() {

    // Инициализируем текстовые поля и выпадающий список.
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
}
