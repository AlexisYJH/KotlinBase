import java.lang.Exception
import java.lang.IllegalArgumentException

fun main() {
    var number:Int? = null

    //处理异常
    try {
        checkOperation(number)
        number!!.plus(1)
    }catch (e: Exception) {
        println(e)
    }
}

fun checkOperation(number: Int?) {
    //抛出异常
    //number ?: throw UnskilledException()
    //先决条件函数
    checkNotNull(number,{"Something is null."})
}

//自定义异常
class UnskilledException() : IllegalArgumentException("操作不当")