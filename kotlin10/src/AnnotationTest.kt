@file:JvmName("Hello")

import java.io.IOException

fun greeting() = "Greetings"

class Spellbook{
    @JvmField
    val spells = listOf("Magic MS.L", "Lay on Hans")

    companion object{
        @JvmField
        val MAX_SPELL_COUNT = 10
        @JvmStatic
        fun getSpellbookGreeting() = println("I'm the Great Grimoire!")
    }
}

@JvmOverloads
fun showInfo(name: String, valid: Boolean = true) {
    println("showInfo: $name, $valid")
}

@Throws(IOException::class)
fun throwException() {
    throw IOException()
}
