fun main() {
    val totalS = "Mississippi".count({letter->
        letter=='s'
    })
    //省略圆括号
    val totalS2 = "Mississippi".count{letter->
        letter=='s'
    }
    //直接使用it
    val totalS3 = "Mississippi".count{it=='s'}

    //简略写法
    showOnBoard("笔记本"){ goodsName: String, hour: Int->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
}

//具名参数
private fun showOnBoard(goodsName: String, getDiscountWords: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDiscountWords(goodsName, hour))
}