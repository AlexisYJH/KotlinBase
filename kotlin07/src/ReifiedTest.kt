class MagicBox<T : Human>() {
    //随机产生一个对象，如果不是指定类型对象，就通过backup函数生成一个指定类型的对象
    //Kotlin不允许对泛型参数T做类型检查，因为泛型参数类型会被类型擦除，即T的类型信息在运行时是不可知的
    //reified：帮助检查泛型参数类型（必须和inline一起使用），保存泛型类型，避免类型擦除
    inline fun <reified T> randomOrBackup(backup: () -> T) : T {
        val items = listOf(
            Boy("Jack", 20),
            Man("John", 30)
        )
        val random = items.shuffled().first()
        println(random)
        return if (random is T) {
            random
        } else {
            backup()
        }
    }
}

open class Human(val age: Int)
class Boy(val name: String, age: Int): Human(age) {
    override fun toString(): String {
        return "Boy($name, $age)"
    }
}
class Man(val name: String, age: Int): Human(age){
    override fun toString(): String {
        return "Man($name, $age)"
    }
}

fun main() {
    val box : MagicBox<Human> = MagicBox()
    // 由backup函数推断出来T的类型
    // 即这里得匿名函数返回Man实例，则T为Man类型，返回Boy实例，则T为Boy类型
    val subject = box.randomOrBackup {
        //subject类型为Man
        //Man("Jimmy", 38)
        //subject类型为Boy
        Boy("Jacky", 9)
    }
    println(subject)
}