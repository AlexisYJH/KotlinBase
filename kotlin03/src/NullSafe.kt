fun main() {
    var str: String? = "hello"
    //str = ""
    //1）安全调用操作符?
    println(str?.capitalize())
    //使用带let的安全调用
    str = str?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "unkown"
        }
    }
    println(str)

    //2）非空断言操作符
    //str = null
    //println(str!!.toString())

    //3）使用if判断null值情况
    if (str != null) {
        str = str.capitalize();
    } else {
        str = "null"
    }
    println()

    //安全操作符更灵活简洁，可以进行多个函数的链式调用
    str = str?.capitalize()?.plus(" is great.");
    println(str)

    //空合并操作符
    str = null
    val strWithSafe = str ?: "default"
    println(strWithSafe)

    //空合并操作符和let函数，代替if/else语句
    //str = "hello"
    str = null
    str = str?.let { it.capitalize() } ?: "default"
    println(str)
}