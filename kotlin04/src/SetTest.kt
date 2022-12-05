fun main() {
    val set = setOf("Jason", "Jack", "Jacky", "Jack")
    //没有这种写法
    //set[3]
    //IndexOutOfBoundsException
    //set.elementAt(3)
    println(set.elementAtOrNull(3)?: "Unknown")

    val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")
    mutableSet += "Groovy"
    println(mutableSet)

    val list = listOf("Jason", "Jack", "Jacky", "Jack").toSet().toList()
    println(list)

    println(listOf("Jason", "Jack", "Jacky", "Jack").distinct())
}