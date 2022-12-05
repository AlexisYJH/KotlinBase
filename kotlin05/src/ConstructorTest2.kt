import kotlin.math.absoluteValue

class Player2(
    _name: String,
    var age: Int,
    var isNormal: Boolean
) {
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    //多个次构造函数来配置不同的参数组合
    constructor(name: String) : this(name, 10, false)

    constructor(name: String, age: Int) : this(name, age, false) {
        //初始化代码逻辑
        this.name = name.toUpperCase();
    }
}

fun main() {
    //此处的赋值没有执行set方法，直接赋值
    val player = Player2(" Jack ", -20, true)
    println(player.name)
    println(player.age)
    player.name = " rose "
    println(player.name)

    val player2 = Player2("Jimmy")
    println(player2.name)
    println(player2.age)

    val player3 = Player2("Jacky", 30)
    println(player3.name)
    println(player3.age)
}