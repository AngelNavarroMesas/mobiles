package com.example.piedrapapeltijerasjc

import android.app.Application
import androidx.room.Room

class HighScoreApp: Application() {
    companion object {
        lateinit var database: JugadoresDatabase
    }
    override fun onCreate() {
        super.onCreate()
        HighScoreApp.database =  Room.databaseBuilder(this, JugadoresDatabase::class.java, "jugadores-db").build()
    }
}