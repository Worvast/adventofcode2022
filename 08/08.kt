import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("dataset").inputStream()
    var forest = ArrayList<List<Int>>()

    inputStream.bufferedReader().forEachLine {
        forest.add(it.map { it.toString().toInt() })
    }

    val size = forest.size
    var visibles = (size * 4) - 4

    for (i in 1..size-2){
        for (j in 1..size-2){
            var visible = arrayOf(true, true, true, true)
            for(auxi in i-1 downTo 0){
                if(forest[auxi][j] >= forest[i][j]) {
                    visible[0] = false
                    break
                }
            }
            for(auxi in i+1..size-1){
                if(forest[auxi][j] >= forest[i][j]) {
                    visible[1] = false
                    break
                }
            }
            for(auxj in j-1 downTo 0){
                if(forest[i][auxj] >= forest[i][j]) {
                    visible[2] = false
                    break
                }
            }
            for(auxj in j+1..size-1){
                if(forest[i][auxj] >= forest[i][j]) {
                    visible[3] = false
                    break
                }
            }
            if(!visible.all { it == false }) visibles += 1
        }
    }

    println()
    println(forest.size)
    println(forest[0].size)
    println("Visibles: $visibles")

}