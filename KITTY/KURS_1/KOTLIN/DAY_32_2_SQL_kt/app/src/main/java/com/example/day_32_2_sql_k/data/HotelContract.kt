package com.example.day_32_2_sql_k.data

import android.provider.BaseColumns

object HotelContract {

    class GuestEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "guests"

            val _ID = BaseColumns._ID
            val COLUMN_NAME = "name"
            val COLUMN_CITY = "city"
            val COLUMN_GENDER = "gender"
            val COLUMN_AGE = "age"

            val GENDER_FEMALE = 0
            val GENDER_MALE = 1
            val GENDER_UNKNOWN = 2
        }
    }
}
