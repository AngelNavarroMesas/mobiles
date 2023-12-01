package com.example.examen

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [clsConfiguracion :: class, clsVaca :: class, clsMilk :: class], version = 1)
abstract class VacasDatabase : RoomDatabase(){
    abstract fun Dao() : Dao
}