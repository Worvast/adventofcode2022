import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    inputStream.bufferedReader().forEachLine {
        for (i in 1..it.length) {
            val miSetMutable = it.substring(i-1, i+14).toSet()
            if(miSetMutable.size == 14) {
                println(i+14)
                break
            }
        }
    }
}