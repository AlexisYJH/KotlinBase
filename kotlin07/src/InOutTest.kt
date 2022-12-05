//out协变
interface Production<out T> {
    fun product() : T
}

//in逆变
interface Consumer<in T> {
    fun consume(item : T)
}

//invariant不变
interface ProductionConsumer<T> {
    fun product() : T
    fun consume(item : T)
}

open class Food
open class FastFood: Food()
class Burger: FastFood()

class FoodStore: Production<Food> {
    override fun product(): Food {
        println("product Food")
        return Food()
    }
}

class FastFoodStore: Production<FastFood> {
    override fun product(): FastFood {
        println("product FastFood")
        return FastFood()
    }
}

class BurgerStore: Production<Burger> {
    override fun product(): Burger {
        println("product Burger")
        return Burger()
    }
}

class Everybody: Consumer<Food> {
    override fun consume(item: Food) {
        println("consume Food")
    }
}

class ModernPeople: Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("consume FastFood")
    }
}

class American: Consumer<Burger> {
    override fun consume(item: Burger) {
        println("consume Burger")
    }
}

fun main() {
    val production1 : Production<Food> = FoodStore()
    //java中不能将子类泛型对象赋值给父类泛型对象
    //ArrayList<Character> list = new ArrayList<String>();
    //子类泛型对象可以赋值给父类泛型对象，用out
    val production2 : Production<Food> = FastFoodStore()
    val production3 : Production<Food> = BurgerStore()

    //父类泛型对象可以赋值给子类泛型对象，用in
    val consumer1: Consumer<Burger> = Everybody()
    //不能使用父类Food,只能用FastFood或者子类Burger
    val consumer2: Consumer<Burger> = ModernPeople()
    //只能传Burger，但实际类型还是原来的类型，多态
    consumer2.consume(Burger()) //consume FastFood
    val consumer3: Consumer<Burger> = American()

}