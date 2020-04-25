package com.example.domacizadatak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lista_automobila.view.*

class ListaAutomobiliFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_lista_automobila,container,false)
        val lista_Automobila=view.lista_automobila
        lista_Automobila.adapter=MojAdapter(view.context)

        return view
    }

    companion object{
        fun newInstance():ListaAutomobiliFragment= ListaAutomobiliFragment()
    }

    private class MojAdapter(context:Context):BaseAdapter(){
        private val mContext:Context=context
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val textView:TextView= TextView(mContext)
            //val subStr=AutomobiliLister.automobili.get(p0).tekstOglasa.substring(0,10)
            textView.setText(AutomobiliLister.automobili.get(p0).naslovOglasa+"\n Cena: "+AutomobiliLister.automobili.get(p0).cena+"e")
            textView.setOnClickListener({
                val intent=Intent(mContext,DetaljanPrikazAutomobila::class.java)
                intent.putExtra("Id","${AutomobiliLister.automobili.get(p0).id}")
                mContext.startActivity(intent)
            })
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F)
            return textView
        }

        override fun getItem(p0: Int): Any {
            return AutomobiliLister.automobili.get(p0)
        }

        override fun getItemId(p0: Int): Long {
            return AutomobiliLister.automobili.get(p0).id.toLong()

        }

        override fun getCount(): Int {
            return AutomobiliLister.automobili.size

        }

    }

}