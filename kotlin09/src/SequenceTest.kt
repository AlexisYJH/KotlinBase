fun main() {
    //函数扩展
    fun Int.isPrime(): Boolean{
        //until -> infix
        (2 until this).map {
            if (this % it == 0) {
                return false
            }
        }
        return true
    }

    //产生头1000素数
    //假定0-5000之内，可以找到1000个素数，事实上只找到了671个
    //.. -> 运算符重载，对应rangeTo函数
    //toList() -> 集合，泛型
    //filter -> 函数式编程
    //{ it.isPrime() } -> 匿名函数
    val list = (0..5000).toList().filter { it.isPrime() }.take(1000)
    println(list.size)

    val result = generateSequence(0) { it + 1 }
        .filter { it.isPrime()}
        .take(1000)
    println(result)
    println(result.toList().size)

    //public fun <T : Any> generateSequence(seed: T?, nextFunction: (T) -> T?): Sequence<T>
}