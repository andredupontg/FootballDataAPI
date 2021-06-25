package com.dupontandre.footballapi.Entity.Relationship

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.dupontandre.footballapi.Entity.Competition
import com.dupontandre.footballapi.Entity.Team

@Entity
data class CompetitionTeam (
    @Embedded val competition : Competition,
    @Relation(
        parentColumn = "nombreCampeonato",
        entityColumn = "nombreCampeonato"
    )
    val teams : List<Team>
)