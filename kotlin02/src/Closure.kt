fun main() {
    val getDiscountWords = configDiscountWords()
    println(getDiscountWords("笔记本"))
}

//函数类型作为返回类型
private fun configDiscountWords() : (String) -> String{

    /*return {goodsName: String->
        val currentYear = 2027
        val hour = (1..24).shuffled().last()
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }*/

    val currentYear = 2027
    val hour = (1..24).shuffled().last()
    return {goodsName: String->
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
}