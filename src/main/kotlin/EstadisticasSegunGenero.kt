package org.example

open class EstadisticasSegunGenero {
    companion object {
        var nivelstamina: Double = 10.0
        var salud: Double = 100.0
        var nivelKi = 10.0
        var velocidad: Double = 10.0
        var nivel: Double = 1.0
        var fuerza: Double = 10.0
        var fuerzaFemina = 8.0
        var velocidadFemina = 12.0
        var fuerzaApache = 20.0
        var velocidadApache = 5.0
        var ki: Double = nivelKi
        var stamina = nivelstamina
    }




    open fun estadisticasIniciales(genero: Generos,dificultad: Dificultad): Estadisticas {
        return when (genero) {
            Generos.MASCULINO, Generos.NO_BINARIO -> Estadisticas(salud * nivel, ki * nivel, stamina * nivel, velocidad * nivel, nivel, fuerza * nivel, nivelKi * nivel,
                nivelstamina * nivel)
            Generos.FEMENINO -> Estadisticas(salud * nivel, ki * nivel, stamina * nivel, velocidadFemina * nivel, nivel, fuerzaFemina * nivel, nivelKi * nivel,
                nivelstamina * nivel)
            Generos.AH_64_APACHE -> Estadisticas(salud * nivel, ki * nivel, stamina * nivel, velocidadApache * nivel, nivel , fuerzaApache * nivel, nivelKi * nivel,
                nivelstamina * nivel)
        }
    }
}

