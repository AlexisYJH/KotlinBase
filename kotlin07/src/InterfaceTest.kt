interface Movable{
    val maxSpeed: Int
        get() = (1..500).shuffled().last()
    var wheels: Int
    fun move(movable: Movable) : String
}

class Car(_name:String, override var wheels: Int = 4) : Movable{
    //子类可以将父类val改为var，父类var不可改为子类的val
    override var maxSpeed: Int
        get() = super.maxSpeed
        set(value) {}

    override fun move(movable: Movable): String {
        TODO("Not yet implemented")
    }
}