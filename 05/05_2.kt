import java.io.File
import java.io.FileReader
import java.io.BufferedReader
import java.util.LinkedList
import kotlin.collections.MutableList


fun readStartingStatus (reader: BufferedReader): ArrayList<LinkedList<Char>> {
    var stringCases = mutableListOf<String>()
    val arrayOfLists: ArrayList<LinkedList<Char>> = arrayListOf()

    println("Initial state: ")
    var line = reader.readLine()
    while(line != null){
        println(line)
        if(line.isEmpty()) {
            for ((index, element) in stringCases[stringCases.lastIndex].withIndex()) {
                if (element != ' ') {
                    var startCases = LinkedList<Char>()
                    for(i in 0 until stringCases.lastIndex){
                        if(stringCases[i].length > index) {
                            if (stringCases[i][index] !in setOf(' ', '[', ']')){
                                startCases.add(stringCases[i][index])
                            }
                        }
                    }
                    startCases.reverse()
                    arrayOfLists.add(startCases)
                }
            }
            break
        } else {
            stringCases.add(line)
        }
        line = reader.readLine()
    }

    return arrayOfLists
}

fun readCratesMovements (reader: BufferedReader): ArrayList<IntArray> {
    var movements = ArrayList<IntArray>()
    var line = reader.readLine()
    while(line != null){
        val linesplit = line.split(" ")
        val numbers: IntArray = intArrayOf(linesplit[1].toInt(), linesplit[3].toInt()-1, linesplit[5].toInt()-1)
        movements.add(numbers)
        line = reader.readLine()
    }

    return movements
}

fun main() {
    val file = File("dataset")
    val reader = BufferedReader(FileReader(file))

    val crates: ArrayList<LinkedList<Char>> = readStartingStatus(reader)
    var movements: ArrayList<IntArray> = readCratesMovements(reader)

    for (mov in movements){
        var auxList: LinkedList<Char> = LinkedList<Char>()
        for (i in 1..mov[0]){
            auxList.add(crates[mov[1]].removeLast())
        }
        for (item in 0..auxList.size-1){
            crates[mov[2]].add(auxList.removeLast())
        }
    }

    reader.close()

    for ((index, element) in crates.withIndex()){
        println("$index: $element")
    }
}
