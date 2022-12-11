import java.io.File
import java.io.InputStream
import kotlin.math.abs
import kotlin.system.exitProcess


fun printLinea(x:IntArray, y:IntArray){
    for(i in 0..30){
        for (j in 0..30){
            if(x[0] == j && y[0] == i) print("#")
            else if(x[1] == j && y[1] == i) print("#")
            else if(x[2] == j && y[2] == i) print("#")
            else if(x[3] == j && y[3] == i) print("#")
            else if(x[4] == j && y[4] == i) print("#")
            else if(x[5] == j && y[5] == i) print("#")
            else if(x[6] == j && y[6] == i) print("#")
            else if(x[7] == j && y[7] == i) print("#")
            else if(x[8] == j && y[8] == i) print("#")
            else if(x[9] == j && y[9] == i) print("#")
            else print (".")

        }
        println()
    }
    println()
    println()
}

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()

    var tailpositions = Array(10000) { IntArray(10000) }
    var y = IntArray(10) { 5000 }
    var x = IntArray(10) { 5000 }

    tailpositions[y[9]][x[9]] = 1
    inputStream.bufferedReader().forEachLine {
        var to = it.split(" ")[0]
        var moves = it.split(" ")[1].toString().toInt()
        when (to){
            "U" -> {
                for(nouse in 1..moves){
                    y[0] -= 1
                    for(aux in 1..9){
                        var ydiff = y[aux]-y[aux-1]
                        var auxydiff = abs(ydiff)

                        var xdiff = x[aux]-x[aux-1]
                        var auxxdiff = abs(xdiff)

                        if(xdiff == 0 && auxydiff==2) y[aux] -= 1
                        else if(ydiff == 0 && auxxdiff==2) {
                            if(xdiff < 0)
                                x[aux] += 1
                            else
                                x[aux] -= 1
                        }
                        else if (
                            (auxxdiff == 1 && auxydiff == 2) ||
                            (auxxdiff == 2 && auxydiff == 1) ||
                            (auxxdiff == 2 && auxydiff == 2)) {
                            if(ydiff < 0)
                                y[aux] += 1
                            else
                                y[aux] -= 1

                            if(xdiff < 0)
                                x[aux] += 1
                            else
                                x[aux] -= 1
                        }
                    }
                    tailpositions[y[9]][x[9]] = 1
                    //printLinea(x,y)
                }
            }
            "R" -> {
                for(nouse in 1..moves){
                    x[0] += 1
                    for(aux in 1..9){
                        var ydiff = y[aux]-y[aux-1]
                        var auxydiff = abs(ydiff)

                        var xdiff = x[aux]-x[aux-1]
                        var auxxdiff = abs(xdiff)

                        if(ydiff == 0 && auxxdiff==2) x[aux] += 1
                        else if(xdiff == 0 && auxydiff==2) {
                            if(ydiff < 0)
                                y[aux] += 1
                            else
                                y[aux] -= 1
                        }
                        else if (
                            (auxydiff == 1 && auxxdiff == 2) ||
                            (auxydiff == 2 && auxxdiff == 1) ||
                            (auxydiff == 2 && auxxdiff == 2)) {
                            if(ydiff < 0)
                                y[aux] += 1
                            else
                                y[aux] -= 1

                            if(xdiff < 0)
                                x[aux] += 1
                            else
                                x[aux] -= 1
                        }
                    }
                    tailpositions[y[9]][x[9]] = 1
                    //printLinea(x,y)
                }
            }
            "D" -> {
                for(nouse in 1..moves){
                    y[0] += 1
                    for(aux in 1..9){
                        var ydiff = y[aux]-y[aux-1]
                        var auxydiff = abs(ydiff)

                        var xdiff = x[aux]-x[aux-1]
                        var auxxdiff = abs(xdiff)

                        if(xdiff == 0 && auxydiff==2) y[aux] += 1
                        else if(ydiff == 0 && auxxdiff==2) {
                            if(xdiff < 0)
                                x[aux] += 1
                            else
                                x[aux] -= 1
                        }
                        else if (
                            (auxxdiff == 1 && auxydiff == 2) ||
                            (auxxdiff == 2 && auxydiff == 1) ||
                            (auxxdiff == 2 && auxydiff == 2)) {
                            if(ydiff < 0)
                                y[aux] += 1
                            else
                                y[aux] -= 1

                            if(xdiff < 0)
                                x[aux] += 1
                            else
                                x[aux] -= 1
                        }
                    }
                    tailpositions[y[9]][x[9]] = 1
                    //printLinea(x,y)
                }
            }
            "L" -> {
                for(nouse in 1..moves){
                    x[0] -= 1
                    for(aux in 1..9){
                        var ydiff = y[aux]-y[aux-1]
                        var auxydiff = abs(ydiff)

                        var xdiff = x[aux]-x[aux-1]
                        var auxxdiff = abs(xdiff)
                        if(ydiff == 0 && auxxdiff==2) x[aux] -= 1
                        else if(xdiff == 0 && auxydiff==2) {
                            if(ydiff < 0)
                                y[aux] += 1
                            else
                                y[aux] -= 1
                        }
                        else if (
                            (auxydiff == 1 && auxxdiff == 2) ||
                            (auxydiff == 2 && auxxdiff == 1) ||
                            (auxydiff == 2 && auxxdiff == 2)) {
                            if(ydiff < 0)
                                y[aux] += 1
                            else
                                y[aux] -= 1

                            if(xdiff < 0)
                                x[aux] += 1
                            else
                                x[aux] -= 1
                        }
                    }
                    tailpositions[y[9]][x[9]] = 1
                    //printLinea(x,y)
                }
            }
            else -> { println("Error value $to") }
        }
    }

    var suma = 0
    for (i in 0..tailpositions.size-1) {
        for (j in 0..tailpositions[i].size - 1) {
            if (tailpositions[i][j] == 1) suma += 1
        }
    }
    println("posiciones: $suma")
}