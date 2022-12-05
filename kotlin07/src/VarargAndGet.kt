/*
class MagicBox<T : Human>(vararg item: T) {
    var available = false
    //可变参数T前面必须使用out
    private var subject: Array<out T> = item
    fun fetch(index:Int): T?{
        return subject[index].takeIf { available }
    }
    fun <R> fetch(index: Int, subjectModFunction:(T) -> R) : R? {
        return subjectModFunction(subject[index]).takeIf { available }
    }

    operator fun get(index: Int): T? = fetch(index)
}

open class Human(val age: Int)
class Boy(val name: String, age: Int): Human(age)
class Man(val name: String, age: Int): Human(age)

fun main() {
    val box: MagicBox<Boy> = MagicBox(
        Boy("Jack", 10),
        Boy("Jacky", 11),
        Boy("Jimmy", 12))
    box.available = true
    box.fetch(1)?.run { println("you find $name") }
    val man = box.fetch(2) { Man(it.name, it.age.plus(20)) }
    man?.let { println("${it.name}, ${it.age}") }

    println(box[0]?.name)
}*/
