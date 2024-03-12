package org.example

import kotlin.random.Random

class Peleas(private val gottens: Gottens, private val villanos: Villanos, private val dificultad: Dificultad) {
    private var danio = 0.0
    private var turno = turno(dificultad)


    fun pelear() {
        while (gottens.estadisticas.salud > 0 && villanos.estadisticas.salud > 0) {

            Pelea(gottens,villanos).mostrarMapa()
            iniciarPelea(gottens, villanos )
            println("Estado actual de la pelea:")
            println("Vida de Gottens: ${gottens.estadisticas.salud}")
            println("Vida del villano: ${villanos.estadisticas.salud}")
        }

        if (gottens.estadisticas.salud <= 0) {
            println("¡Has perdido la pelea!")
            Movimiento().mover(gottens, villanos, dificultad)
        } else {
            println("¡Has ganado la pelea!")
            gottens.estadisticas.nivel += 10
            println("Estado actual: ${ gottens.estadisticas }")

        }
    }



    private fun turno(dificultad: Dificultad): Int {
        if (dificultad == Dificultad.EXTREMO){
            println("Empieza el villano")
            return 2

        } else {
            println("Empiezas")
            return 1

        }
    }

    private fun iniciarPelea(gottens: Gottens, villanos: Villanos){
        if (turno == 1) {
            turno++

            println("Elige un ataque:")
            println("1. BOLAS")
            println("2. KAMEKAMEHA")
            println("3. KAIOKEN")
            println("4. GOLPES")

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
            when (ataqueElegido){
                TipoAtaques.BOLAS -> bolas(gottens.estadisticas)
                TipoAtaques.KAMEKAMEHA -> kamekameha(gottens.estadisticas)
                TipoAtaques.KAIOKEN-> kaioKen(gottens.estadisticas)
                TipoAtaques.GOLPES -> golpes(gottens.estadisticas)
                else -> println("A fallado")
            }
            villanos.estadisticas.salud -= danio

        } else {
            turno--
            val ataqueAleatorio = TipoAtaques.entries.toTypedArray().random()
            ataquesVillano(villanos,ataqueAleatorio)
            gottens.estadisticas.salud -= danio
            readln()

        }


    }


    private fun ataquesVillano(villanos: Villanos, ataque: TipoAtaques){
        when (villanos.raza){
            Razas.SAIYAN -> ataqueSaiyan(villanos.estadisticas,ataque)
            Razas.TERRICOLA -> ataqueTerricola(villanos.estadisticas,ataque)
            Razas.NAMEKIANO -> ataqueNamekiano(villanos.estadisticas,ataque)
            Razas.FREEZER -> ataqueFreezer(villanos.estadisticas,ataque)
            Razas.BOSS -> ataqueBoss(villanos.estadisticas,ataque)
        }
    }


    private fun ataqueBoss(estadisticas: Estadisticas,ataque:TipoAtaques){
        println("El villano Saiyan va realizar un ataque")
        when (ataque){
            TipoAtaques.CASTIGODIVINO -> castigoDivino(estadisticas)
            TipoAtaques.KAMEKAMEHA -> kamekameha(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> println("A fallado")
        }
    }

    private fun ataqueSaiyan(estadisticas: Estadisticas,ataque:TipoAtaques){
        println("El villano Saiyan va realizar un ataque")
        when (ataque){
            TipoAtaques.BOLAS -> bolas(estadisticas)
            TipoAtaques.KAMEKAMEHA -> kamekameha(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> println("A fallado")
        }
    }


    private fun ataqueTerricola(estadisticas: Estadisticas,ataque:TipoAtaques){
        println("El villano Terricola va realizar un ataque")
        when (ataque){
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> println("A fallado")
        }
    }


    private fun ataqueNamekiano(estadisticas: Estadisticas,ataque:TipoAtaques){
        println("El villano Namekiano va realizar un ataque")
        when (ataque){
            TipoAtaques.BOLAS -> bolas(estadisticas)
            TipoAtaques.MAKANKOSAPPO -> makankosappo(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> println("A fallado")
        }
    }


    private fun ataqueFreezer(estadisticas: Estadisticas,ataque:TipoAtaques){
        println("El villano Namekiano va realizar un ataque")
        when (ataque){
            TipoAtaques.BOLAS -> bolas(estadisticas)
            TipoAtaques.SUPERNOVA -> supernova(estadisticas)
            TipoAtaques.KAIOKEN -> kaioKen(estadisticas)
            TipoAtaques.GOLPES -> golpes(estadisticas)
            else -> println("A fallado")
        }
    }

    private fun puedeRealizarAtaque(estadisticas: Estadisticas, costoKi: Int, costoStamina: Int): Boolean {
        return estadisticas.ki >= costoKi || estadisticas.stamina >= costoStamina
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
enum class TipoAtaques{KAMEKAMEHA, BOLAS, KAIOKEN, GOLPES,MAKANKOSAPPO,SUPERNOVA,CASTIGODIVINO}
