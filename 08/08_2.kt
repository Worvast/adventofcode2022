import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var forest = ArrayList<List<Int>>()

    inputStream.bufferedReader().forEachLine {
        forest.add(it.map { it.toString().toInt() })
    }

    val size = forest.size
    var big = 0

    for (i in 0..size-1){
        for (j in 0..size-1){
            var total = arrayOf(0, 0, 0, 0)
            val tree = forest[i][j]

            if(i != 0)
                for(auxi in i-1 downTo 0){
                    total[0] += 1
                    if(forest[auxi][j] >= tree) break
                }

            if(i != size-1)
                for(auxi in i+1..size-1){
                    total[1] += 1
                    if(forest[auxi][j] >= tree) break
                }

            if(j != 0)
                for(auxj in j-1 downTo 0){
                    total[2] += 1
                    if(forest[i][auxj] >= tree) break
                }

            if(j != size-1)
                for(auxj in j+1..size-1){
                    total[3] += 1
                    if(forest[i][auxj] >= tree) break
                }

            val aux = total[0] * total[1] * total[2] * total[3]
            if(aux > big) big = aux
        }
    }

    println()
    println("Max arboles para ver: $big")

}