fun main() {
    val map = mapOf("Jack" to 20, "Jason" to 18, "Jimmy" to 19)
    println(map)
    //mapOf(Pair("Jimmy", 19), Pair("Jason",18))

    println(map["Jack"])
    //null
    println(map["Rose"])
    println(map.getValue("Jack"))
    //NoSuchElementException
    //println(map.getValue("Rose"))
    println(map.getOrElse("Rose"){"Unknown"})
    println(map.getOrDefault("Rose", 0))

    map.forEach {
        println("${it.key}, ${it.value}")
    }
    map.forEach { (key:String, value:Int) ->
        println("$key, $value")
    }
}