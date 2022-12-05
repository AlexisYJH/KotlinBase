fun main() {
    println(doSomething(5, false))

    fix("Jack")

    //具名函数参数
    fix(age = 4, name = "Jack")

    //kotlin.Unit
    println(fix(age = 4, name = "Jack"))

    //抛出异常，返回Nothing类型
    TODO("nothing")
    println("after nothing")
}

private fun doSomething(age:Int, flag:Boolean):String{
    return "result"
}

private fun fix(name: String, age:Int=2) {
    println(name + age)
}