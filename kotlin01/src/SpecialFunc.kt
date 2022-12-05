fun main() {
    //避免冲突（不同的保留关键字）
    MyJava.`is`()
    `**~special function with weird name~**`()
}

//测试函数名含空格
private fun `**~special function with weird name~**`(){
    println("special named function invoked")
}