package com.example.agenda.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.agenda.dao.PersonalDao
import com.example.agenda.tablas.Personal

@Database(
    entities = [Personal::class],
    version = 1
)

abstract class PersonalDB:RoomDatabase() {
    abstract fun personalDao():PersonalDao
}