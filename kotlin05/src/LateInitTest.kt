class Player4{
    lateinit var equipment: String
    fun ready() {
        equipment = "sharp knife"
    }

    fun battle() {
        //如果没有初始化，抛出异常
        //kotlin.UninitializedPropertyAccessException: lateinit property equipment has not been initialized
        //println(equipment)
        println(if(::equipment.isInitialized) equipment else "no equipment")
    }
}

fun main() {
    val player = Player4()
    //player.ready()
    player.battle()

}
