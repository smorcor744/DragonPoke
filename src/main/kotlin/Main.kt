package org.example


data class Estadisticas(var salud: Double, var ki: Double, var stamina: Double, var velocidad: Double, var nivel: Double, var fuerza: Double,var nivelKi:Double,var nivelStamina : Double)


enum class Generos { MASCULINO, FEMENINO, NO_BINARIO, AH_64_APACHE}


enum class Dificultad { EXTREMO, DIFICIL, NORMAL, PUSSY }


interface Entrenador  {
    fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes){
        estadisticas.nivel += porcentaje.porcentajeUsuario(dificultad)

    }
}

class Ki : Entrenador  {
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.ki += estadisticas.ki * porcentaje.porcentajeUsuario(dificultad)
    }
}

class Fuerza : Entrenador  {
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.fuerza += estadisticas.fuerza * porcentaje.porcentajeUsuario(dificultad)

    }
}

class Velocidad : Entrenador  {
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.velocidad += estadisticas.velocidad * porcentaje.porcentajeUsuario(dificultad)

    }
}

class Resistencia : Entrenador{
    override fun entrenar(estadisticas: Estadisticas, dificultad: Dificultad, porcentaje: Porcentajes) {
        estadisticas.stamina += estadisticas.stamina * porcentaje.porcentajeUsuario(dificultad)

    }
}



class Porcentajes {

    fun porcentajeUsuario(dificultad: Dificultad): Double {
        return when (dificultad) {
            Dificultad.EXTREMO -> 0.2
            Dificultad.DIFICIL -> 0.4
            Dificultad.NORMAL -> 0.6
            Dificultad.PUSSY -> 0.8
        }
    }




    fun porcentajeNpc(dificultad: Dificultad): Double {
        return when (dificultad) {
            Dificultad.EXTREMO -> 0.8
            Dificultad.DIFICIL -> 0.6
            Dificultad.NORMAL -> 0.4
            Dificultad.PUSSY -> 0.2
        }
    }
}


enum class Razas { SAIYAN, TERRICOLA, NAMEKIANO, FREEZER, BOSS }


open class EstadisticasSegunGenero {
    companion object {
        var nivelstamina: Double = 10.0
        var salud: Double = 100.0
        var nivelKi = 10.0
        var velocidad: Double = 10.0
        var nivel: Double = 1.0
        var fuerza: Double = 10.0
        var fuerzaFemina = 8.0
        var velocidadFemina = 12.0
        var fuerzaApache = 20.0
        var velocidadApache = 5.0
        var ki: Double = nivelKi
        var stamina = nivelstamina
    }




    open fun estadisticasIniciales(genero: Generos,dificultad: Dificultad): Estadisticas {
        return when (genero) {
            Generos.MASCULINO, Generos.NO_BINARIO -> Estadisticas(salud * nivel, ki * nivel, stamina * nivel, velocidad * nivel, nivel, fuerza * nivel, nivelKi * nivel,
                nivelstamina * nivel)
            Generos.FEMENINO -> Estadisticas(salud * nivel, ki * nivel, stamina * nivel, velocidadFemina * nivel, nivel, fuerzaFemina * nivel, nivelKi * nivel,
                nivelstamina * nivel)
            Generos.AH_64_APACHE -> Estadisticas(salud * nivel, ki * nivel, stamina * nivel, velocidadApache * nivel, nivel , fuerzaApache * nivel, nivelKi * nivel,
                nivelstamina * nivel)
        }
    }
}


class Gottens(genero: Generos, val nombre: String, dificultad: Dificultad):EstadisticasSegunGenero(){
    var estadisticas = estadisticasIniciales(genero, dificultad)
}


class Villanos(var raza: Razas,var nombre: String,genero: Generos,dificultad: Dificultad):EstadisticasSegunGenero(){
    var estadisticas = estadisticasIniciales(genero, dificultad)
    override fun estadisticasIniciales(genero: Generos,dificultad: Dificultad): Estadisticas {
        estadisticas = when (dificultad){
            Dificultad.EXTREMO -> Estadisticas(salud*3, ki*3, stamina*3, velocidad*3, nivel, fuerza*3, ki,
                stamina)
            Dificultad.DIFICIL -> Estadisticas(salud*2, ki*2, stamina*2, velocidad*2, nivel, fuerza*2,ki,
                stamina)
            Dificultad.NORMAL -> Estadisticas(salud, ki, stamina, velocidad, nivel, fuerza, ki,
                stamina)
            Dificultad.PUSSY -> Estadisticas(salud*1/2, ki*1/2, stamina*1/2, velocidad*1/2, nivel, fuerza*1/2, ki,
                stamina)
        }
        return estadisticas
    }
}


class Inicio : Mapa() {
    override fun mostrarMapa() {
        println(pelea)
        readln()
        limpiarConsola()
    }

    override var pelea=
        "***************##*******************************#%@%#*##*****************######*####################\n" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@%%\n" +
                "####################################################################################################\n" +
                "#*=+#############*#######****************#*++**#*#**#*###########***################**=+#########*==\n" +
                " **+-+************************+++=--::--=**+-=-*****-=******************************+::=*********+:-+\n" +
                "=**+=***********************---=+*=::==--::+*+=+***==+****************************-.::=********+-+**\n" +
                ":=**=+***********************+----=+*+:-=----:==#+**-++++********************++-==:::-+*******+-+*+*\n" +
                ":-+**=*********++*++++++++++++*---=-+*=-#*+=----:+#*-=+++++++++++++++***+++++-...:::::+******+:+++**\n" +
                "::-++*+++***+++++++++=++++++++++=--=*#+-##**#*=---++-++++++++++++++++=**+++=....::::-+*****++=*+++**\n" +
                ":::-+++++++++++++++++=::==+++++++=--=#*=*%#####=--:*==+*+++++++++---*#+++++:..:::--=+++++*++=++++*++\n" +
                "::::::=+++++++++++++++=-:.-++++++++--=#=+%##%%##=---==--:=++++=:--+##++++++=..::=++++++++++++++++==-\n" +
                ":::::.:-+++++++++++++++++=-=++++*====+**=#%%#%##*----------*=---=##*+++*++:.::-++++++++++++++-.:::::\n" +
                ":::=+=====--=+++++++++++++++=++:------==:----==---==----------=+#%++*++++=.:=++++++++++++++=..--:--=\n" +
                "==*++==========++++++++++++=--------=------==-------===-----*####++**+++=-+++++++++++++++=:.:=#==+==\n" +
                "++**+*#######**+=+++++++++--==+***+=:-----*:----*%%#=+=---=--:::-*-+*##=++++++++++++++++=:=++#-+=-=*\n" +
                "###+===++=--+++++++++++++**##%%%%##--=+##*:---*%%%###%#+-==--=*####*+==--==++++++++++++=++=++++=+#%%\n" +
                "###=+====-:.:=++++++++++++++++++--=+#%***=--=#%#:....=%+=+#=-==:------=+####%*+++++++++++=+-*+=#%%%%\n" +
                "###*++=====-:.-=========++=+*++++###%#--*+-=##+-....:-#++%%+=*+=+*#%%%##*+=++++++++++++==++#++#%%*--\n" +
                "####+++=======--=============+++*####%=*%%=+%#::+..*::#*%%*+#%%%%%##++===============+=-=#**=*#%%:-=\n" +
                "##*####+======-=====================+*#*##+*==*+::::=**-*###+%%#=++=====================%%+:+##%%=-=\n" +
                "#**#####+#*====-======================+***#:+=++-::-++=+=#**#***###**+==============-===#*-:-*##%*+#\n" +
                "#*+*######*====-==================+*****###+.....=+....-*##*+=========================*%%*-:-*##%%#+\n" +
                " *+==######=*========--=======================-...--...=+=========================--==**##%+-=**##%*+\n" +
                " *+==#####*=*+======-:.:-=====================*##-::-##*========================:.:--+##%%*==-=+*##*%\n" +
                "+===*####+--+===----:..:-=============+=-+#+**+*####++**+%+-=+==-===========--:..:-**=+##*--:-:+*##%\n" +
                "--==+###*---===-----::.:--====-=+=:..++=*+*-::-+=**-+-::=#+*=+-...=+=-=------..::--==++==--:-+:-###%\n" +
                "-====*#*------..------::-----=*:-.-=-*=-+=#=:....--....:=%=+==+=-:.::*-----::-------==-----=+=:=*##%\n" +
                "======*-:::::....-::----:---==+%==========%%#%*=+**++#%%@#==========%*-=:----------==-------*-:+*##%\n" +
                " *+=------::::::......------++##%#===*=====+%%%%%##%%%%%%%======*===#%##+*=------------:::-:=-:+*####\n" +
                " ***======----:::::...::::--=%##%%#*##======+%%%%@@%%%%%%+====++##+#%%##%----.....:==::::::-::+*#####\n" +
                " *+++-+==+--=--::::::......:-==*##%%#%*====+=+%@%%%#%%@%+=+===*#%#%%###+=---.........::::-::=*####*++\n" +
                "#*++==+===-=--::-==---:....:-:...-*%#*========#%%%%%%*=+*+***#%%%*-:..::::.....:----::--=+*###++*++*\n" +
                "##*++=+++==-==--=====-::..-::...:=%%@*==+*+==+=*@@@%+=%=+*%*+##@@%=:...-:-....:-=======*+#%#+++*++**\n" +
                " *##*+++++======-=--:---::=.-+--=+-:-*##++######*+#*+**#-%@*@=*#*::-+=--+::-.::::-=+*##*=+++=++**+***\n" +
                "=--**++**=+++==-::=:::::-:......--:-#####*+--==*####*+==:##%%%##-.--......:-:::-++*+--=====+=---=--=\n" +
                "===*****+++*++=----:::::==-+:...:*##***%#:-+#**#######%#+--#%*+**#*:...:+-==::--::----=--==+==-=+=++\n" +
                "=-+#**+*+++++==++=-=-:::=****+-:=%###%%-.-::+#####%###%*::-.-%%###%=.-+****=:--:---:-==-+=+=+=-=--==\n" +
                "+=###****+++++==+--=-::::::=++**#@%%%@#:.:*##+++#:=#++###+:.:#@%%%@#**++=:::--=======-==+===*+-=-===\n" +
                "=+####****+*+=+=+==-=:::::::::::-%%%%%@##%#**+.......=***####@%%%%%-::::::-------------==++**+---==*\n" +
                "=-======---------=====:::--:::::::...:+%@%%%%#*+=-=+**#@%%@@%=:...::::::::--=--++=-++==++**+=---=+*#\n" +
                "===##*****+=**+++--====-=-----::::...*#%###%@@@%@%%@@@@%%###%*+....:::---====--++-=*=-++==--=-==+*#*\n" +
                "=+=*#*****+=+**++=--+=+=======--::::-**+*##%%@@#%%%@%@%%###*+#+-::::.---=======+==**-=+==--=====+#**\n" +
                "+++=###****+=***+==-==+=========--::=*===+%%%@%##%%##%%%%*+===+=:---:=-=---===++++*+=+++--=====+****\n" +
                "=+==-=+**#**==***++=-+==-========-+:+====*###%*===++=+##%#*====+.+=--======+=+++***++*+=-=+=+++*#+=+\n" +
                "=+*+=--==*#**+=*#**+=++++=====-==+::*******+*+===+**++**##**++==--===---==++=++**#*+**=-=====++=+=+=\n" +
                " *+**+====+#**++*#***++=======----+-=*=:--=*##+=+*##%%%#%*::+**===-*==-======+++******+-==++++====+=+\n" +
                "#***#*++++**+-=********+*+===-----===**++=-=++=+==%%%%%#*=-=+*+==-=========+****=====--=+++=====*+++\n" +
                "++**###+==***=-+*#***++=++=++==+.:====**=+#=+#*+++%%%%%#+-=+*+====::+=+===+***#+-=+=--=+++====+*+++#\n" +
                "#*#*+=+*+==#**++******++=++++=-:.-====+#*#++#+***#++*********+====-.:-+++++****+==+====++=+=+##**###\n" +
                "####*+*+=++========----------=-.:=====+#+===+#%#*%%####*=#=========:--=----==---=========+++==+##**+\n" +
                "#*++===+++=======----------=-****==========*##%##**#####*+=========***+-=-------======---=+==+*++***\n" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Introduce cualquier tecla empezar... %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"

}


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


class Pueblo : Mapa() {
    init {
        val villano1 = Villanos(Razas.TERRICOLA, "Tenshinhan Bizco", Generos.MASCULINO, Dificultad.PUSSY)
        val villano2 = Villanos(Razas.TERRICOLA, "Krilling Corrupto", Generos.MASCULINO, Dificultad.NORMAL)
        val villano3 = Villanos(Razas.TERRICOLA, "Yamcha", Generos.MASCULINO, Dificultad.DIFICIL)
        val villano4 = Villanos(Razas.NAMEKIANO, "Piccolo Corrupto", Generos.MASCULINO, Dificultad.NORMAL)
        val villano5 = Villanos(Razas.NAMEKIANO, "Dende Tenebroso", Generos.MASCULINO, Dificultad.DIFICIL)
        val villano6 = Villanos(Razas.SAIYAN, "Broly Furioso", Generos.MASCULINO, Dificultad.NORMAL)
        val villano7 = Villanos(Razas.NAMEKIANO, "Black Frieza", Generos.MASCULINO, Dificultad.EXTREMO)
        val semiboss = Villanos(Razas.SAIYAN, "Majin Vegeta", Generos.MASCULINO, Dificultad.DIFICIL)
        val boss = Villanos(Razas.SAIYAN, "Goku Black", Generos.MASCULINO, Dificultad.EXTREMO)



    }
    override var mapa: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"),
        mutableListOf("#","#"," "," "," "," "," "," "," ","#"," ","%","#"," "," "," "," "," "," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#"," ","%"," "," "," "," "," ","%","#"," "," ","#"," "," "," "," "," "," "," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#","#","#","#","#"," ","#"," ","#","#"," ","#","#","#","#","#"," ","#"," "," "," "," ","|","#","#","#","#","|"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," "," "," ","#"," "," ","%","#"," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," "," "," ","#"," "," "," ","#"," ","#"," "," "," "," ","|","#","#","#","#","|"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," ","#","#","#"," "," "," ","#"," ","#"," "," "," "," ","#","#","_","_","#","#"," "," "," ","#","#","_","_","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#"," "," "," "," "," "," "," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@"," "," "," "," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#"," ","#","#","#","#","#","#","#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#","%"," "," "," "," "," ","%","#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#"," "," ","#"," "," "," ","#","#","#","#","#","#","#","#","#"," "," ","#"," ","#"," "," "," "," ","#","#","_","_","#","#"," "," "," ","#","#","_","_","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","%","#"," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," "," "," "," "," ","#","#","#","#","#","#","#","#","%","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#"," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"," "," "," "," ","#","#","#","#","#","#"," "," "," ","#","#","#","#","#","#"," ","#"),
        mutableListOf("#","%"," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","#"),
        mutableListOf("#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"))

}


class Gym : Mapa() {
    override var mapa: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("#", "#", "#", "-", "-", "#", "#", "#", "#", "#", "-", "-", "#", "#", "#"),
        mutableListOf("#", " ", " ", "K", "K", " ", " ", "#", " ", " ", "R", "R", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", "#", "#", " ", " ", "#", "#", "#", "#", "#", " ", " ", "#", "#", "#"),
        mutableListOf("_", "@", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("_", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", "#", "#", " ", " ", "#", "#", "#", "#", "#", " ", " ", "#", "#", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#"),
        mutableListOf("#", " ", " ", "F", "F", " ", " ", "#", " ", " ", "V", "V", " ", " ", "#"),
        mutableListOf("#", "#", "-", "-", "-", "-", "#", "#", "#", "-", "-", "-", "-", "#", "#")
    )
}


class Pelea(gottens: Gottens,villanos: Villanos) : Mapa() {
    override fun mostrarMapa() {
        println(pelea)
    }
    override var pelea = "" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "--------------------------------------------------------------------------------------------\n" +
            "--------------------------------------------------------------------------------------------\n" +
            "--------------------------------------------------------------------------------------------\n" +
            "--------------------------------------------------------------------------------------------\n" +
            "--------------------------------------------------------------------------------------------\n" +
            "---------------------------------------------------------------------+*+::-:@@@-::::::::::::@%#+*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@\n" +
            "--------------------------------------:::...................:::....-:##@%+=@@@::::::::::::::@= ${villanos.nombre}...................@\n" +
            "--------------------------------------.....:::::::::::::::::...::..=::*..:=#@@::.:::::::::::@:....................::::::::::::::.@\n" +
            "-------------------------------------:...:::::::::::::::::::...:::-%::.-.%=+@@%:::::::::::::@::::::::::::::::::..::::::::::::.:..@\n" +
            "--------------------------------------:::::....:::::::::::::::::::-*@=-+@#.=@@@.::::::::::::@:Salud:${villanos.estadisticas.salud}       @\n" +
            "-------------------------------------:.........................:.:.--:-=+%%@@#:....-::::::::@:Ki:${villanos.estadisticas.ki}             @\n" +
            "--------------------------------------..................-=*=*::::.:=:*%#*@@+::-:.***-%:::-#+@:Resistencia:${villanos.estadisticas.stamina}@\n" +
            "-------------------------------------.................:=*@@%%:...-=*-:#@*-+@*--+-:*@@@+.*@::@:::::::::::::::::::::::::+*#-**-++:::@\n" +
            "-------------------------------------..-..............:.:%@%%=::--@#:-@@-:-@@@@@%-=@@+:=@:::@%@%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "-------------------------------------...=::.............::.+@@*@#@@%@#+*%@@@@@#-=-%@*.:*%..:\n" +
            ":::::::::::::::::::::::::::::::::::::::::::::::::.......:::..:@@%:.=:..:-#@%@@-:*@*::-=@#..:\n" +
            "::::::::...:::....:....*@*::..::::::::::::::::::::....:::..:::::.::**::=*#%@%@@.:::::-=@::::\n" +
            ":::::::::::......::..+@@%-#@@@::::::::::::::::.::::::----+++++++**%#+++*%%%@@@@+*=++-=@@-:::\n" +
            ":::::::::::::::::::.+@@@@@@@+:+#::::::::::::::--=+++=+=-++-=++:.-#@@#**#@@@@@-::.#@@@@@#==++\n" +
            ":::::::::::...::::.*@@@@@@@@@@@@%+=::::::::-++++++=:-+=-++=++--*@@@@@@@@@@@@@*-:::*@@@#+==++\n" +
            ":.::::::-@@@@@%+==@@@@@@@@@@@@@@@-.....::=++++++=-++++++++++*#@@@@#+=#@@@@@@@@@@%%*@%+=+++=-\n" +
            ":::::::::.:+@@@@@@@@@@@@@@@@@@@=+@@::::::-+++=-+==--+=++==+++@@@@@+*#**+++**#*#@@@@*+++++=++\n" +
            ":::::::::.:#%#@@@@@@@@@@@@@%#@*@.::::::::::-=++++====:-+++#@@:#@@@%%%%%%%%%%%%@@@:+@=%+++=-=\n" +
            ":::::::::::-#@@@@@@@@@%@#+:+=.:.::::::::::::::::--=++*++++++++++++++=++==++++++++#*++++++++*\n" +
            "::::::::::==#@@@@@@@@@%%+==:=:::::::::::::::::::::.=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "::::::::::::::..@%####%#*=::.::..:::::::::::...:::=@+:....................................::@\n" +
            "::::::::::::#@@%%####**%@@@*.:::::::::::::::::::::=@+:. ${gottens.nombre} ............:::@+*..:%@\n" +
            "::::::..:.*@%%%@@%#+*#@@%@@@%:::::::::.....::::::.=@+:.%*#+*%.%.@+=+:#.........::...:@*#:@:%@\n" +
            "::::::.::+@######+*##@@@#:..@::.%##::*........::..=@+:....................................::@\n" +
            "...::::::-#*+#######%@@*++:+=..#%@=@@@*:..........=@=:......:Salud:${gottens.estadisticas.salud}   @\n" +
            ":::::::::##*########%%%=:.=::::--:*-:=-.....::...:=@+:......:Ki:${gottens.estadisticas.ki}         @\n" +
            ":::::::::%%*++##**+*#%@*-:.-=+::@@-..*::::::::::::=@+:......:Resistencia:${gottens.estadisticas.stamina}::@\n" +
            "+++++=++@%%%#*++++##@%%@@%=:+..*#@@@=:::::::::::::=@+:....................................::@\n" +
            "+--+=-++*@%@%%%#%####%%#%%+*++*@@#=++++++=-::::::#@@@@#*%**#*+******************************@\n" +
            "===+=++==+@@@@@@@%%@@@@@+=#%%%+++=:===:=+++++=-#@@@@@@@%%%**@%%+============================@\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@**********************************************\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@:@.@.@.@.@.@.@.@.@.......@.@.@.@.@.@.@.@.@:...\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@:@ Golpes  10pr  @.......@ Bolas-ki  2ki @....\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@:@.@.@.@.@.@.@.@.@:+.....@.@.@.@.@.@.@.@.@....\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@.........:....................................\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@:@.@.@.@.@.@.@.@.@.......@.@.@.@.@.@.@.@.@:...\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@:@Kamehameha 10ki@.......@ Kaio-ken 5ki @....\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@:@.@.@.@.@.@.@.@.@:+.....@.@.@.@.@.@.@.@.@....\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@.........:....................................\n" +
            "::::::::::::::::::::::::::::::::::::::::::::%@**********************************************\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
}

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





