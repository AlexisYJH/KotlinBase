import java.io.File

//doSomething是一个具名函数，需要传入一个匿名函数，该匿名函数无参，返回类型为Unit，fix是匿名函数的名字
fun doSomething(fix: ()-> Unit) {
    fix()
}

//扩展函数
fun String.addExt() = "!".repeat(this.count())

// 为什么要传入泛型的扩展函数，而不是一个普通的匿名函数？
// T.() -> Unit 泛型的扩展函数
// 扩展函数里自带了接收者对象的this的隐式调用
// 为什么是泛型的扩展函数？
// 为了支持任何类型

// 匿名函数，也可以是扩展函数
// 普通的匿名函数
// () -> Unit
// File类型的匿名函数（匿名函数内部this指向一个File对象, 隐式调用）
// File.() -> Unit

/*public inline fun <T> T.apply(block: T.() -> Unit): T {
    //相当于T.block() 接收者对象的this的隐式调用
    block()
    return this
}*/

fun main() {
    val file  = File("xx").apply {
        setReadable(true)
    }

    //分解
    //1. 定义扩展函数
    fun File.ext(): Unit{
        setReadable(true)
    }
    //2. 给block变量赋值
    val block = File::ext
    //3. 传入apply函数
    //两种写法一样
    //File("xx").apply(block)
    File("xx").apply { block }
}


