package com.example.domacizadatak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lista_automobila.view.*
import kotlinx.android.synthetic.main.fragment_rezervisani_automobili.view.*

class RezervisaniAutomobiliFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =inflater.inflate(R.layout.fragment_rezervisani_automobili,container,false)
        val lista_AutomobilaRez=view.rezervisani_automobili
        lista_AutomobilaRez.adapter=MojAdapter(view.context)

        return view
    }

    companion object{
        fun newInstance():RezervisaniAutomobiliFragment= RezervisaniAutomobiliFragment()
    }

    private class MojAdapter(context: Context): BaseAdapter(){
        private val mContext1: Context =context
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val textView: TextView = TextView(mContext1)
            var br:Int=0;
            for(item in AutomobiliLister.rezAutomobili){
                if(AutomobiliLister.automobili.get(p0).id==item.id){
                    br++
                }
            }
            if(br>0){
            textView.setText(AutomobiliLister.automobili.get(p0).naslovOglasa+" Broj rezervacija: "+br)
            textView.setOnClickListener({
                Toast.makeText(mContext1,"Vec ste rezervisali ovaj automobil",Toast.LENGTH_SHORT).show()

            })
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F)
                return textView
            }

            return textView

        }

        override fun getItem(p0: Int): Any {
            return AutomobiliLister.automobili.get(p0)
        }

        override fun getItemId(p0: Int): Long {
            //TODO("Not yet implemented")
            return AutomobiliLister.automobili.get(p0).id.toLong()
        }

        override fun getCount(): Int {
            return AutomobiliLister.automobili.size
        }



    }
}