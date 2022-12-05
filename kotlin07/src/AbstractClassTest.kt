abstract class Gun(val range:Int){
    abstract fun trigger() : String
}

class AK47 (_price: Int) : Gun(range = 100){
    override fun trigger(): String {
        return "AK47 shooting..."
    }
}

fun main() {
    val aK47 = AK47(500)
    println(aK47.trigger())
}