package com.dupontandre.footballapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.dupontandre.footballapi.DAO.FootballAPIDao
import com.dupontandre.footballapi.Entity.Competition
import com.dupontandre.footballapi.Entity.Team
import com.dupontandre.footballapi.FootballAPIDatabase
import com.dupontandre.footballapi.R
import com.dupontandre.footballapi.adapter.CompeticionRVAdapter
import com.dupontandre.footballapi.adapter.OnCompetitionItemClickListener
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home), OnCompetitionItemClickListener{
    var rviCompeticiones : RecyclerView ?= null
    var competiciones : List<Competition> ?= null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dao : FootballAPIDao = FootballAPIDatabase.getInstance(this).footballAPIDao
        val competitions = listOf(
            Competition("Campeonato Brasileiro Serie A", 5),
            Competition("Premier League", 29),
            Competition("European Championship", 16),
            Competition("Ligue 1", 11),
            Competition("Bundesliga", 26),
            Competition("Serie A", 17),
            Competition("Eredivise", 12),
            Competition("Primeira Liga", 10),
            Competition("Liga Santander", 27),
        )
        val teams = listOf(
            Team("Fluminense FC", "Estadio Jornalista Mario Filbo","Campeonato Brasileiro Serie A"),
            Team("CA Mineiro", "Estadio Raimundo Sampaio","Campeonato Brasileiro Serie A"),
            Team("Gremio FBPA", "Arena do Gremio","Campeonato Brasileiro Serie A"),
            Team("CA Paranaense", "Estádio Joaquim Américo Guimarães","Campeonato Brasileiro Serie A"),
            Team("SE Palmeiras", "Allianz Parque","Campeonato Brasileiro Serie A"),
            Team("Chapecoense AF", "Arena Condá","Campeonato Brasileiro Serie A"),
            Team("São Paulo FC", "Estádio do Morumbi","Campeonato Brasileiro Serie A"),
            Team("EC Bahia", "Estádio Governador Roberto Santos","Campeonato Brasileiro Serie A"),
            Team("SC Recife", "Estádio Adelmar da Costa Carvalho","Campeonato Brasileiro Serie A"),
            Team("SC Corinthians Paulista", "Neo Química Arena","Campeonato Brasileiro Serie A"),
            Team("CR Flamengo", "Estadio Jornalista Mário Filho","Campeonato Brasileiro Serie A"),
            Team("Ceará SC", "Estádio Castelão","Campeonato Brasileiro Serie A"),
            Team("América FC", "Estádio Raimundo Sampaio","Campeonato Brasileiro Serie A"),
            Team("Fortaleza EC", "Estádio Castelão","Campeonato Brasileiro Serie A"),
            Team("AC Goianiense", "Estádio Olímpico Pedro Ludovico Teixeira","Campeonato Brasileiro Serie A"),
            Team("EC Juventude", "Estádio Alfredo Jaconi","Campeonato Brasileiro Serie A"),
            Team("RB Bragantino", "Estádio Nabi Abi Chedid","Campeonato Brasileiro Serie A"),
            Team("Cuiabá EC", "Arena Pantanal","Campeonato Brasileiro Serie A"),
            Team("SC Internacional", "Estádio José Pinheiro Borba","Campeonato Brasileiro Serie A"),
            Team("Santos FC", "Estádio Urbano Caldeira","Campeonato Brasileiro Serie A"),
            Team("Arsenal FC", "Emirates Stadium","Premier League"),
            Team("Aston Villa FC", "Villa Park","Premier League"),
            Team("Chelsea FC", "Stamford Bridge","Premier League"),
            Team("Everton FC", "Goodison Park","Premier League"),
            Team("Liverpool FC", "Anfield","Premier League"),
            Team("Manchester City FC", "Etihad Stadium","Premier League"),
            Team("Manchester United FC", "Old Trafford","Premier League"),
            Team("Newcastle United FC", "St. James' Park","Premier League"),
            Team("Norwich City FC", "Carrow Road","Premier League"),
            Team("Tottenham Hotspur FC", "Tottenham Hotspur Stadium","Premier League"),
            Team("Wolverhampton Wanderers FC", "Molineux Stadium","Premier League"),
            Team("Burnley FC", "Turf Moor","Premier League"),
            Team("Leicester City FC", "King Power Stadium","Premier League"),
            Team("Southampton FC", "St. Mary's Stadium","Premier League"),
            Team("Leeds United FC", "Elland Road","Premier League"),
            Team("Watford FC", "Vicarage Road Stadium","Premier League"),
            Team("Crystal Palace FC", "Selhurst Park","Premier League"),
            Team("Brighton & Hove Albion FC", "The American Express Community Stadium","Premier League"),
            Team("Brentford FC", "Griffin Park","Premier League"),
            Team("West Ham United FC", "London Stadium","Premier League"),
            Team("Germany", "RheinEnergieSTADION", "European Championship"),
            Team("Spain", "Estadio Alfredo Di Stéfano", "European Championship"),
            Team("Portugal", "Estádio José Alvalade", "European Championship"),
            Team("Slovakia", "City Arena Trnava", "European Championship"),
            Team("England", "Wembley Stadium", "European Championship"),
            Team("France", "Stade de France", "European Championship"),
            Team("Denmark", "Telia Parken", "European Championship"),
            Team("Italy", "Stadio Artemio Franchi", "European Championship"),
            Team("Switzerland", "St. Jakob-Park", "European Championship"),
            Team("Ukraine", "NSK Olimpijs'kyj", "European Championship"),
            Team("Sweden", "Friends Arena", "European Championship"),
            Team("Poland", "Stadion Energa Gdańsk", "European Championship"),
            Team("Czech Republic", "Sinobo Stadium", "European Championship"),
            Team("Croatia", "Stadion Maksimir", "European Championship"),
            Team("Turkey", "Ali Sami Yen Stadyumu", "European Championship"),
            Team("Belgium", "King Power at Den Dreef Stadion", "European Championship"),
            Team("Russia", "VTB Arena", "European Championship"),
            Team("Austria", "Ernst-Happel-Stadion", "European Championship"),
            Team("Hungary", "Puskás Aréna", "European Championship"),
            Team("Wales", "Cardiff City Stadium", "European Championship"),
            Team("Finland", "Helsingin olympiastadion", "European Championship"),
            Team("North Macedonia", "Nationala Arena Toše Proeski", "European Championship"),
            Team("Netherlands", "Johan Cruyff ArenA", "European Championship"),
            Team("Scotland", "Hampden Park", "European Championship"),
        )
        lifecycleScope.launch {
            competitions.forEach { dao.insertCompetition(it) }
            teams.forEach { dao.insertTeam(it) }
            competiciones = dao.selectAllCompetitions()
        }
        val competicionesRVAdapter = CompeticionRVAdapter(ArrayList(competiciones), this, requireActivity())
        rviCompeticiones!!.adapter = competicionesRVAdapter
    }

    override fun onClick(competicion: Competition) {
        Toast.makeText(context, competicion.nombreCampeonato, Toast.LENGTH_LONG).show()
    }


}