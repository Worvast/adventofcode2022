import java.io.File
import java.io.InputStream
import java.util.Arrays

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var maxCal = IntArray(3) { _ -> 0 }
    var currentCal:Int = 0

    inputStream.bufferedReader().forEachLine {
        if(it != "") {
            currentCal += it.toInt()
        } else {
            println("Total calorias de este gnomo: $currentCal")
            println("Máximo actual:")
            println(Arrays.toString(maxCal))
            for (i in 0..2){
                if(currentCal > maxCal[i]){
                    var aux = maxCal[i]
                    maxCal[i] = currentCal
                    currentCal = aux

                    println("Cambios el maxcal")
                    println(Arrays.toString(maxCal))
                }
            }
            currentCal = 0
        }
    }

    println("Total calorias de este gnomo: $currentCal")
    println("Máximo actual:")
    println(Arrays.toString(maxCal))
    for (i in 0..2){
        if(currentCal > maxCal[i]){
            var aux = maxCal[i]
            maxCal[i] = currentCal
            currentCal = aux

            println("Cambios el maxcal")
        }
    }

    println("Max cal:")
    println(Arrays.toString(maxCal))
    println("Calorias totales del top 3: ")
    println(maxCal.sum())
}