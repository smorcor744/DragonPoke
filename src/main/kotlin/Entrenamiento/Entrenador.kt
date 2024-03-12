package org.example.Entrenamiento

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Estadisticas
import org.example.Estadisticas.Porcentajes

interface Entrenador  {
    fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes){
        estadisticas.nivel += porcentaje.porcentajeUsuario(dificultad)

    }
}