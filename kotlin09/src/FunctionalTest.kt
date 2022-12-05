fun main() {
    val list = listOf("zebra", "giraffe", "elephant", "cat")
    //原实集合没有被修改，返回的是一个新集合
    //函数式编程范式支持的设计理念就是不可变数据的副本在链上的函数间传递
    val babies = list
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby wth the cutest little tail ever!" }
    println(list)
    println(babies)

    //返回集合中元素个数和输入集合一样，可以是不同类型
    val length = list.map { it.length }
    println(length)

    //看下map函数的定义
    //public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {

    val result = listOf(listOf(1, 2,3), listOf(4,5,6)).flatMap { it }
    println(result)
}