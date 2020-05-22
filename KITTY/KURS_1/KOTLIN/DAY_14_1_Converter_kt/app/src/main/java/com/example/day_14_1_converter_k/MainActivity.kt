package com.example.day_14_1_converter_k

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*  // этот импорт дает доступ к полям Layout activity_main.xml

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Конвертируем в метры
    private fun convertParrotToMeter(parrot: Float) = parrot / 7.6
    // Конвертируем в попугаи
    private fun convertMeterToParrot(meter: Float)=meter * 7.6
   /* private fun convertMeterToParrot(meter: Float): Float {
        return (meter * 7.6).toFloat()
    }*/

    fun onClick(view: View) {

        if (editText.text.isEmpty()) {
            Toast.makeText(applicationContext, "Введите длину кота",
                    Toast.LENGTH_LONG).show()
            return
        }

        val inputValue = java.lang.Float.parseFloat(editText.text.toString())
        if (radioButtonMeter.isChecked) {
            editText.setText(convertParrotToMeter(inputValue).toString())
        } else {
            editText.setText(convertMeterToParrot(inputValue).toString())
            textView.text = "Hello"

        }
    }

}
