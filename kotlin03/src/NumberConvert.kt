import kotlin.math.roundToInt

fun main() {
    //NumberFormatException
    //val num1 : Int = "8.8".toInt()
    val num1 : Int? = "8.8".toIntOrNull()
    println(num1)

    println(8.8.toInt())
    println(8.8.roundToInt())

    val s = "%.2f".format(8.956756)
    println(s)
}