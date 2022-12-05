class Player5(_name: String){
    var name = _name

    val config by lazy { loadConfig() }

    private fun loadConfig(): String{
        println("loading...")
        return "xxx"
    }
}

fun main() {
    val player = Player5("Jack")
    Thread.sleep(3000)
    println(player.config)
}