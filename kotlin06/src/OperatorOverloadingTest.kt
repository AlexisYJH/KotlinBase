data class Coordinate2(var x:Int, var y:Int) {
    operator fun plus(other: Coordinate2) = Coordinate2(x + other.x, y + other.y)
    operator fun compareTo(other: Coordinate2) :Int {
        if (x == other.x && y == other.y){
            return 0;
        } else if (x >= other.x && y >= other.y) {
            return 1;
        } else {
            return -1;
        }
    }
    operator fun contains(other: Coordinate2) = x >= other.x && y >= other.y
    override fun equals(other: Any?): Boolean {
        return true;
    }
}

fun main() {
    val c1 = Coordinate2(100,100)
    val c2 = Coordinate2(50,50)
    println(c1 == c2) //equals
    println(c1 + c2) //plus
    println(c1 > c2) //compareTo
    println(c2 in c1) //contains
}