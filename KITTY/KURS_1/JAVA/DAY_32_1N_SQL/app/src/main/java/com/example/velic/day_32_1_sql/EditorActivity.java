package com.example.velic.day_32_1_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditorActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mCityEditText;
    private EditText mAgeEditText;

    private Spinner mGenderSpinner;

    /**
     * Пол для гостя. Возможные варианты:
     * 0 для кошки, 1 для кота, 2 - не определен.
     */
    private int mGender = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_editor);
      //  setContentView(R.layout.actyvity_about);
        return;
/*
        mNameEditText = (EditText) findViewById(R.id.edit_guest_name);
        mCityEditText = (EditText) findViewById(R.id.edit_guest_city);
        mAgeEditText = (EditText) findViewById(R.id.edit_guest_age);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setupSpinner();
 */   }

    /**
     * Настраиваем spinner для выбора пола у гостя.
     */
   /* private void setupSpinner() {

        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mGenderSpinner.setAdapter(genderSpinnerAdapter);
        mGenderSpinner.setSelection(2);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_female))) {
                        mGender = 0; // Кошка
                    } else if (selection.equals(getString(R.string.gender_male))) {
                        mGender = 1; // Кот
                    } else {
                        mGender = 2; // Не определен
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 2; // Unknown
            }
        });
    }*/
}
