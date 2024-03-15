package org.example.Combates

import org.example.Mapas.Pelea
import org.example.Estadisticas.Dificultad
import org.example.Estadisticas.Estadisticas
import org.example.Estadisticas.Razas
import org.example.Personajes.Gottens
import org.example.Personajes.Villano
import org.example.Consola

import kotlin.random.Random

/**
 * Clase que gestiona las peleas entre el personaje principal (Gottens) y los villanos.
 * @param gottens El personaje principal.
 * @param villano El villano contra el que lucha Gottens.
 * @param dificultad La dificultad de la pelea.
 */
class Peleas(private val gottens: Gottens, private val villano: Villano, dificultad: Dificultad) {
    private var danio = 0.0
    private var turno = turno(dificultad)

    /**
     * Función que realiza la pelea entre Gottens y el villano.
     * @return true si Gottens gana la pelea, false si pierde.
     */
    fun pelear(): Boolean {
        while (gottens.estadisticas.salud > 0 && villano.estadisticas.salud > 0) {
            Pelea(gottens, villano).mostrarMapa()
            iniciarPelea(gottens, villano)
            Consola().printer("Estado actual de la pelea:")
            Consola().printer("Vida de Gottens: ${gottens.estadisticas.salud}")
            Consola().printer("Vida del villano: ${villano.estadisticas.salud}")
            readln()
        }

        if (gottens.estadisticas.salud <= 0) {
            Consola().printer("¡Has perdido la pelea!")
            return false
        } else {
            Consola().printer("¡Has ganado la pelea!")
            gottens.estadisticas.nivel += 10
            Consola().printer("Estado actual: ${gottens.estadisticas}")
            return true
        }
    }

    /**
     * Función que determina el turno de inicio de la pelea según la dificultad.
     * @param dificultad La dificultad de la pelea.
     * @return El número que representa el turno (1 para Gottens, 2 para el villano).
     */
    private fun turno(dificultad: Dificultad): Int {
        return if (dificultad == Dificultad.EXTREMO) {
            Consola().printer("Empieza el villano")
            2
        } else {
            Consola().printer("Empiezas")
            1
        }
    }

    /**
     * Función que inicia una ronda de pelea entre Gottens y el villano.
     * @param gottens El personaje principal.
     * @param villanos El villano contra el que lucha Gottens.
     */
    private fun iniciarPelea(gottens: Gottens, villanos: Villano) {
        if (turno == 1) {
            turno++
            println("Elige un ataque:\n1. BOLAS\n2. KAMEKAMEHA\n3. KAIOKEN\n4. GOLPES")
            var ataqueElegido: TipoAtaques? = null
            while (ataqueElegido == null) {
                val opcion = readln()
                ataqueElegido = when (opcion) {
                    "1" -> TipoAtaques.BOLAS
                    "2" -> TipoAtaques.KAMEKAMEHA
                    "3" -> TipoAtaques.KAIOKEN
                    "4" -> TipoAtaques.GOLPES
                    else -> {
                        println("Opción no válida. Por favor, elige nuevamente poniendo el número del ataque deseado.")
                        null
                    }
                }
            }
            when (ataqueElegido) {
                TipoAtaques.BOLAS -> bolas(gottens.estadisticas)
                TipoAtaques.KAMEKAMEHA -> kamekameha(gottens.estadisticas)
                TipoAtaques.KAIOKEN -> kaioKen(gottens.estadisticas)
                TipoAtaques.GOLPES -> golpes(gottens.estadisticas)
                else -> println("A fallado")
            }
            villanos.estadisticas.salud -= danio
        } else {
            turno--
            val ataqueAleatorio = TipoAtaques.entries.toTypedArray().random()
            ataquesVillano(villanos, ataqueAleatorio)
            gottens.estadisticas.salud -= danio
            readln()
        }
    }

    /**
     * Función que realiza un ataque por parte del villano.
     * @param villanos El villano que realiza el ataque.
     * @param ataque El tipo de ataque realizado.
     */
    private fun ataquesVillano(villanos: Villano, ataque: TipoAtaques) {
        when (villanos.raza) {
            Razas.SAIYAN -> ataqueSaiyan(villanos.estadisticas, ataque)
            Razas.TERRICOLA -> ataqueTerricola(villanos.estadisticas, ataque)
            Razas.NAMEKIANO -> ataqueNamekiano(villanos.estadisticas, ataque)
            Razas.FREEZER -> ataqueFreezer(villanos.estadisticas, ataque)
            Razas.BOSS -> ataqueBoss(villanos.estadisticas, ataque)
        }
    }

    private fun ataqueBoss(estadisticas: Estadisticas, ataque: TipoAtaques){
        Consola().printer("El villano Saiyan va realizar un ataque")
        when (ataque){
            TipoAtaques.CASTIGODIVINO -> castigoDivino(estadisticas)
            TipoAtaques.KAMEKAMEHA -> kamekameha(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> Consola().printer("A fallado")
        }
    }

    private fun ataqueSaiyan(estadisticas: Estadisticas, ataque: TipoAtaques){
        Consola().printer("El villano Saiyan va realizar un ataque")
        when (ataque){
            TipoAtaques.BOLAS -> bolas(estadisticas)
            TipoAtaques.KAMEKAMEHA -> kamekameha(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> Consola().printer("A fallado")
        }
    }


    private fun ataqueTerricola(estadisticas: Estadisticas, ataque: TipoAtaques){
        Consola().printer("El villano Terricola va realizar un ataque")
        when (ataque){
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> Consola().printer("A fallado")
        }
    }


    private fun ataqueNamekiano(estadisticas: Estadisticas, ataque: TipoAtaques){
        Consola().printer("El villano Namekiano va realizar un ataque")
        when (ataque){
            TipoAtaques.BOLAS -> bolas(estadisticas)
            TipoAtaques.MAKANKOSAPPO -> makankosappo(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> Consola().printer("A fallado")
        }
    }


    private fun ataqueFreezer(estadisticas: Estadisticas, ataque: TipoAtaques){
        Consola().printer("El villano Namekiano va realizar un ataque")
        when (ataque){
            TipoAtaques.BOLAS -> bolas(estadisticas)
            TipoAtaques.SUPERNOVA -> supernova(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> Consola().printer("A fallado")
        }
    }

    private fun puedeRealizarAtaque(estadisticas: Estadisticas, costoKi: Int, costoStamina: Int): Boolean {
        return estadisticas.ki >= costoKi && estadisticas.stamina >= costoStamina
    }

    private fun recargarEstadisticas(estadisticas: Estadisticas) {
        estadisticas.ki += (estadisticas.nivelKi * 0.5).toInt()
        estadisticas.stamina += (estadisticas.nivelStamina * 0.5).toInt()
        if (estadisticas.nivelKi < estadisticas.ki) estadisticas.ki = estadisticas.nivelKi
        else if (estadisticas.nivelStamina < estadisticas.stamina) estadisticas.stamina = estadisticas.nivelStamina
    }


    private fun castigoDivino(estadisticas: Estadisticas){
        if (puedeRealizarAtaque(estadisticas,40,8)){
            danio = estadisticas.nivelKi * (12 * critico())
            estadisticas.ki -= 40
        }else recargarEstadisticas(estadisticas)

    }


    private fun supernova(estadisticas: Estadisticas){
        if (puedeRealizarAtaque(estadisticas,30,5)){
            danio = estadisticas.nivelKi * (7 * critico())
            estadisticas.ki -= 30
        }else recargarEstadisticas(estadisticas)
    }

    private fun makankosappo(estadisticas: Estadisticas){
        if (puedeRealizarAtaque(estadisticas,15,3)){
            danio = estadisticas.nivelKi * (3 * critico())
            estadisticas.ki -= 15
        }else recargarEstadisticas(estadisticas)
    }

    private fun kamekameha(estadisticas: Estadisticas){
        if (puedeRealizarAtaque(estadisticas,10,2)){
            danio = estadisticas.nivelKi * (2*critico())
            estadisticas.ki -= 10
        }else recargarEstadisticas(estadisticas)
    }
    private fun golpes(estadisticas: Estadisticas){
        if (puedeRealizarAtaque(estadisticas, 0, 10)) {
            danio = (estadisticas.fuerza + (estadisticas.velocidad*1/2))*critico()
            estadisticas.stamina -= 10
        }else recargarEstadisticas(estadisticas)
    }


    private fun bolas(estadisticas: Estadisticas){

        if (puedeRealizarAtaque(estadisticas, 5, 1)) {
            danio = estadisticas.nivelKi * critico()
            estadisticas.ki -= 5
        }else recargarEstadisticas(estadisticas)
    }

    private fun kaioKen(estadisticas: Estadisticas){
        if (puedeRealizarAtaque(estadisticas, 5, 1)) {
            estadisticas.fuerza *=2* critico()
            estadisticas.velocidad *=2
            estadisticas.ki -= 5
        }else recargarEstadisticas(estadisticas)

    }


    private fun critico():Int{
        val aleatorio = Random.nextInt(1,100)
        return if (aleatorio >70){
            4
        }else 1
    }
}
