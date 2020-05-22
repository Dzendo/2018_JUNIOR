package com.example.day_19_1_keyboard_k

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodSubtype
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import java.util.Locale

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private var myView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Интерфейс OnKeyListener у меня НЕ работает!!! OnKey только ВВОД
       // myView = findViewById(R.id.myView)
        myView.setOnKeyListener { v, keyCode, event ->
            Log.d(TAG,
                    "Это мое сообщение для записи в журнале клавиша в поле MYView KeyCode="
                            + keyCode + " KeyEvent=" + event)
            // TODO Обработайте нажатие клавиши, верните true, если
            // обработка выполнена
            false
        }


    }
/*
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // Обработайте нажатие, верните true, если обработка выполнена
        Log.i(TAG, "Это мое сообщение для записи в журнале KeyDown $keyCode")
        //super.onKeyDown(keyCode, event);
        return false
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        // Обработайте отпускание клавиши, верните true, если обработка выполнена
        Log.d(TAG, "Это мое сообщение для записи в журнале KeyUP $keyCode")
        //super.onKeyUp(keyCode, event);
        return false
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        //replaces the default 'Back' button action
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // ваш код
            Log.d(TAG, "Это мое сообщение для записи в журнале onBackPressed=BACK ")
            openQuitDialog()
        }
        return true
    }

    // Это по другому то же самое для кнопки возврата - - противоречит верхнему оно перехватывает клавишу

    override fun onBackPressed() {
        // super.onBackPressed();
        Log.d(TAG, "Это мое сообщение для записи в журнале onBackPressed ")
        openQuitDialog()
    }

    private fun openQuitDialog() {
        val quitDialog = AlertDialog.Builder(
                this@MainActivity)
        quitDialog.setTitle("Выход: Вы уверены?")

        quitDialog.setPositiveButton("Таки да!", object : DialogInterface.OnClickListener() {
            fun onClick(dialog: DialogInterface, which: Int) {
                // TODO Auto-generated method stub
                finish()
            }
        })

        quitDialog.setNegativeButton("Нет", object : DialogInterface.OnClickListener() {
            fun onClick(dialog: DialogInterface, which: Int) {
                // TODO Auto-generated method stub
            }
        })

        quitDialog.show()
    }

    override// отслеживание двойного нажатия
    fun onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
        //super.onBackPressed();
            openQuitDialog()
        else
            Toast.makeText(baseContext, "Press once again to exit!",
                    Toast.LENGTH_SHORT).show()
        back_pressed = System.currentTimeMillis()
    }

    override fun onUserLeaveHint() {
        val toast = Toast.makeText(applicationContext, "Нажата кнопка HOME", Toast.LENGTH_SHORT)
        toast.show()
        super.onUserLeaveHint()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            event.startTracking()
            val mTextView = findViewById<TextView>(R.id.textView)
            mTextView.setText("Key Down") //вывожу текст в текстовом поле
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            val mTextView = findViewById<TextView>(R.id.textView)
            mTextView.setText("Long Press") //вывожу текст в текстовом поле
            return true
        }
        return super.onKeyLongPress(keyCode, event)
    }
*/
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_MENU -> {
                Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                        .show()
                return true
            }
            KeyEvent.KEYCODE_SEARCH -> {
                Toast.makeText(this, "Нажата кнопка Поиск", Toast.LENGTH_SHORT)
                        .show()
                return true
            }
            KeyEvent.KEYCODE_BACK -> {
                onBackPressed()
                return true
            }
            KeyEvent.KEYCODE_VOLUME_UP -> {
                event.startTracking()
                return true
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                        .show()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
        // работае все плохо -- зависит от аппарата
    }

    fun onClick(view: View) {
        // прячем клавиатуру. butCalculate - это кнопка  У меня заработала на клавиатуру
        // вызванную полем для заполнения, но не пинудительно
        val butCalculate = findViewById<Button>(R.id.butCalculate)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(butCalculate.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun onClickOn(view: View) {
        // принудительно показать клавиатуру работает и принудительно прячет
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)

    }

    fun onDialog(view: View) {
        val dlg: DialogFragment
            dlg = BlankFragment()
        //dlg.show(androidx.fragment.app.DialogFragment.getFragmentManager()!!, "dlg1")
        dlg.show(supportFragmentManager, "dlg1")
    }

    fun onLang(view: View) {
        //Откроем окно настроек клавиатур.


        val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS) // виртуальные клавиатуры
       // val intent0 = Intent(Settings.ACTION_HARD_KEYBOARD_SETTINGS) // API 24: реальные клавиатуры
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

        //Определение языка клавиатуры : на 5,1,1 светит ZZ надо дописывать еще if
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val ims = imm.currentInputMethodSubtype
        val localeString = ims.locale
        val locale = Locale(localeString)
        val currentLanguage = locale.displayLanguage
        val languageEditText = findViewById<View>(R.id.myView) as EditText
        Toast.makeText(applicationContext, currentLanguage, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private val TAG = "MyApp"
        private var back_pressed: Long = 0
    }
}
