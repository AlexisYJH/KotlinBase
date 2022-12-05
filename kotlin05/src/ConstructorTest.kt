import kotlin.math.absoluteValue

class Player(
    _name: String,
    _age: Int,
    _isNormal: Boolean
) {
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
    var age = _age
        get() = field.absoluteValue
        set(value) {
            field = value.absoluteValue
        }

    var isNormal = _isNormal
}

fun main() {
    //此处的赋值没有执行set方法，直接赋值
    val player = Player(" Jack ", -20, true)
    //player.name = " rose "
    println("${player.name}, ${player.age}")
}