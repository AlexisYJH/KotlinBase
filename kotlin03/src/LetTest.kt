fun main() {
    /*val firstItem =  listOf(3,2,1).first();
    val result = firstItem * firstItem;*/
    val result = listOf(3,2,1).first().let {
        it * it
    }
    println(result)

    println(formatGreeting("LILWEN"))
}

//链式调用风格
private fun formatGreeting(name: String?) : String{
    return name?.let {
        "Welcome, $name"
    }?: "What's your name?"
}

private fun formatGreeting2(name: String?) : String{
    return if(name != null) "Welcome, $name" else "What's your name?"
}
