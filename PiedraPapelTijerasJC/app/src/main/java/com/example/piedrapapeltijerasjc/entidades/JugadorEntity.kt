package com.example.piedrapapeltijerasjc.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugador_entity")
data class JugadorEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var name:String = "",
    var partidas: Int = 0,
    var puntuacion:Int = 0
)