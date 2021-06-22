package com.example.agenda.config

import android.app.Application
import androidx.room.Room

class PersonalApp:Application() {
    companion object{
        lateinit var db:PersonalDB
    }

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(
            this,
            PersonalDB::class.java,
            "personal"
        ).build()
    }
}