fun main() {
    val mutableMap = mutableMapOf("Jack" to 20, "Jason" to 18, "Jimmy" to 19)
    mutableMap += "Jacky" to 30
    //mutableMap.put("Jimmy", 22)
    mutableMap["Jimmy"] = 22
    mutableMap.getOrPut("Rose"){18}
    println(mutableMap)
}