package org.example.Personajes

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.EstadisticasSegunGenero
import org.example.Estadisticas.Generos

class Gottens(genero: Generos, val nombre: String, dificultad: Dificultad): EstadisticasSegunGenero(){
    var estadisticas = estadisticasIniciales(genero, dificultad)
}
