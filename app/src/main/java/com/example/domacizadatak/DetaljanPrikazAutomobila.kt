package com.example.domacizadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class DetaljanPrikazAutomobila : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout=LinearLayout(this)
        linearLayout.orientation=LinearLayout.VERTICAL

        val prosledjenID:Int=intent.getStringExtra("Id").toInt()
        for(item in AutomobiliLister.automobili){
            if (item.id==prosledjenID){
                val textView:TextView= TextView(this)
                textView.setText("Detaljan prikaz Automobila")
                textView.textAlignment=TextView.TEXT_ALIGNMENT_CENTER
                textView.setTextSize(22F)
                linearLayout.addView(textView)
                val tittleOglasa:TextView=TextView(this)
                tittleOglasa.setText(item.naslovOglasa)
                tittleOglasa.textAlignment=TextView.TEXT_ALIGNMENT_TEXT_START
                tittleOglasa.setTextSize(20F)
                linearLayout.addView(tittleOglasa)
                val textOglasa:TextView= TextView(this)
                textOglasa.setText(item.tekstOglasa)
                textOglasa.textAlignment=TextView.TEXT_ALIGNMENT_TEXT_START
                textOglasa.setTextSize(20F)
                linearLayout.addView(textOglasa)
                val cenaAuta:TextView= TextView(this)
                cenaAuta.setText(item.cena.toString()+"e")
                cenaAuta.textAlignment=TextView.TEXT_ALIGNMENT_TEXT_START
                cenaAuta.setTextSize(20F)
                linearLayout.addView(cenaAuta)
                val dugme:Button= Button(this)
                dugme.setText("Rezervisi")
                dugme.setTextSize(16F)
                dugme.setOnClickListener({
                    AutomobiliLister.rezAutomobili.add(Automobili(item.id,item.naslovOglasa,item.tekstOglasa,item.cena))
                    Toast.makeText(this,"Uspesno ste rezervisali automobil",Toast.LENGTH_LONG).show()
                    dugme.isEnabled=false
                })
                linearLayout.addView(dugme)
            }
        }
        setContentView(linearLayout)
    }
}
