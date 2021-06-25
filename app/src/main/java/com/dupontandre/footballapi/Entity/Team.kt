package com.dupontandre.footballapi.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team (
    @PrimaryKey(autoGenerate = false)
    val nombreEquipo : String,
    @ColumnInfo(name = "estadio")
    val estadio : String,
    @ColumnInfo(name = "puntaje")
    val puntaje : Int,
    // FK
    val nombreCampeonato : String
)