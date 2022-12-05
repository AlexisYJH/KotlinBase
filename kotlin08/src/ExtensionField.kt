//统计元音字母个数
val String.numVowels
    get() = count {"aeiouy".contains(it)}

fun <T> T.easyPrint() : T{
    println(this)
    return this
}

fun main() {
    "The people's Republic Of China.".numVowels.easyPrint()
}

