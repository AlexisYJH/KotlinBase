fun main() {
    val mutableList = mutableListOf("Jason", "Jack", "Jacky")
    //mutableList.add("Jimmy")
    //mutableList.remove("Jack")
    println(mutableList)

    listOf("Jason", "Jack", "Jacky").toMutableList()
    mutableListOf("Jason", "Jack", "Jacky").toList()

    //运算符重载
    mutableList += "Jimmy"
    mutableList -= "Jason"

    mutableList.removeIf { it.contains("Jack") }
    println(mutableList)
}