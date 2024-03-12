package org.example

class Movimiento {
    private var filaActual = 2
    private var columnaActual = 6
    var mapaTemporal: Mapa = Casa()
    private var nuevaColumna = 0
    private var nuevaFila = 0
    fun mover(gottens: Gottens,villanos: Villanos,dificultad: Dificultad) {

        mapaTemporal.mostrarMapa()
        print("Movimiento(w,a,s,d): ")
        val direccion = readln().lowercase()

        nuevaFila = when (direccion) {
            "w" -> filaActual - 1
            "s" -> filaActual + 1
            else -> filaActual
        }

        nuevaColumna = when (direccion) {
            "a" -> columnaActual - 1
            "d" -> columnaActual + 1
            else -> columnaActual
        }

        if (esMovimientoValido(nuevaFila, nuevaColumna, mapaTemporal)) {
            if (!entrenar(nuevaFila, nuevaColumna, mapaTemporal) ) {
                cambioMapa(nuevaFila, nuevaColumna, mapaTemporal,gottens,villanos, dificultad )
                mapaTemporal.moverPersonaje(filaActual, columnaActual, nuevaFila, nuevaColumna)
                filaActual = nuevaFila
                columnaActual = nuevaColumna

            }else {
                tipoEntrenamiento(nuevaFila, nuevaColumna, mapaTemporal)
                when (mapaTemporal.mapa[nuevaFila][nuevaColumna]){
                    "K" -> Ki()
                    "F" -> Fuerza()
                    "R" -> Resistencia()
                    "V" -> Velocidad()

                }
                print(gottens.estadisticas)
            }
        } else {
            println("¡Movimiento no válido!")
        }
    }

    private fun cambioMapa(fila: Int, columna: Int, mapa: Mapa, gottens: Gottens, villanos: Villanos, dificultad: Dificultad) {
        when (mapa) {
            is Casa -> if ((fila == 6 || fila == 7) && columna == 0) {
                limpiarConsola()

                println("Atlas")
                mapaTemporal = Pueblo()
                nuevaFila = 7
                nuevaColumna = 36
            }
            is Pueblo -> if (fila == 6 && (columna == 37 || columna == 36)) {
                limpiarConsola()
                println("Casa")
                mapaTemporal = Casa()
                nuevaFila = 6
                nuevaColumna = 1
                columnaActual = nuevaColumna
                mapaTemporal.mapa[2][6] = " "

            }else
                if (fila == 6 && (columna == 27 || columna == 28)){
                    limpiarConsola()
                    println("Gym")
                    println("Aquí podrás entrenar tus estadísticas como el ki, la fuerza, la velocidad y la resistencia en las diferentes estaciones....")
                    mapaTemporal = Gym()
                    nuevaFila = 6
                    nuevaColumna = 1
                    columnaActual = nuevaColumna
                }else
                    if (pelea(fila, columna, mapa)){
                        limpiarConsola()
                        println("Has entrado en un combate")
                        mapaTemporal = Pelea(gottens,villanos)
                        Peleas(gottens,villanos, dificultad).pelear()
                        mapaTemporal = Pueblo()
                        nuevaFila = 19
                        nuevaColumna = 13
                        columnaActual = nuevaColumna

                    } else
                        if (columna == 20 && (fila == 9 || fila == 7|| fila == 8)){
                            limpiarConsola()
                            println("Estas entrando en la zona de combates, intenta matar a todos para poder llegar asta el boss final y coronarte como el ¡¡SALVADOR DEL MUNDOOO!!")
                        }
            is Gym -> if ((fila == 6 || fila == 7) && columna == 0) {
                limpiarConsola()
                println("Gym")
                println("Aquí podrás entrenar tus estadísticas como el ki, la fuerza, la velocidad y la resistencia en las diferentes estaciones....")
                mapaTemporal = Pueblo()
                nuevaFila = 7
                nuevaColumna = 27
                columnaActual = nuevaColumna
                mapaTemporal.mapa[7][36] = " "

            }

        }
    }


    private fun pelea(fila: Int, columna: Int, mapa: Mapa):Boolean{
        return when (mapa.mapa[fila][columna]){
            "%" -> true
            else -> false
        }
    }

    private fun esMovimientoValido(fila: Int, columna: Int, mapa: Mapa): Boolean {
        return mapa.mapa[fila][columna] != "#" && mapa.mapa[fila][columna] != "|" && mapa.mapa[fila][columna] != "-" && !entrenar(fila,columna,mapa)
    }
    private fun entrenar(fila: Int, columna: Int, mapa: Mapa): Boolean {
        return mapa.mapa[fila][columna] == "K" && mapa.mapa[fila][columna] == "F" && mapa.mapa[fila][columna] == "R" && mapa.mapa[fila][columna] == "V"

    }

    private fun tipoEntrenamiento(fila: Int, columna: Int, mapa: Mapa){
        when (mapa.mapa[fila][columna]){
            "K" -> Ki()
            "F" -> Fuerza()
            "V" -> Velocidad()
            "R" -> Resistencia()
        }
    }
}