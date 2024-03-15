package org.example.Estadisticas

/**
 * Clase que gestiona los porcentajes según la dificultad del juego.
 */
class Porcentajes {
    /**
     * Devuelve el porcentaje correspondiente según la dificultad del juego.
     * @param dificultad La dificultad del juego.
     * @return El porcentaje asociado a la dificultad.
     */
    fun porcentajeUsuario(dificultad: Dificultad): Double {
        return when (dificultad) {
            Dificultad.EXTREMO -> 0.2
            Dificultad.DIFICIL -> 0.4
            Dificultad.NORMAL -> 0.6
            Dificultad.PUSSY -> 0.8
        }
    }
}
