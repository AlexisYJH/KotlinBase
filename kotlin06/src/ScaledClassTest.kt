//更复杂的ADT：密封类
//密封类可以有若干个子类，这些**子类必须和它定义在同一个文件里**。
sealed class LicenseStatus2 {
    //没有属性，用object代替class，单例
    object UnQualified : LicenseStatus2()
    object Learning : LicenseStatus2()
    class Qualified(val licenseId: String) : LicenseStatus2()
}

class Driver2(var status: LicenseStatus2) {
    fun checkLicense(): String {
        //不用使用else语句，且编译器会帮你检查代码处理是否有遗漏
        return when (status) {
            is LicenseStatus2.UnQualified -> "没资格"
            is LicenseStatus2.Learning -> "在学"
            is LicenseStatus2.Qualified -> "有资格, 驾驶证编号：${(status as LicenseStatus2.Qualified).licenseId}"
        }
    }
}

fun main() {
    println(Driver2(LicenseStatus2.Learning).checkLicense())
    println(Driver2(LicenseStatus2.Qualified("123456")).checkLicense())
}