package org.example

// Declaramos la clase Consola como genérica, con un parámetro de tipo T
class Consola<T> {
    // Método para imprimir un mensaje de tipo T
    fun printer(mensaje: T) {
        println(mensaje)
    }
}
