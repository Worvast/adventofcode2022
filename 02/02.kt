import java.io.File
import java.io.InputStream

fun result(duel: List<String>): Int {
    when (duel[0]) {
        "A" -> if(duel[1] == "X") return 4 else if (duel[1]=="Y") return 8 else return 3
        "B" -> if(duel[1] == "X") return 1 else if (duel[1]=="Y") return 5 else return 9
        else -> if(duel[1] == "X") return 7 else if (duel[1]=="Y") return 2 else return 6
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