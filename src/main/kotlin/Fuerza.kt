package org.example

class Fuerza : Entrenador  {
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.fuerza += estadisticas.fuerza * porcentaje.porcentajeUsuario(dificultad)

    }
}