package org.example.Mapas

open class Mapa {
    open var mapa: MutableList<MutableList<String>> = mutableListOf()
    open var pelea: String = ""
    fun moverPersonaje(filaActual: Int, columnaActual: Int, nuevaFila: Int, nuevaColumna: Int) {
        mapa[filaActual][columnaActual] = " "
        mapa[nuevaFila][nuevaColumna] = "@"
    }


    open fun mostrarMapa() {
        for (fila in mapa) {
            for (celda in fila) {
                print("$celda ")
            }
            println()
        }
    }
}