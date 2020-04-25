package com.example.domacizadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar


    fun openFragment(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    val mOnNavigationItemSelectedLister=BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        when(item.itemId){
            R.id.navigation_svi_automobili->{
                toolbar.title="Svi Automobili"
                val sviAutomobiliFragment=ListaAutomobiliFragment.newInstance()
                openFragment(sviAutomobiliFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dodaj_automobil->{
                toolbar.title="Dodaj Automobil"
                val dodajAutomobilFragment=DodajAutomobilFragment.newInstance()
                openFragment(dodajAutomobilFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_rez_automobili->{
                toolbar.title="Rezervisani Automobili"
                val rezervisaniAutomobiliFragment=RezervisaniAutomobiliFragment.newInstance()
                openFragment(rezervisaniAutomobiliFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=supportActionBar!!
        val bottomNavigationView:BottomNavigationView=findViewById(R.id.navigatioView)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedLister)
        openFragment(ListaAutomobiliFragment.newInstance())


    }


}
