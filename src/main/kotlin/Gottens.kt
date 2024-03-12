package org.example

class Gottens(genero: Generos, val nombre: String, dificultad: Dificultad):EstadisticasSegunGenero(){
    var estadisticas = estadisticasIniciales(genero, dificultad)
}
