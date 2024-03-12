package org.example.Mapas

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Generos
import org.example.Estadisticas.Razas
import org.example.Personajes.Villanos

class Pueblo : Mapa() {
    init {
        val villano1 = Villanos(Razas.TERRICOLA, "Tenshinhan Bizco", Generos.MASCULINO, Dificultad.PUSSY)
        val villano2 = Villanos(Razas.TERRICOLA, "Krilling Corrupto", Generos.MASCULINO, Dificultad.NORMAL)
        val villano3 = Villanos(Razas.TERRICOLA, "Yamcha", Generos.MASCULINO, Dificultad.DIFICIL)
        val villano4 = Villanos(Razas.NAMEKIANO, "Piccolo Corrupto", Generos.MASCULINO, Dificultad.NORMAL)
        val villano5 = Villanos(Razas.NAMEKIANO, "Dende Tenebroso", Generos.MASCULINO, Dificultad.DIFICIL)
        val villano6 = Villanos(Razas.SAIYAN, "Broly Furioso", Generos.MASCULINO, Dificultad.NORMAL)
        val villano7 = Villanos(Razas.NAMEKIANO, "Black Frieza", Generos.MASCULINO, Dificultad.EXTREMO)
        val semiboss = Villanos(Razas.SAIYAN, "Majin Vegeta", Generos.MASCULINO, Dificultad.DIFICIL)
        val boss = Villanos(Razas.SAIYAN, "Goku Black", Generos.MASCULINO, Dificultad.EXTREMO)



    }
    override var mapa: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"),
        mutableListOf("#","#"," "," "," "," "," "," "," ","#"," ","%","#"," "," "," "," "," "," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#"," ","%"," "," "," "," "," ","%","#"," "," ","#"," "," "," "," "," "," "," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#","#","#","#","#"," ","#"," ","#","#"," ","#","#","#","#","#"," ","#"," "," "," "," ","|","#","#","#","#","|"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," "," "," ","#"," "," ","%","#"," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," "," "," ","#"," "," "," ","#"," ","#"," "," "," "," ","|","#","#","#","#","|"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," ","#","#","#"," "," "," ","#"," ","#"," "," "," "," ","#","#","_","_","#","#"," "," "," ","#","#","_","_","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," "," "," "," "," "," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@"," "," "," "," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#","#","#","#","#","#","#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#","%"," "," "," "," "," ","%","#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#","#","#","#","#","#","#","#","#"," "," ","#"," ","#"," "," "," "," ","#","#","_","_","#","#"," "," "," ","#","#","_","_","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","%","#"," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," "," "," "," "," ","#","#","#","#","#","#","#","#","%","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#","%"," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"))

}