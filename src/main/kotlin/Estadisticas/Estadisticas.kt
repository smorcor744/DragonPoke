package org.example.Estadisticas

/**
 * Clase que representa las estadísticas de un personaje.
 * @property salud La salud del personaje.
 * @property ki El ki del personaje.
 * @property stamina La resistencia del personaje.
 * @property velocidad La velocidad del personaje.
 * @property nivel El nivel del personaje.
 * @property fuerza La fuerza del personaje.
 * @property nivelKi El nivel de ki del personaje.
 * @property nivelStamina El nivel de stamina del personaje.
 * @property saludMaxima La salud máxima del personaje.
 */
data class Estadisticas(
    var salud: Double,
    var ki: Double,
    var stamina: Double,
    var velocidad: Double,
    var nivel: Double,
    var fuerza: Double,
    var nivelKi: Double,
    var nivelStamina: Double,
    var saludMaxima: Double
)
