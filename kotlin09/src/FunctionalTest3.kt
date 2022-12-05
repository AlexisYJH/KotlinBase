fun main() {
    val employees = listOf("Jack", "Jason", "Tom")
    val shirtSize = listOf("large", "x-large", "medium")
    val ages = listOf(18, 19, 20)
    //zip返回一个包含键值对的新集合
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes["Jack"])
    val employeeAges = employees.zip(ages) //[(Jack, 18), (Jason, 19), (Tom, 20)]
        .toMap(); //{Jack=18, Jason=19, Tom=20}
    println(employeeAges)

    //public infix fun <T, R> Iterable<T>.zip(other: Iterable<R>): List<Pair<T, R>> {

    //fold 接受一个初始累加器值，随后会根据匿名函数的结果更新
    val foldValue = listOf(1, 2, 3, 4).fold(2) {accumulator, number ->
        println("Accumulator value: $accumulator")
        accumulator + (number * 3)
    }
    println(foldValue)
    /*public inline fun <T, R> Iterable<T>.fold(initial: R, operation: (acc: R, T) -> R): R {
        var accumulator = initial
        for (element in this) accumulator = operation(accumulator, element)
        return accumulator
    }*/
}