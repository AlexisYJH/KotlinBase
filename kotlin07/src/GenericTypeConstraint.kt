/*
class MagicBox<T : Human>(item: T) {
    var available = false
    private var subject: T = item
    fun fetch(): T?{
        return subject.takeIf { available }
    }
    fun <R> fetch(subjectModFunction:(T) -> R) : R? {
        return subjectModFunction(subject).takeIf { available }
    }
}

open class Human(val age: Int)
class Boy(val name: String, age: Int): Human(age)
class Man(val name: String, age: Int): Human(age)

fun main() {
    val box1: MagicBox<Boy> = MagicBox(Boy("Jack", 10))
    box1.available = true
    box1.fetch()?.run { println("you find $name") }
    val man = box1.fetch() { Man(it.name, it.age.plus(20)) }
    man?.let { println("${it.name}, ${it.age}") }
}*/
