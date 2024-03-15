package org.example.Entrenamiento

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Estadisticas
import org.example.Estadisticas.Porcentajes

/**
 * Interfaz que define el comportamiento de un entrenador en el sistema.
 */
interface Entrenador {
    /**
     * Función para entrenar las estadísticas de un personaje.
     * @param estadisticas Las estadísticas del personaje que se están entrenando.
     * @param dificultad La dificultad del entrenamiento, que influye en el aumento de nivel.
     */
    fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad) {
        // Aumenta el nivel del personaje en función de la dificultad y el porcentaje definido en Porcentajes.
        estadisticas.nivel += Porcentajes().porcentajeUsuario(dificultad)
    }
}
