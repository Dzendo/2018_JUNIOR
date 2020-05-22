package com.example.day_32_0_sql_kitty_k.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import com.example.day_32_0_sql_kitty_k.data.HotelContract.GuestEntry


class HotelDbHelper (context: Context) :
                    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
/**
 * Конструктор [HotelDbHelper].
 * @param context Контекст приложения
 */

    /**
     * Вызывается при создании базы данных
     */
    override fun onCreate(db: SQLiteDatabase) {
        // Строка для создания таблицы
        val SQL_CREATE_GUESTS_TABLE = ("CREATE TABLE " + GuestEntry.TABLE_NAME + " ("
                + GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GuestEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + GuestEntry.COLUMN_CITY + " TEXT NOT NULL, "
                + GuestEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 3, "
                + GuestEntry.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0);")

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE)
    }

    /**
     * Вызывается при обновлении схемы базы даннных
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    companion object {

        val LOG_TAG = HotelDbHelper::class.java.simpleName

        /**
         * Имя файла базы данных
         */
        private val DATABASE_NAME = "hotel.db"

        /**
         * Версия базы данных. При изменении схемы увеличить на единицу
         */
        private val DATABASE_VERSION = 1
    }
}
