package com.dupontandre.footballapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dupontandre.footballapi.Entity.Competition
import com.dupontandre.footballapi.R

interface OnCompetitionItemClickListener {
    fun onClick(competicion : Competition)
}
class CompeticionRVAdapter : RecyclerView.Adapter<CompeticionRVAdapter.ViewHolder>{
    class ViewHolder : RecyclerView.ViewHolder {
        var tviNombreCompeticion : TextView? = null
        var tviTemporadasCompeticion : TextView? = null

        constructor(view : View) : super(view) {
            tviNombreCompeticion = view.findViewById(R.id.tviNombreCompeticion)
            tviTemporadasCompeticion = view.findViewById(R.id.tviTemporadasCompeticion)
        }
    }

    private var competiciones : ArrayList<Competition>? = null
    private var listener : OnCompetitionItemClickListener? = null
    private var context : Context? = null

    constructor(competiciones : ArrayList<Competition>,
                listener : OnCompetitionItemClickListener,
                context : Context) : super(){
        this.competiciones = competiciones
        this.listener = listener
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_competiciones, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val competicion = competiciones!![position]

        holder.tviNombreCompeticion!!.text = competicion.nombreCampeonato
        holder.tviTemporadasCompeticion!!.text = competicion.temporadasDisponibles.toString()
        holder.itemView.setOnClickListener { v : View ->
            listener!!.onClick(competiciones!![position])
        }
    }

    override fun getItemCount(): Int {
        return competiciones!!.size;
    }
}

