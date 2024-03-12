package org.example

class Villanos(var raza: Razas,var nombre: String,genero: Generos,dificultad: Dificultad):EstadisticasSegunGenero(){
    var estadisticas = estadisticasIniciales(genero, dificultad)
    override fun estadisticasIniciales(genero: Generos,dificultad: Dificultad): Estadisticas {
        estadisticas = when (dificultad){
            Dificultad.EXTREMO -> Estadisticas(salud*3, ki*3, stamina*3, velocidad*3, nivel, fuerza*3, ki,
                stamina)
            Dificultad.DIFICIL -> Estadisticas(salud*2, ki*2, stamina*2, velocidad*2, nivel, fuerza*2,ki,
                stamina)
            Dificultad.NORMAL -> Estadisticas(salud, ki, stamina, velocidad, nivel, fuerza, ki,
                stamina)
            Dificultad.PUSSY -> Estadisticas(salud*1/2, ki*1/2, stamina*1/2, velocidad*1/2, nivel, fuerza*1/2, ki,
                stamina)
        }
        return estadisticas
    }
}
