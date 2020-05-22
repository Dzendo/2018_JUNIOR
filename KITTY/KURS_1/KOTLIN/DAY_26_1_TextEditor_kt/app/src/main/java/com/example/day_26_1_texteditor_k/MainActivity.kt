package com.example.day_26_1_texteditor_k

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.preference.PreferenceManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter


class MainActivity : AppCompatActivity() {

    // Константы для меню
    val IDM_OPEN = 101
    val IDM_SAVE = 102
    val IDM_PREF = 103

    // имя файла
    private val FILENAME = "sample.txt"
   // private var editText: EditText? = null // текстовое поле

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Открыть")

        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Сохранить")
                .setIcon(android.R.drawable.ic_menu_save)

        menu.add(Menu.NONE, IDM_PREF, Menu.NONE, "Настройки")

        return super.onCreateOptionsMenu(menu)
        // return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            IDM_OPEN -> openFile(FILENAME)
            IDM_SAVE -> saveFile(FILENAME)
            R.id.action_open -> openFile(FILENAME)
            R.id.action_save -> saveFile(FILENAME)
            IDM_PREF -> {
                val intent = Intent()
                intent.setClass(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        
    }

    // Метод для открытия файла
    private fun openFile(fileName: String) :Boolean {
        try {
            val inStream = openFileInput(fileName)

            if (inStream != null) {
                val sr = InputStreamReader(inStream)
                val reader = BufferedReader(sr)
                var str: String? = null
                val buffer = StringBuffer()

                 while (true) { str = reader.readLine()
                     if (str == null) break
                     var append = buffer.append(str + "\n")
                 }

                inStream.close()
                editText.setText(buffer.toString())
            }
        } catch (t: Throwable) {
            Toast.makeText(applicationContext,
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show()
        }
        return true

    }

    // Метод для сохранения файла
    private fun saveFile(fileName: String) :Boolean {
        try {
            val outStream = openFileOutput(fileName, 0)
            val sw = OutputStreamWriter(outStream)
            sw.write(editText.getText().toString())
            sw.close()
        } catch (t: Throwable) {
            Toast.makeText(applicationContext,
                    "Exception: " + t.toString(), Toast.LENGTH_LONG)
                    .show()
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        // читаем установленное значение из CheckBoxPreference
        if (prefs.getBoolean(getString(R.string.pref_openmode), false)) {
            openFile(FILENAME)
        }

        // читаем размер шрифта из EditTextPreference
        val fSize = java.lang.Float.parseFloat(
                prefs.getString(getString(R.string.pref_size), "20")!!)
        // применяем настройки в текстовом поле
        editText.textSize = fSize

        // читаем стили текста из ListPreference
        val regular = prefs.getString(getString(R.string.pref_style), "")
        var typeface = Typeface.NORMAL

        if (regular!!.contains("Полужирный"))
            typeface += Typeface.BOLD

        if (regular.contains("Курсив"))
            typeface += Typeface.ITALIC

        // меняем настройки в EditText
        //editText.setTextSize(fSize);
        editText.setTypeface(null, typeface)

        // читаем цвет текста из CheckBoxPreference
        // и суммируем значения для получения дополнительньк цветов текста
        var color = Color.BLACK
        if (prefs.getBoolean(getString(R.string.pref_color_red), false))
            color += Color.RED
        if (prefs.getBoolean(getString(R.string.pref_color_green), false))
            color += Color.GREEN
        if (prefs.getBoolean(getString(R.string.pref_color_blue), false))
            color += Color.BLUE

        editText.setTextColor(color)
    }
}
