package org.example

import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Generos
import org.example.Estadisticas.Razas
import org.example.Mapas.Inicio
import org.example.Mapas.Movimiento
import org.example.Personajes.Gottens
import org.example.Personajes.Villano

/**
 * Función para limpiar la consola imprimiendo varias líneas en blanco.
 */
fun limpiarConsola() {
    repeat(100) {
        println()
    }
}

/**
 * Función para crear un mapa con las posiciones y los villanos.
 */
fun villanoss():MutableMap<Pair<Int,Int>,Villano>{
    val villano1 = Villano(Razas.TERRICOLA, "Tenshinhan Bizco", Generos.MASCULINO, Dificultad.PUSSY,13 to 19)
    val villano2 = Villano(Razas.TERRICOLA, "Krilling Corrupto", Generos.MASCULINO, Dificultad.NORMAL,1 to 11)
    val villano3 = Villano(Razas.TERRICOLA, "Yamcha", Generos.MASCULINO, Dificultad.DIFICIL,4 to 17)
    val villano4 = Villano(Razas.NAMEKIANO, "Piccolo Corrupto", Generos.MASCULINO, Dificultad.NORMAL,12 to 17)
    val villano5 = Villano(Razas.NAMEKIANO, "Dende Tenebroso", Generos.MASCULINO, Dificultad.DIFICIL,15 to 1)
    val villano6 = Villano(Razas.SAIYAN, "Broly Furioso", Generos.MASCULINO, Dificultad.NORMAL,2 to 2)
    val villano7 = Villano(Razas.NAMEKIANO, "Black Frieza", Generos.MASCULINO, Dificultad.EXTREMO,2 to 8)
    val semiboss = Villano(Razas.SAIYAN, "Majin Vegeta", Generos.MASCULINO, Dificultad.DIFICIL,9 to 8)
    val boss = Villano(Razas.SAIYAN, "Goku Black", Generos.MASCULINO, Dificultad.EXTREMO,9 to 14)
    val villanos:MutableMap<Pair<Int,Int>,Villano> = mutableMapOf(villano1.posicion to villano1,villano2.posicion to villano2,villano3.posicion to villano3,villano4.posicion to villano4,villano5.posicion to villano5,villano6.posicion to villano6,villano7.posicion to villano7,semiboss.posicion to semiboss,boss.posicion to boss)
    return  villanos

}
/**
 * Función principal que inicia el juego.
 */
fun main() {
    try {
        var dificultad: Dificultad = Dificultad.EXTREMO
        var genero : Generos = Generos.MASCULINO

        Inicio().mostrarMapa()
        println("Ingresa tu nombre: ")
        val nombre = readln()

        println("Selecciona tu género (MASCULINO, FEMENINO, NO_BINARIO, AH_64_APACHE): ")
        genero = Generos.valueOf(readln().uppercase())

        println("Selecciona la dificultad (EXTREMO, DIFICIL, NORMAL, PUSSY): ")
        dificultad = Dificultad.valueOf(readln().uppercase())

        val gottens = Gottens(genero, nombre, dificultad)
        val villanos = villanoss()
        println("¡Bienvenido ${gottens.nombre}!")
        println("Estadísticas iniciales: ${gottens.estadisticas}")
        readln()
        val movimiento = Movimiento()

        while (true) {
            movimiento.mover(gottens, villanos, Dificultad.NORMAL)
            if (villanos.isEmpty()) {
                Final().mostrarMensaje()
                break // Salir del bucle mientras
            }
        }
    } catch (e: Exception) {
        println("Ha ocurrido un error: ${e.message}")
    }
}




/**
 * Clase que muestra un mensaje de felicitación cuando se completa el juego.
 */
class Final {
    /**
     * Muestra un mensaje de felicitación cuando el jugador completa el juego.
     * @return Siempre devuelve false.
     */
    fun mostrarMensaje(): Boolean {
        println("¡Felicidades, has derrotado al villano final y has salvado el mundo!")
        println("El destino del mundo estaba en tus manos, y gracias a tu valentía y determinación, has prevalecido.")
        println("Tu nombre será recordado por generaciones como el héroe que luchó contra la oscuridad y emergió victorioso.")
        println("Akira Toriyama, estaría orgulloso de ti por tu coraje y tu espíritu indomable.")
        println("¡Has demostrado que los límites solo existen en la mente, y que el verdadero poder reside en el corazón!")
        return false
    }
}



