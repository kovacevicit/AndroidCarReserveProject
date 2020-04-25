package com.example.domacizadatak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dodaj_automobil.*

class DodajAutomobilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_dodaj_automobil,container,false)
        val dugme:Button=view.findViewById(R.id.dodajOglas)
        dugme.setOnClickListener({
            if (naslovOglasa.text.toString()!="" && tekstOglasa.text.toString()!="" && cenaAutomobila.text.toString()!=""){
            AutomobiliLister.automobili.add(Automobili(Automobili.idAuto,naslovOglasa.text.toString(),tekstOglasa.text.toString(),cenaAutomobila.text.toString().toInt()))
            Automobili.idAuto++
            Toast.makeText(view.context,"Uspesno ste dodali oglas",Toast.LENGTH_SHORT).show()
           // Toast.makeText(view.context,"${Automobili.idAuto}",Toast.LENGTH_LONG).show()
                naslovOglasa.setText("")
                tekstOglasa.setText("")
                cenaAutomobila.setText("")
            }
            else{
                Toast.makeText(view.context,"Molimo popunite sva polja",Toast.LENGTH_SHORT).show()
            }
        })
        return view

    }

    companion object{
        fun newInstance():DodajAutomobilFragment= DodajAutomobilFragment()
    }

}