//给枚举类添加一个主构造函数
enum class Direction2(private val coordinate: Coordinate){
    //因为枚举类的构造函数带参数，所以定义每个枚举常量时，都要传入Coordinate对象，调用构造函数
    EAST(Coordinate(1, 0)),
    WEST(Coordinate(-1, 0)),
    SOUTH(Coordinate(0, 1)),
    NORTH(Coordinate(0, -1));

    fun update(c: Coordinate) = Coordinate(c.x + coordinate.x, c.y + coordinate.y)
}

fun main() {
    //调用函数时，使用的是枚举常量
    println(Direction2.EAST.update(Coordinate(10, 20)))
}