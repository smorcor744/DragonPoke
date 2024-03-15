package org.example.Personajes

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.EstadisticasSegunGenero
import org.example.Estadisticas.Generos

/**
 * Clase que representa al personaje principal, Gottens.
 * @property genero El género del personaje.
 * @property nombre El nombre del personaje.
 * @property dificultad La dificultad del juego.
 * @property estadisticas Las estadísticas del personaje.
 */
class Gottens(genero: Generos, val nombre: String, dificultad: Dificultad): EstadisticasSegunGenero() {
    var estadisticas = estadisticasIniciales(genero, dificultad)
}
