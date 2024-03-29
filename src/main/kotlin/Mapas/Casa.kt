package org.example.Mapas
/**
 * Clase que representa tu casa en el mapa.
 */
class Casa : Mapa() {
    override var mapa: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"),
        mutableListOf("#", " ", " ", " ", "#", " ", " ", " ", " ", "#", " ", " ", " ", "#"),
        mutableListOf("#", " ", "#", " ", "#", " ", "@", " ", " ", "#", " ", " ", " ", "#"),
        mutableListOf("#", " ", "#", " ", "#", " ", " ", " ", " ", "#", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", "#", " ", " ", " ", " ", "#", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", "#", "#", "#", "#", "_", "#", "_", "#", "#", "#"),
        mutableListOf("_", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("_", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", "#", "#", "#", "_", "#", "#", "#", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", "#", "#", "#", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", "#", "#", "#", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#")
    )
}