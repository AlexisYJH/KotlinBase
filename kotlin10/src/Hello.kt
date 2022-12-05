fun main() {
    val hello = JHello()
    println(hello.utterGreeting())
    //NullPointerException
    hello.utterWords()?.toString()

    val point = hello.point //getPoint:0
    println(point.dec()) //-1
    hello.point = 10 //setPoint:10
    //类型映射：代码运行时，所有的映射类型都会重新映射回对应的Java类型
    println(point.javaClass) //int

    try {
        hello.throwException()
    } catch (e : Exception) {
        println(e)
    }
}

//添加一个translator的函数类型，接收一个字符串，将其改为小写字母，再大写第一个字符，最后打印结果。
val translator = { text: String ->
    println(text.toLowerCase().capitalize())
}
