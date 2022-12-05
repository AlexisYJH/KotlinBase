//对象声明
object ApplicationConfig{
    init {
        println("ApplicationConfig loading...")
    }

    fun doSomething() {
        println("doSomething")
    }
}

fun main() {
    //类名，实例名
    ApplicationConfig.doSomething()
    println(ApplicationConfig)
    println(ApplicationConfig)
}