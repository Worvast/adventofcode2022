import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var maxCal:Int = 0
    var currentCal:Int = 0

    inputStream.bufferedReader().forEachLine {
        if(it != "") {
            currentCal += it.toInt()
        } else {
            println("Total calorias de este gnomo: $currentCal")
            println("Máximo actual: $maxCal")
            if(currentCal > maxCal) {
                println("Cambios el maxcal")
                maxCal = currentCal
            }
            currentCal = 0
        }
    }

    println("Total calorias de este gnomo: $currentCal")
    println("Máximo actual: $maxCal")
    if(currentCal > maxCal) {
        println("Cambios el maxcal")
        maxCal = currentCal
    }
    println("Max cal: $maxCal")
}