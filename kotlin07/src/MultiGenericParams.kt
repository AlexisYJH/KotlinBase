/*
class MagicBox<T>(item: T) {
    var available = false
    private var subject: T = item
    fun fetch(): T?{
        return subject.takeIf { available }
    }

    //把元素进行修改
    //return -> R
    fun <R> fetch(subjectModFunction:(T) -> R) : R? {
        return subjectModFunction(subject).takeIf { available }
    }
}

class Boy(val name: String, val age: Int)
class Man(val name: String, val age: Int)

fun main() {
    val box1: MagicBox<Boy> = MagicBox(Boy("Jack", 10))
    box1.available = true
    box1.fetch()?.run { println("you find $name") }
    //男孩变成了男人，返回
    //fetch函数传入了一个匿名函数（以Boy为参数类型，以Man为返回类型）
    val man = box1.fetch() { Man(it.name, it.age.plus(20)) }
    man?.let { println("${it.name}, ${it.age}") }
}*/
