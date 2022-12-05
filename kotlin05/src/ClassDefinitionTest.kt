class Test {
    //set会检查空安全
    var name:String= "abc"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    //计算属性
    val rolledValue
        get() = (1..6).shuffled().first()

    var words: String? = "hello"
    fun saySomething() {
        words?.also {
            println("Hello ${it.toUpperCase()}")
        }
    }
}

fun main() {
    var test = Test();
    //调用setName
    test.name = " rose "
    //调用getName
    println(test.name)
    println(test.rolledValue)
    test.saySomething()
}