// 代数数据类型：可以用来表示一组子类型的闭集
// 枚举类就是一种简单的ADT
enum class LicenseStatus {
    UNQUALIFIED,
    LEARNING,
    QUALIFIED;

    val licenseId : String? = null
}

class Driver(var status: LicenseStatus) {
    fun checkLicense(): String{
        //不用使用else语句，且编译器会帮你检查代码处理是否有遗漏
        return when(status) {
            LicenseStatus.UNQUALIFIED->"没资格"
            LicenseStatus.LEARNING->"在学"
            LicenseStatus.QUALIFIED->"有资格"
        }
    }
}

fun main() {
    println(Driver(LicenseStatus.LEARNING).checkLicense())
}