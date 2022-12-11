import java.io.File
import java.io.InputStream
import java.util.LinkedList

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var pending = LinkedList<String>()
    var cicle = 0
    var x = 1
    var running = 0
    var value: String = ""
    var signal_str = 0

    inputStream.bufferedReader().forEachLine {
        pending.addLast(it)
    }

    while(true){
        if(pending.isEmpty() && running == 0) break

        cicle += 1
        if(cicle == 20 || (cicle - 20).mod(40) == 0){
            var ss = cicle * x
            signal_str += ss
        }

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