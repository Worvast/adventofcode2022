import java.io.File
import java.io.InputStream

val a = mapOf("X" to 3, "Y" to 4, "Z" to 8)
val b = mapOf("X" to 1, "Y" to 5, "Z" to 9)
val c = mapOf("X" to 2, "Y" to 6, "Z" to 7)

fun result(duel: List<String>): Int {
    when (duel[0]) {
        "A" -> return a.getOrDefault(duel[1], 0)
        "B" -> return b.getOrDefault(duel[1], 0)
        else -> return c.getOrDefault(duel[1], 0)
    }
}

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var points:Int = 0

    inputStream.bufferedReader().forEachLine {
        points += result(it.split(" "))
    }
    println(points)
}