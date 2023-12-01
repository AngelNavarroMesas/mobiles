package com.example.examen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="tConfiguracion")
data class clsConfiguracion (

    @ColumnInfo(name = "NumVacas")
    var numVacas: Int = 0,

    @PrimaryKey
    @ColumnInfo(name = "Max")
    var max: Int = 0
)

@Entity(tableName = "tMilk")
data class clsMilk(
    @PrimaryKey
    @ColumnInfo(name = "Id")
    var id: Long = 0,

    @ColumnInfo(name = "Fecha")
    var Fecha: Long = 0,

    @ColumnInfo(name = "IdVaca")
    var idVaca: Long = 0,

    @ColumnInfo(name = "Litros")
    var litros: Int = 0
)

@Entity(tableName ="tVaca")
data class clsVaca (
    @PrimaryKey
    @ColumnInfo(name = "Id")
    var id: Int = 0,

    @ColumnInfo(name = "LitrosExtraidos")
    var lExtraidos: Int = 0
)