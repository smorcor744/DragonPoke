package org.example.Estadisticas

/**
 * Clase base para definir estadísticas según el género del personaje.
 */
open class EstadisticasSegunGenero {
    companion object {
        // Estadísticas base para todos los géneros
        var nivelstamina: Double = 10.0
        var salud: Double = 100.0
        var nivelKi = 10.0
        var velocidad: Double = 10.0
        var nivel: Double = 1.0
        var fuerza: Double = 10.0

        // Estadísticas específicas para género femenino
        var fuerzaFemina = 8.0
        var velocidadFemina = 12.0

        // Estadísticas específicas para género Apache
        var fuerzaApache = 20.0
        var velocidadApache = 5.0

        // Valores iniciales para ki, stamina y salud máxima
        var ki: Double = nivelKi
        var stamina = nivelstamina
        var saludMaxima = salud
    }

    /**
     * Calcula las estadísticas iniciales de un personaje según su género y la dificultad del juego.
     * @param genero El género del personaje.
     * @param dificultad La dificultad del juego.
     * @return Las estadísticas iniciales del personaje.
     */
    open fun estadisticasIniciales(genero: Generos, dificultad: Dificultad): Estadisticas {
        return when (genero) {
            Generos.MASCULINO, Generos.NO_BINARIO -> Estadisticas(
                salud * nivel, ki * nivel, stamina * nivel, velocidad * nivel, nivel, fuerza * nivel, nivelKi * nivel,
                nivelstamina * nivel, saludMaxima * nivel
            )
            Generos.FEMENINO -> Estadisticas(
                salud * nivel, ki * nivel, stamina * nivel, velocidadFemina * nivel, nivel, fuerzaFemina * nivel, nivelKi * nivel,
                nivelstamina * nivel, saludMaxima * nivel
            )
            Generos.AH_64_APACHE -> Estadisticas(
                salud * nivel, ki * nivel, stamina * nivel, velocidadApache * nivel, nivel, fuerzaApache * nivel, nivelKi * nivel,
                nivelstamina * nivel, saludMaxima * nivel
            )
        }
    }
}


