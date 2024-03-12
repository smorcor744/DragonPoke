package org.example

class Ki : Entrenador  {
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.ki += estadisticas.ki * porcentaje.porcentajeUsuario(dificultad)
    }
}