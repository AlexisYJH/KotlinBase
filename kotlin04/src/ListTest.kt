fun main() {
    val list = listOf("Jason", "Jack", "Jacky")
    //ArrayIndexOutOfBoundsException
    //println(list[3])
    println(list.getOrElse(3){"Unknown"})
    println(list.getOrNull(3))
    //getOrNull + 空合并操作符
    println(list.getOrNull(3)?:"Unknown")
}