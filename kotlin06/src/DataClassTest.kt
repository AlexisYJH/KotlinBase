data class Coordinate(var x:Int, var y: Int){
    val isInBounds = x >= 0 && y >= 0
    var max = 0
    constructor(_x: Int):this(_x, 0){
        max = 100
    }

    override fun toString(): String {
        return "Coordinate(x=$x, y=$y), isInBounds: $isInBounds, max: $max";
    }
}

fun main() {
    println(Coordinate(1,1))
    //== 比较内容，equals，Any默认实现===，比较引用
    //=== 比较引用
    println(Coordinate(1,1) == Coordinate(1,1))//data类true；非data类false

    //去除data
    //Coordinate@7f31245a
    //false Any默认实现===，比较引用

    //有data，数据类提供了toString, equals, hashCode的个性化实现
    //Coordinate(x=1, y=1)
    //true

    val coordinate = Coordinate(1)
    //只复制主构造函数中定义的属性
    val copy = coordinate.copy(y = -100)
    println(coordinate) //Coordinate(x=1, y=0), isInBounds: true, max: 100
    println(copy) //Coordinate(x=1, y=100), isInBounds: true, max: 0

    val (x, y) = Coordinate(10, 10)
    println("$x, $y")
}