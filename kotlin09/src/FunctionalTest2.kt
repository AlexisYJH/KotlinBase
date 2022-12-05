fun main() {
    //predicate函数，返回true添加，false移出
    val list = listOf("Jason", "Jack", "Jacky", "Tom")
    val result = list.filter { it.contains("J") }
    //原实集合没有被修改，返回的是一个新集合
    println(list)
    println(result)
    //public inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {

    //flatMap + filter
    val items = listOf(
        listOf("red apple", "green apple", "blue apple"),
                listOf("red fish", "blue fish"),
        listOf("yellow banana", "teal banana")
    )
    val redItems = items.flatMap { it.filter { it -> it.contains("red") } }
    println(redItems)

    //求素数：除了1和本身，并不能被任何数整除的数
    val nums = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = nums.filter { num ->
        //num: 7, 4, ...; it: [2: num)比如[2:7)[2:4)
        (2 until num).map { num % it }
            //取模为0，说明能整除，如果没有一个为0，说明是素数
            .none {it == 0}
    }
    println(primes)
}