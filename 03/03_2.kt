import java.io.File
import java.io.IOException
import java.util.*

fun main() {
    val fileName = "dataset"
    var s: Int = 0

    val sc = Scanner(File(fileName))
    while (sc.hasNextLine()) {
        val set1 = sc.nextLine().toSet()
        val set2 = sc.nextLine().toSet()
        val set3 = sc.nextLine().toSet()
        for (c in set1) {
            if (set2.contains(c)) {
                if (set3.contains(c)){
                    var value: Int = c.code
                    if (c.isLowerCase()) value -= 96
                    else value -= 38
                    s += value
                    break
                }
            }
        }
    }
    println(s)
}