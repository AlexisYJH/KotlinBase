import java.io.File

fun main() {
    var fileContents: List<String>//没有初始化
    val file = File("D://I have a dream.txt")
        .also { println(it.name) }
        .also { fileContents = it.readLines() }//初始化
    println(fileContents)
    println(file)
}