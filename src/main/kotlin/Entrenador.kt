package org.example

interface Entrenador  {
    fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes){
        estadisticas.nivel += porcentaje.porcentajeUsuario(dificultad)

    }
}