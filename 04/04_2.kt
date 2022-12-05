import java.io.File
import java.io.InputStream

fun result(line: List<String>): Boolean {
    val r1 = line[0].split("-").map { it.toInt() }.toTypedArray()
    val r2 = line[1].split("-").map { it.toInt() }.toTypedArray()

    if(r1[0] >= r2[0] && r1[0] <= r2[1] ||
        r2[0] >= r1[0] && r2[0] <= r1[1]){
        return true
    }
    return false
}

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var s:Int = 0

    inputStream.bufferedReader().forEachLine {
        if(result(it.split(","))){
            s += 1
        }
    }
    println(s)
}