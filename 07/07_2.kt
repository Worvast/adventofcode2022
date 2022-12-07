import java.io.File
import java.io.FileReader
import java.io.BufferedReader

class Folder {
    constructor(folderName: String) {
        this.name = folderName
    }

    var name : String
        get() = field

    var size = 0
        get() = field

    var folders = ArrayList<Folder>()
        get() = field

    fun printInfo() {
        println("Name: $name, Size: $size")
        if(!this.folders.isEmpty()) {
            print("/ ")
            for(folder in this.folders) folder.printInfo()
        }
    }

    fun sumSize(fileSize: Int){
        this.size += fileSize
    }

    fun AOCPart1Result():Int{
        var sum = 0
        if(!this.folders.isEmpty()) {
            for(folder in this.folders) sum += folder.AOCPart1Result()
        }
        if(this.size < 100000) sum += this.size
        return sum
    }

    fun addFolderInfo(reader: BufferedReader){
        var line = reader.readLine()
        while(line != null && line != "\$ cd .."){
            when(line.substring(0, 3)){
                "dir" -> {
                    val folderName = line.split(" ")
                    this.folders.add(Folder(folderName[1]))
                }
                "\$ l" -> {}
                "\$ c" -> {
                    var aux = 0
                    if(!this.folders.isEmpty()){
                        for ((i, f) in this.folders.withIndex()){
                            if(f.name == line.split(" ")[2]) aux = i
                        }
                    }
                    this.folders[aux].addFolderInfo(reader)
                    this.sumSize(this.folders[aux].size)
                }
                else -> {
                    this.sumSize(line.split(" ")[0].toInt())
                }
            }
            line = reader.readLine()
        }
    }

    fun searchFolderToDelete(){
        val freeSpace = 70000000 - this.size
        val needSpace = 30000000 - freeSpace
        println("Freespace: $freeSpace, Need space: $needSpace")
        var smallFolder = this.getSmallFolder(this.folders, needSpace)
        println(smallFolder)
    }

    fun getSmallFolder(subfolders:ArrayList<Folder>, needSpace:Int): Int{
        var smallSubfolder: Int = this.size
        if(smallSubfolder < needSpace) smallSubfolder = needSpace - 1
        for (sf in subfolders){
            if (!this.folders.isEmpty()){
                var aux: Int = sf.getSmallFolder(sf.folders, needSpace)
                if(aux > needSpace && aux < smallSubfolder) smallSubfolder = aux
            }
        }
        return smallSubfolder
    }
}

fun main() {
    val file = File("dataset")
    val reader = BufferedReader(FileReader(file))
    //This line is for the cd /
    reader.readLine()
    var mainFolder = Folder("/")
    mainFolder.addFolderInfo(reader)
    reader.close()
    mainFolder.printInfo()

    println("Result AOC Part 1: ")
    println(mainFolder.AOCPart1Result())

    println("Result AOC Part 2:")
    mainFolder.searchFolderToDelete()
}