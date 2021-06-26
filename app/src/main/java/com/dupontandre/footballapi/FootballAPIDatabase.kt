
package com.dupontandre.footballapi

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dupontandre.footballapi.DAO.FootballAPIDao
import com.dupontandre.footballapi.Entity.Competition
import com.dupontandre.footballapi.Entity.Team
import com.dupontandre.footballapi.fragments.HomeFragment


@Database(entities = [Competition::class, Team::class], version = 1)
abstract class FootballAPIDatabase : RoomDatabase() {
    abstract val footballAPIDao : FootballAPIDao
    companion object{
        @Volatile
        private var INSTANCE : FootballAPIDatabase? = null
        fun getInstance(context: HomeFragment) : FootballAPIDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.requireContext(),
                    FootballAPIDatabase::class.java,
                    "FootballApiDB"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}

