/*
class MagicBox<T>(item: T) {
    var available = false
    private var subject: T = item
    fun fetch(): T?{
        return subject.takeIf { available }
    }
}

class Boy(val name: String, val age: Int)
class Dog(val weight: Int)

fun main() {
    val box1: MagicBox<Boy> = MagicBox(Boy("Jack", 20))
    val box2: MagicBox<Dog>  = MagicBox(Dog(20))
    box1.available = true
    box1.fetch()?.run { println("you find $name") }
}*/
