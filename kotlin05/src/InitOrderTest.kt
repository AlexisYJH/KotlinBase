class Order(
    _name: String,
    val age: Int //1
){
    //2
    var name = _name
    var score = 100
    val subject: String

    //3
    init {
        println("init...")
        subject = "math"
    }

    //4
    val hobby = "coding"

    constructor(_name: String): this(_name, 18){
        //5
        score = 80
    }
}

fun main() {
    Order("Jack")
}

/*
public Order(@NotNull String _name, int age) {
    Intrinsics.checkNotNullParameter(_name, "_name");
    super();
    this.age = age;
    this.name = _name;
    this.score = 100;
    String var3 = "init...";
    System.out.println(var3);
    this.subject = "math";
    this.hobby = "coding";
}

public Order(@NotNull String _name) {
    Intrinsics.checkNotNullParameter(_name, "_name");
    this(_name, 18);
    this.score = 80;
}*/
