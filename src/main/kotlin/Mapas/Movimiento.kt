package org.example.Mapas

import org.example.Combates.Peleas
import org.example.Entrenamiento.*
import org.example.Estadisticas.Dificultad
import org.example.Personajes.Gottens
import org.example.Personajes.Villano
import org.example.limpiarConsola

class Movimiento {
    private var filaActual = 2
    private var columnaActual = 6
    private var nuevaColumna = 0
    private var nuevaFila = 0
    companion object{
        var mapaTemporal: Mapa = Casa()

    }
    private fun moverACasa(gottens: Gottens) {
        mapaTemporal = Casa()
        gottens.estadisticas.salud = gottens.estadisticas.saludMaxima
        nuevaFila = 6
        nuevaColumna = 1
        mapaTemporal.mapa[2][6] = " "
    }

    private fun moverAGym() {
        mapaTemporal = Gym()
        nuevaFila = 7
        nuevaColumna = 1
        columnaActual = nuevaColumna
    }

    private fun moverAPueblo() {
        mapaTemporal = Pueblo()
        nuevaFila = 7
        nuevaColumna = 27
        columnaActual = nuevaColumna
        mapaTemporal.mapa[7][36] = " "
    }



    private fun teleport(direccion: String,gottens: Gottens) {
        when (direccion) {
            "ñ" -> {
                println("Selecciona tu destino:")
                println("1. Pueblo")
                println("2. Casa")
                println("3. Gym")

                val opcion = readln()

                when (opcion) {
                    "1" -> {
                        when (mapaTemporal) {
                            is Casa -> {
                                println("Teletransportando al Pueblo...")
                                moverAPueblo()

                            }
                            is Pueblo -> {
                                println("Ya estás en el pueblo.")
                                return
                            }
                            is Gym -> {
                                println("Teletransportando al Pueblo...")
                                moverAPueblo()
                            }
                        }
                        println("¡Teletransportación al Pueblo exitosa!")
                    }
                    "2" -> {
                        when (mapaTemporal) {
                            is Pueblo -> {
                                println("Teletransportando a la Casa...")
                                moverACasa(gottens)
                            }
                            is Casa -> {
                                println("Ya estás en la casa.")
                                return
                            }
                        }
                        println("¡Teletransportación a la Casa exitosa!")
                    }
                    "3" -> {
                        when (mapaTemporal) {
                            is Pueblo -> {
                                println("Teletransportando al Gym...")
                                moverAGym()
                            }
                            is Gym -> {
                                println("Ya estás en el Gym.")
                                return
                            }
                        }
                        println("¡Teletransportación al Gym exitosa!")
                    }
                    else -> {
                        println("Dirección de teletransporte no válida(1,2,3).")

                    }
                }
            }
        }
    }


    fun mover(gottens: Gottens, villanos: MutableMap<Pair<Int,Int>,Villano>, dificultad: Dificultad) {

        mapaTemporal.mostrarMapa()
        print("Movimiento(w,a,s,d): ")
        val direccion = readln().lowercase()
        teleport(direccion,gottens)

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
            if (esCeldaEntrenamiento(mapaTemporal.mapa[nuevaFila][nuevaColumna])) {
                tipoEntrenamiento(mapaTemporal.mapa[nuevaFila][nuevaColumna])
                println(gottens.estadisticas)
            } else {
                cambioMapa(nuevaFila, nuevaColumna, mapaTemporal,gottens,villanos, dificultad )
                mapaTemporal.moverPersonaje(filaActual, columnaActual, nuevaFila, nuevaColumna)
                filaActual = nuevaFila
                columnaActual = nuevaColumna
            }
        } else {
            println("¡Movimiento no válido!")
        }
    }


    private fun cambioMapa(
        fila: Int,
        columna: Int,
        mapa: Mapa,
        gottens: Gottens,
        villanos: MutableMap<Pair<Int, Int>, Villano>,
        dificultad: Dificultad
    ) {
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
                moverACasa(gottens)

            } else if (fila == 6 && (columna == 27 || columna == 28)) {
                limpiarConsola()
                println("Gym")
                println("Aquí podrás entrenar tus estadísticas como el ki, la fuerza, la velocidad y la resistencia en las diferentes estaciones....")
                moverAGym()

            } else if (columna == 20 && (fila == 9 || fila == 7 || fila == 8)) {
                limpiarConsola()
                println("Estás entrando en la zona de combates, intenta matar a todos para poder llegar hasta el jefe final y coronarte como el ¡¡SALVADOR DEL MUNDO!!")

            } else if (villanos[fila to columna] != null) {
                val villano: Villano? = villanos[fila to columna]
                if (villano != null) {
                    limpiarConsola()
                    println("Has entrado en un combate")
                    mapaTemporal = Pelea(gottens, villano)
                    Peleas(gottens, villano, dificultad).pelear()
                    if (gottens.estadisticas.salud > 0) {
                        villanos.remove(villano.posicion)
                        mapaTemporal = Pueblo()
                        nuevaFila = fila
                        nuevaColumna = columna
                        columnaActual = nuevaColumna
                        Pueblo().eliminarVillano(fila, columna)
                    } else {
                        moverACasa(gottens)
                    }
                }
            }
            is Gym -> if ((fila == 6 || fila == 7) && columna == 0) {
                limpiarConsola()
                println("Atlas")
                moverAPueblo()

            }
        }
    }

    private fun esCeldaEntrenamiento(celda: String): Boolean {
        return celda == "K" || celda == "F" || celda == "R" || celda == "V"
    }

    private fun tipoEntrenamiento(celda: String) {
        when (celda) {
            "K" -> Ki()
            "F" -> Fuerza()
            "R" -> Resistencia()
            "V" -> Velocidad()
        }
    }

    private fun esMovimientoValido(fila: Int, columna: Int, mapa: Mapa): Boolean {
        val celda = mapa.mapa[fila][columna]
        return celda != "#" && celda != "|" && celda != "-" && !esCeldaEntrenamiento(celda)
    }


    private fun entrenar(fila: Int, columna: Int, mapa: Mapa): Boolean {
        return mapa.mapa[fila][columna] == "K" || mapa.mapa[fila][columna] == "F" || mapa.mapa[fila][columna] == "R" || mapa.mapa[fila][columna] == "V"

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