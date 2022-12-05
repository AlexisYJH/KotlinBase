infix fun String?.printWithDefault(default: String) = println(this ?: default)

fun main() {
    var nullableString : String? = null
    nullableString.printWithDefault("unknown")

    nullableString printWithDefault "abc"
}