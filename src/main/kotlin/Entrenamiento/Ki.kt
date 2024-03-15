package org.example.Entrenamiento

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Estadisticas
import org.example.Estadisticas.Porcentajes

/**
 * Clase que implementa la interfaz Entrenador para entrenar el ki de un personaje.
 */
class Ki : Entrenador {
    /**
     * Función que entrena el ki de un personaje.
     * @param estadisticas Las estadísticas del personaje que se están entrenando.
     * @param dificultad La dificultad del entrenamiento, que influye en el aumento de ki.
     */
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad) {
        // Aumenta el ki del personaje en función de la dificultad y el porcentaje definido en Porcentajes.
        estadisticas.ki += estadisticas.ki * Porcentajes().porcentajeUsuario(dificultad)
    }
}
