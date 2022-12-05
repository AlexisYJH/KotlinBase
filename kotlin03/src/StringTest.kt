const val NAME = "Jimmy's friend"
const val NAMES = "jack,jacky,jason"
fun main() {
    val index = NAME.indexOf('\'')
    //NAME.substring(0, index)
    //支持IntRange类型的参数
    var str = NAME.substring(0 until index)
    println(str)

    val data = NAMES.split(",")
    println(data)
    val(origin, dest, proxy) = NAMES.split(",")
    println("$origin $dest $proxy")

    val str1 = "The people's Republic Of China."
    val str2 = str1.replace(Regex("[aeiou]")){
        when(it.value) {
            "a" -> "8"
            "e" -> "6"
            "i" -> "9"
            "o" -> "1"
            "u" -> "3"
            else -> it.value
        }
    }
    println(str1)
    println(str2)

    val text1 = "Jason"
    val text2 = "jason".capitalize()
    println(text1 == text2) //true
    println(text1 === text2) //false

    "The people's Republic Of China.".forEach {
        print("$it*")
    }
}