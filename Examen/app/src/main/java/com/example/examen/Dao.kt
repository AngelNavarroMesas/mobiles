package com.example.examen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(cofiguracion: clsConfiguracion)

    @Query("SELECT * FROM tVaca")
    suspend fun mostrar() : MutableList<clsVaca>

    @Update
    suspend fun actualizar(contacto: clsConfiguracion)

    @Delete
    suspend fun borrar(contacto: clsVaca)
}