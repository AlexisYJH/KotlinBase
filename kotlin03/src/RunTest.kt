import java.io.File

fun main() {
    val file = File("D://I have a dream.txt")
    val result = file.run {
        readText().contains("great")
    }
    println(result)

    //val result2 = isLong("The people's Republic Of China.")
    val result2 = "The people's Republic Of China.".run(::isLong)
    println(result2)
    //当有多个函数调用，run的优势就显而易见了
    "The people's Republic Of China."
        .run(::isLong)
        .run(::showMessage)
        .run(::println)
}

private fun isLong(name: String) = name.length >= 10

private fun showMessage(isLong: Boolean):String = if(isLong) "Name is too long." else "Name's length checked."

