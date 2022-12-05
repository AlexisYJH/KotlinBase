import java.io.File

fun main() {
    //配置一个File实例
    val file = File("D://I have a dream.txt")
    file.setReadable(true)
    file.setWritable(true)
    file.setExecutable(false)
    //使用apply
    val file2 = File("D://I have a dream.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
    println(file2.name)
}