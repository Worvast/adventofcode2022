import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var s:Int = 0

    inputStream.bufferedReader().forEachLine {
        val hl = it.length / 2
        val first = it.substring(0, hl).toSet()
        val second = it.substring(hl).toSet()
        for(c in first){
            if (second.contains(c)) {
                var value:Int = c.code
                if(c.isLowerCase()) value -= 96
                else value -= 38
                s += value
                break
            }
        }
    }
    println(s)
}