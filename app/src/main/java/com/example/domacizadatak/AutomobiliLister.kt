package com.example.domacizadatak

class AutomobiliLister {
    companion object{
        val automobili= mutableListOf<Automobili>(Automobili(100,"BMW 318d","BMW 318d kao nov, registrovan do 2021",5000),
            Automobili(101,"YUGO Koral 2007","Polovan Yugo Koral u voznom stanju, bez ostecenja",540),
            Automobili(102,"Chevrolet Impala","Odlicno stanje, oldtajmer, sedi i vozi",20000),
            Automobili(103,"Nissan Qaskai 2012","Polovni Nissan, odlicno stanje, nije registrovan",6700),
            Automobili(104,"AUDI A8","Top stanje, presao 100000km, registrovan",6200))
        val rezAutomobili:MutableList<Automobili> = mutableListOf()
    }
}