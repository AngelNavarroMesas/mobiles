package com.example.piedrapapeltijerasjc

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.piedrapapeltijerasjc.entidades.JugadorEntity

interface JugadorDao {
    @Query("SELECT * FROM jugador_entity")
    suspend fun getAllJugadores(): MutableList<JugadorEntity>

    @Insert
    suspend fun addJugador(taskEntity : JugadorEntity):Long

    @Query("SELECT * FROM jugador_entity where id like :id")
    suspend fun getJugadorById(id: Long): JugadorEntity

    @Update
    suspend fun updateJugador(task: JugadorEntity):Int

    @Delete
    suspend fun deleteJugador(task: JugadorEntity):Int
}