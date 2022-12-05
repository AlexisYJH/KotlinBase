class Player6{
    val blood = 100
    init {
        //使用初始化块时，顺序非常重要，必须保证块中的所有属性已经完成初始化
        //编译报错：Variable 'blood' must be initialized
        val bloodBonus: Int = blood.times(10)
    }
    //val blood = 100
}

class Player7{
    //属性被使用时，必须保证使用到的属性已经完成初始化
    //编译没问题，运行NullPointerException
    val name:String
    private fun firstLetter() = name[0]
    init {
        //println(firstLetter())
        name = "xxx"
    }
}

class Player8(_name: String) {
    //在Kotlin中属性顺序有影响，java中属性顺序无影响
    //一个属性的初始化使用了其他属性时，必须保证使用到的属性已经完成初始化
    //编译没问题，运行null
    val name = _name
    val playerName: String = initPlayerName()
    //val name = _name
    private fun initPlayerName() = name;
}


fun main() {
    Player6()
    Player7()
    println(Player8("xxx").playerName)//null
}