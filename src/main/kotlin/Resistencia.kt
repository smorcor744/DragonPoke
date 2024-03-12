package org.example

class Resistencia : Entrenador{
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.stamina += estadisticas.stamina * porcentaje.porcentajeUsuario(dificultad)

    }
}
