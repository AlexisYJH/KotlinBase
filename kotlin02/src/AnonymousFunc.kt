fun main() {
    val total = "Mississippi".count()
    //使用匿名函数给标准函数制定规则
    val totalS = "Mississippi".count({letter->
        letter=='s'
    })
    println(total)
    println(totalS)

    // 函数类型：函数的类型，由传入的参数和返回值类型决定
    // 隐式返回: 自动返回函数体最后一行语句的结果
    //变量的类型是一个匿名函数
    val blessingFunction:()->String
    blessingFunction = {
        val holiday = "New Year."
        "Happy $holiday"
    }

    //相同的写法
    val blessingFunction2:()->String = {
        val holiday = "New Year 2023"
        "Happy $holiday"
    }
    println(blessingFunction())
    println(blessingFunction2())

    //函数参数：参数的类型放在匿名函数的类型定义中，参数名放在函数定义中
    val blessingFunction3:(String)->String = {name->
        val holiday = "New Year."
        "$name, Happy $holiday"
    }
    println(blessingFunction3("Jack"))

    //只有一个参数，用it来表示参数名
    val blessingFunction4:(String)->String = {
        val holiday = "New Year."
        "$it, Happy $holiday"
    }
    println(blessingFunction4("Jack"))

    //类型推断：匿名函数为变量赋值，不需要显示指明变量类型（返回值的类型推断）
    val blessingFunction5 = {
        val holiday = "New Year."
        "Happy $holiday"
    }
    println(blessingFunction5())

    val blessingFunction6: (String, Int)->String = {name, year->
        val holiday = "New Year."
        "$name, Happy $holiday $year"
    }
    println(blessingFunction6("Jack", 2022))

    //类型推断：带参的匿名函数的参数名和类型必须有（参数的类型推断）
    val blessingFunction7 = {name:String, year:Int->
        val holiday = "New Year."
        "$name, Happy $holiday $year"
    }
    println(blessingFunction7("Jack", 2022))
}
