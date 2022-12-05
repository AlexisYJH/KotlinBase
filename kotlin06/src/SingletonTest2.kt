open class Player{
    open fun load() = "loading nothing."
}

fun main() {
    //对象表达式
    val player = object : Player() {
        override fun load() = "anonymous class load..."
    }
    println(player.load())
}