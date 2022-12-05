fun main() {
    val age = 3
    if (age in 0..3) {
        println("婴幼儿")
    } else if (age in 3..12) {
        println("少儿")
    } else {
        println("未知")
    }

    if(age !in 1..3) {

    }

    val school = "大学"
    val level = when(school) {
        "学前班"->"幼儿"
        "小学"->"少儿"
        "中学"->"青少年"
        "大学"->"成年"
        //匿名表达式
        else -> {
            println("未知")
        }
    }
    println(level)
}