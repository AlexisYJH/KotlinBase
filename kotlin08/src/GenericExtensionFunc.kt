/*
fun String.addExt(amount:Int = 1) = this + "!".repeat(amount)
fun <T> T.easyPrint() : T{
    println(this)
    return this
}

fun main() {
    //要在addExt之前和之后分别打印怎么办？泛型扩展函数
    "abc".easyPrint().addExt(10).easyPrint()
    "abc".let {  }
}*/
