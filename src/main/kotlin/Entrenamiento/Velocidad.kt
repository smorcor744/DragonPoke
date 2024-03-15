package org.example.Entrenamiento

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Estadisticas
import org.example.Estadisticas.Porcentajes

/**
 * Clase que implementa la interfaz Entrenador para entrenar la velocidad de un personaje.
 */
class Velocidad : Entrenador {
    /**
     * Función que entrena la velocidad de un personaje.
     * @param estadisticas Las estadísticas del personaje que se están entrenando.
     * @param dificultad La dificultad del entrenamiento, que influye en el aumento de velocidad.
     */
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad) {
        // Aumenta la velocidad del personaje en función de la dificultad y el porcentaje definido en Porcentajes.
        estadisticas.velocidad += estadisticas.velocidad * Porcentajes().porcentajeUsuario(dificultad)
    }
}
