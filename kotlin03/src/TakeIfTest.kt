import java.io.File

fun main() {
    //null
    //val result = File("")
    val fileContents = File("D://I have a dream.txt")
        .takeIf { it.exists() && it.canRead() }
        ?.readText()
    println(fileContents)

    //不用takeIf
    val file = File("D://I have a dream.txt")
    val fileContents2 = if (file.exists() && file.canRead()) file.readText() else null
    println(fileContents2)

    val result = File("D://I have a dream.txt")
        .takeUnless { it.isHidden }
        ?.readText()
    println(result)
}