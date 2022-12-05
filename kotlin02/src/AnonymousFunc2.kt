fun main() {
    //定义参数是函数的函数
    //获取促销文案
    val getDiscountWords = { goodsName: String, hour: Int->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
    //展现
    showOnBoard("笔记本", getDiscountWords)
}

//具名参数
private fun showOnBoard(goodsName: String, getDiscountWords: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDiscountWords(goodsName, hour))
}