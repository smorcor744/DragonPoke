package org.example


fun limpiarConsola() {
    repeat(100) {
        println()
    }
}



fun main() {
    Inicio().mostrarMapa()
    println("Ingresa tu nombre: ")
    val nombre = readln()

    println("Selecciona tu género (MASCULINO, FEMENINO, NO_BINARIO, AH_64_APACHE): ")
    val genero = Generos.valueOf(readln().uppercase())

    println("Selecciona la dificultad (EXTREMO, DIFICIL, NORMAL, PUSSY): ")
    val dificultad =Dificultad.valueOf(readln().uppercase())

    val gottens = Gottens(genero, nombre,dificultad)
    val villano = Villanos(Razas.NAMEKIANO, "perro",Generos.MASCULINO,dificultad)

    println("¡Bievenido ${gottens.nombre}!")
    println("Estadísticas iniciales: ${gottens.estadisticas}")
    readln()
    val movimiento = Movimiento()

    while (true) {
        movimiento.mover(gottens,villano,dificultad)

    }


}





