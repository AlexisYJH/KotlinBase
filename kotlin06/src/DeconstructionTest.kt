class Score(val experience:Int, val level:Int){
    //0, 3, 4都不行
    operator fun component1() = experience
    operator fun component2() = level
}

fun main() {
    val (x, y) = Score(10, 20)
    println("$x, $y")
}