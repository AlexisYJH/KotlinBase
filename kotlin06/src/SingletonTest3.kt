import java.io.File

open class ConfigMap{
    //只有初始化ConfigMap类或者调用load函数时，伴生对象的内容才会载入。
    //无论ConfigMap实例化多少次，这个伴生对象始终只有一个实例
    companion object{
        private const val PATH = "xxx"
        fun load() = File(PATH).readBytes()
    }
}

fun main() {
    //static
    ConfigMap.load()
}