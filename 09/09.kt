import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var tailpositions = Array(10000) { IntArray(10000) }
    var hy = 5000
    var ty = 5000
    var hx = 5000
    var tx = 5000

    tailpositions[ty][tx] = 1

    println("Init $ty $tx")
    inputStream.bufferedReader().forEachLine {
        var to = it.split(" ")[0]
        var moves = it.split(" ")[1].toString().toInt()
        var auxmoves = 0

        println("Head $hy $hx")
        println("Tail $ty $tx")
        println("Move $to $moves")
        when (to){
            "U" -> {
                hy -= moves
                if(ty-hy > 1){
                    tx = hx
                    ty = ty-1
                    println("Up $ty $tx")
                    for(i in hy+1..ty) {
                        println("Up $i $tx")
                        tailpositions[i][tx] = 1
                        auxmoves +=1
                    }
                    ty = hy+1
                }

            }
            "R" -> {
                hx += moves
                if(hx-tx>1){
                    ty = hy
                    tx = tx+1
                    println("right $ty $tx")
                    for(i in tx..hx-1) {
                        println("Right $ty $i")
                        tailpositions[ty][i] = 1
                        auxmoves += 1
                    }
                    tx = hx-1
                }
            }
            "D" -> {
                hy += moves
                if(hy-ty>1){
                    tx = hx
                    ty = ty+1
                    println("down $ty $tx")
                    for(i in ty..hy-1) {
                        println("down $i $tx")
                        tailpositions[i][tx] = 1
                        auxmoves += 1
                    }
                    ty = hy-1
                }
            }
            "L" -> {
                hx -= moves
                if(tx-hx>1){
                    ty = hy
                    tx = tx-1
                    tailpositions[ty][tx] = 1
                    println("left $ty $tx")
                    for(i in hx+1..tx) {
                        println("left $ty $i")
                        tailpositions[ty][i] = 1
                        auxmoves += 1
                    }
                    tx = hx+1
                }
            }
            else -> { println("Error value $to") }
        }
        println("Auxmoves: $auxmoves")

    }

    var suma = 0
    for (i in 0..tailpositions.size-1) {
        for (j in 0..tailpositions[i].size - 1) {
            if (tailpositions[i][j] == 1) suma += 1
        }
    }
    println("posiciones: $suma")
}