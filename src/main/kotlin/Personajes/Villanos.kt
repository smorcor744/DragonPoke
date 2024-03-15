package org.example.Personajes

import org.example.Estadisticas.*
/**
 * Clase que representa a un villano en el juego.
 * @property raza La raza del villano.
 * @property nombre El nombre del villano.
 * @property genero El género del villano.
 * @property dificultad La dificultad del juego.
 * @property posicion La posición del villano en el mapa.
 * @property estadisticas Las estadísticas del villano.
 */
class Villano(var raza: Razas,
              var nombre: String,
              genero: Generos,
              dificultad: Dificultad,
              var posicion: Pair<Int, Int>): EstadisticasSegunGenero(){

    var estadisticas = estadisticasIniciales(genero, dificultad)
    /**
     * Las estadísticas iniciales del villano según el género y la dificultad del juego.
     * @param genero El género del villano.
     * @param dificultad La dificultad del juego.
     * @return Las estadísticas iniciales del villano.
     */
    override fun estadisticasIniciales(genero: Generos, dificultad: Dificultad): Estadisticas {
        estadisticas = when (dificultad){
            Dificultad.EXTREMO -> Estadisticas(salud*3, ki*3, stamina*3, velocidad*3, nivel, fuerza*3, ki,
                stamina, salud)
            Dificultad.DIFICIL -> Estadisticas(salud*2, ki*2, stamina*2, velocidad*2, nivel, fuerza*2,ki,
                stamina,salud)
            Dificultad.NORMAL -> Estadisticas(salud, ki, stamina, velocidad, nivel, fuerza, ki,
                stamina,salud)
            Dificultad.PUSSY -> Estadisticas(salud*1/2, ki*1/2, stamina*1/2, velocidad*1/2, nivel, fuerza*1/2, ki,
                stamina,salud)
        }
        return estadisticas
    }
}
