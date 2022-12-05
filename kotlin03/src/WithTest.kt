fun main() {
    val result1 = "The people's Republic Of China.".run {
        length >= 10
    }
    val result2 = with("The people's Republic Of China."){
        length >= 10
    }
}