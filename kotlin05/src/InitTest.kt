class Player3(
    _name: String,
    var age: Int = 18,
    var isNormal: Boolean
) {
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    init {
        //require：参数为false，抛出IllegalArgumentException
        require(age > 0){"age must be positive."}
        require(name.isNotBlank()){"player must have a name."}
    }
}

fun main() {
    //具名函数参数
    val player = Player3("Jack", isNormal = false)
    println(player.age)

    //IllegalArgumentException: player must have a name.
    Player3(isNormal = false, _name = "")
}