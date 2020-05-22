package com.example.day_32_1_sql_k

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import com.example.day_32_1_sql_k.data.HotelDbHelper
import com.example.day_32_1_sql_k.data.HotelContract.GuestEntry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

// шаблон Basic Activity
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_insert_new_data -> {
                insertGuest()
                displayDatabaseInfo()
                true
            }
            R.id.action_delete_all_entries -> true
            // Do nothing for now
            R.id.action_settings -> {
                startActivity(Intent(this@MainActivity, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun displayDatabaseInfo() {
        // Создадим и откроем для чтения базу данных
        val db = mDbHelper!!.readableDatabase

        // Зададим условие для выборки - список столбцов
        //Массив projection - это список столбцов, которые нас интересуют.
        // В SQL-запросе мы их указываем в операторе SELECT:
        // SELECT name, city FROM guests;

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
// С помощью SQLite вы можете создавать для своего приложения независимые реляционные базы данных.
// Android хранит базы данных в каталоге /data/data/<имя_вашего_пакета>/databases на эмуляторе,
// на устройстве путь может отличаться.
// По умолчанию все базы данных закрытые,
// доступ к ним могут получить только те приложения, которые их создали.

//Каждая база данных состоит из двух файлов.
// Имя первого файла базы данных соответствует имени базы данных.
// Это основной файл баз данных SQLite, в нём хранятся все данные.
// Вы будете создавать его программно. Второй файл — файл журнала.
// Его имя состоит из имени базы данных и суффикса "-journal".
// В файле журнала хранится информация обо всех изменениях, внесенных в базу данных.
// Если в работе с данными возникнет проблема,
// Android использует данные журнала для отмены (или отката) последних изменений.
// Вы с ним не будете взаимодействовать, но если вы будете просматривать
// внутренности своего устройства, то будете знать, зачем этот файл там присутствует.

//Работаем с записями базы данных

// Массив projection - это список столбцов, которые нас интересуют.
// В SQL-запросе мы их указываем в операторе SELECT:
// SELECT name, city FROM guests;
// В методе query() третий и четвёртый параметр определяют условие WHERE.
// Возьмём случай с выражением:
//SELECT * FROM guests WHERE _id = 1;
// В коде такое выражение выглядело бы так.
// String selection = GuestEntry._ID + "=?";
// String[] selectionArgs = {"1"};
// Как видим, в знак вопроса подставляется нужное значение.
//Последний аргумент отвечает за сортировку по возрастанию или убыванию. Например, по возрасту.
// SELECT name FROM guests WHERE _id > 1 BY age DESC;

// // Зададим условие для выборки - список столбцов
//String[] projection = {
//        GuestEntry.COLUMN_NAME };
//
//String selection = GuestEntry._ID + ">?";
//String[] selectionArgs = {"1"};
//
//Cursor cursor = db.query(
//        GuestEntry.TABLE_NAME, // таблица
//        projection,            // столбцы
//        selection,             // столбцы для условия WHERE
//        selectionArgs,         // значения для условия WHERE
//        null,                  // Don't group the rows
//        null,                  // Don't filter by row groups
//        GuestEntry.COLUMN_AGE + " DESC");  // порядок сортировки

//  Чтение данных
// Считывать данные также можно двумя способами.
// В любом случае результат возвращается в виде объекта Cursor.
// Не путайте его с курсором мыши, который бегает у вас на экране.

// Первый способ. Метод query()

// Извлечение данных происходит через метод query().
// Данные хранятся в наборе строк, которые можно представить в виде таблицы.
// Из этой таблицы вы уже можете извлечь конкретное значение.
//
//У метода query() множество параметров.
// В первом параметре укажите имя таблицы, во втором - массив имён колонок,
// далее идут дополнительные условия. Пока везде оставим null.
// В нашем примере мы добавили одну запись и извлечь её просто.

// Cursor cursor = db.query(
//        GuestEntry.TABLE_NAME,   // таблица
//        projection,            // столбцы
//        null,                  // столбцы для условия WHERE
//        null,                  // значения для условия WHERE
//        null,                  // Don't group the rows
//        null,                  // Don't filter by row groups
//        null);                   // порядок сортировки
//
//// Проходим через все ряды
//while (cursor.moveToNext()) {
//    // Используем индекс для получения строки или числа
//    int currentID = cursor.getInt(idColumnIndex);
//    String currentName = cursor.getString(nameColumnIndex);
//    String currentCity = cursor.getString(cityColumnIndex);
//    int currentGender = cursor.getInt(genderColumnIndex);
//    int currentAge = cursor.getInt(ageColumnIndex);
//    // Выводим значения каждого столбца
//    displayTextView.append(("\n" + currentID + " - " +
//            currentName + " - " +
//            currentCity + " - " +
//            currentGender + " - " +
//            currentAge));
//}

// Второй способ. Метод rawQuery()

// Запустите проект. При запуске создаётся база данных.
// Убедиться в этом можно, если запустить Android Device Monitor.
// Выберите вкладку File Explorer и найдите своё приложение (на эмуляторе).
// Вы увидите, что появилась папка data/data/имя_пакета/databases с файлом hotel.db.
// Метод getReadableDatabase создаёт или открывает базу данных.
//
//Сейчас мы увидим, что пока у нас 0 гостей.
//
//Небольшое предупреждение. При работе с базой данных мы обращаемся к файлу.
// Если база данных очень большая, то запросы не будут мгновенными.
// Операции с файлами являются медленными, поэтому следует использовать многопоточность.
// Для наших примеров это не страшно, поэтому мы пока не будем усложнять код.

// Вставка данных для проверки

// Рассмотрим, как вставлять новые данные.
// Добавим в меню главной активности пункт "Вставить данные".
// Для вставки данных применяется метод ContentValues.put().// В методе указываются ключ и значение.
// В качестве ключа выступает имя столбца таблицы, а его значением будет нужная информация о госте.
// Так как идентификатор будет вставляться автоматически, то его не используем.
// После того, как вы заполните все столбцы таблицы, вызывайте метод insert(),
// который и разместит данные в базе.

//
//Напишем вспомогательный метод. private void insertGuest() {
// Вызовем метод в обработчике нажатия пункта меню.
// Сразу после вставки вызываем метод displayDatabaseInfo(),
// чтобы увидеть результат. Можно нажимать несколько раз.
// Так как данные жёстко заданы в коде, то увидим одинаковые данные,
// кроме увеличивающего значения идентификатора.

// на этом пример заканчивается далее см 32_2_SQL




