package org.example.Estadisticas

import org.example.Estadisticas.Dificultad

class Porcentajes {

    fun porcentajeUsuario(dificultad: Dificultad): Double {
        return when (dificultad) {
            Dificultad.EXTREMO -> 0.2
            Dificultad.DIFICIL -> 0.4
            Dificultad.NORMAL -> 0.6
            Dificultad.PUSSY -> 0.8
        }
    }




    fun porcentajeNpc(dificultad: Dificultad): Double {
        return when (dificultad) {
            Dificultad.EXTREMO -> 0.8
            Dificultad.DIFICIL -> 0.6
            Dificultad.NORMAL -> 0.4
            Dificultad.PUSSY -> 0.2
        }
    }
}
