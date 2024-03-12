package org.example

class Velocidad : Entrenador  {
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.velocidad += estadisticas.velocidad * porcentaje.porcentajeUsuario(dificultad)

    }
}