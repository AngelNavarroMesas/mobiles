package com.example.pruebahibernateraro

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebahibernateraro.entidades.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TasksDatabase:RoomDatabase() {
    abstract fun TaskDao():TaskDao
}