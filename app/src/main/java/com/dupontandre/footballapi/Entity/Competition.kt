package com.dupontandre.footballapi.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Competition (
    @PrimaryKey(autoGenerate = false)
    val nombreCampeonato : String,
    @ColumnInfo(name = "temporadasDisponibles")
    val temporadasDisponibles : Int
    )

