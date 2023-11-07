package com.example.piedrapapeltijerasjc

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.piedrapapeltijerasjc.entidades.JugadorEntity

@Database(entities = arrayOf(JugadorEntity::class), version = 1)
abstract class JugadoresDatabase : RoomDatabase() {
    abstract fun JugadorDao(): JugadorDao
}