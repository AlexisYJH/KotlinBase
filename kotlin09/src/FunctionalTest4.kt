fun main() {
    val employees = listOf("Jack", "Jason", "Tom")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    //函数式编程
    val list = employeeShirtSizes.map { "${it.key}, shirt size: ${it.value}" }
    println(list)
}