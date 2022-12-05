import java.io.File

open class Product(val name: String){
    fun description() = "Product $name"
    open fun load() = "Nothing..."
}

class LuxuryProduct: Product("Luxury"){
    override fun load() = "LuxuryProduct loading..."
    fun special() = "LuxuryProduct special function"
}

fun main() {
    val product : Product = LuxuryProduct()
    println(product.load())
    println(product is Product)
    println(product is LuxuryProduct)
    println(product is File)
    println(product is Any)
    println(product.toString())

    if (product is LuxuryProduct) {
        println("is-->" + product.special())
    }
    //类型转换
    println("as-->" + (product as LuxuryProduct).special())
    //智能类型转换，转一次以后，后面不需要转，直接使用
    println("as after-->" + product.special())

}