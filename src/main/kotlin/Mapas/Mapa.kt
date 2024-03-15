package org.example.Mapas

/**
 * Clase base que representa un mapa en el juego.
 */
open class Mapa {
    /**
     * Representa el contenido del mapa como una matriz de cadenas.
     */
    open var mapa: MutableList<MutableList<String>> = mutableListOf()

    /**
     * Representa el diseño de la pelea en el mapa.
     */
    open var pelea: String = ""

    /**
     * Mueve el personaje en el mapa desde una posición actual a una nueva posición.
     * @param filaActual La fila actual del personaje.
     * @param columnaActual La columna actual del personaje.
     * @param nuevaFila La nueva fila a la que se moverá el personaje.
     * @param nuevaColumna La nueva columna a la que se moverá el personaje.
     */
    fun moverPersonaje(filaActual: Int, columnaActual: Int, nuevaFila: Int, nuevaColumna: Int) {
        mapa[filaActual][columnaActual] = " "
        mapa[nuevaFila][nuevaColumna] = "@"
    }

    /**
     * Muestra el mapa en la consola.
     */
    open fun mostrarMapa() {
        for (fila in mapa) {
            for (celda in fila) {
                print("$celda ")
            }
            println()
        }
    }
}
