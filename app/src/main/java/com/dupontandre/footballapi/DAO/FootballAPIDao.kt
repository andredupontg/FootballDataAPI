
package com.dupontandre.footballapi.DAO

import androidx.room.*
import com.dupontandre.footballapi.Entity.Competition
import com.dupontandre.footballapi.Entity.Relationship.CompetitionTeam
import com.dupontandre.footballapi.Entity.Team

@Dao
interface FootballAPIDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetition(competition: Competition)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team : Team)

    @Transaction
    @Query("SELECT * FROM Competition")
    suspend fun selectAllCompetitions() : List<Competition>
/*
    @Transaction
    @Query("SELECT * FROM Team WHERE nombreCampeonato = :nombreCampeonato")
    suspend fun selectAllTeamsByCompetitionId(nombreCampeonato : String) : List<CompetitionTeam>
*/
}
