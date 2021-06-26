package com.dupontandre.footballapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import com.dupontandre.footballapi.DAO.FootballAPIDao
import com.dupontandre.footballapi.Entity.Competition
import com.dupontandre.footballapi.Entity.Team
import com.dupontandre.footballapi.fragments.EquiposFragment
import com.dupontandre.footballapi.fragments.HomeFragment
import com.dupontandre.footballapi.fragments.PosicionesFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view .setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_home ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }
                R.id.nav_equipos ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, EquiposFragment())
                        commit()
                    }
                }
                R.id.nav_posiciones ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, PosicionesFragment())
                        commit()
                    }
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}