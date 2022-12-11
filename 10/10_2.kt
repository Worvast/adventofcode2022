import java.io.File
import java.io.InputStream
import java.util.LinkedList

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var pending = LinkedList<String>()
    var x = 1
    var running = 0
    var value: String = ""
    var signal_str = 0
    var cicle_aux:Int = 0

    inputStream.bufferedReader().forEachLine {
        pending.addLast(it)
    }

    for(cicle in 0..239){
        if(cicle.mod(40) == 0){
            println()
            var n = cicle / 40
            cicle_aux = 40*n
        }
        if(x-1 == cicle - cicle_aux || x == cicle - cicle_aux || x+1 == cicle - cicle_aux) print("#")
        else print(".")

        if (running == 0) value = pending.pollFirst()

        if(value == "noop"){
            continue
        } else {
            if(running == 0) running = 1
            else {
                running = 0
                x += value.split(" ")[1].toString().toInt()
            }
        }
    }

    println(signal_str)
}