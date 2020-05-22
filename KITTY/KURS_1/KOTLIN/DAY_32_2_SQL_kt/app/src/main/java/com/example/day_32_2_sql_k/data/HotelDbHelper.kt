package com.example.day_32_2_sql_k.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class HotelDbHelper
/**
 * Конструктор [HotelDbHelper].
 *
 * @param context Контекст приложения
 */
(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    /**
     * Вызывается при создании базы данных
     */
    override fun onCreate(db: SQLiteDatabase) {
        // Строка для создания таблицы
        val SQL_CREATE_GUESTS_TABLE = ("CREATE TABLE " + HotelContract.GuestEntry.TABLE_NAME + " ("
                + HotelContract.GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HotelContract.GuestEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + HotelContract.GuestEntry.COLUMN_CITY + " TEXT NOT NULL, "
                + HotelContract.GuestEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 3, "
                + HotelContract.GuestEntry.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0);")

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
