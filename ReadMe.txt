《Kotlin基础》

$$kotlin01
----------变量常量与类型----------
Hello.kt
- 声明变量和内置数据类型
- 可修改变量和只读变量
- 类型推断：
    对于已声明并赋值的变量，允许省略类型定义
- 编译时常量：
    只能在函数外定义，只能是常见的基本数据类型
- 查看Kotlin字节码：
    1)Shift键两次，输入Show kotlin
    2)Tools->Kotlin->Show Kotlin Bytecode
- Kotlin的引用类型
    Java有两种数据类型：引用类型和基本数据类型
    Kotlin只提供引用类型，出于更高性能的需要，Kotlin编译器会在Java字节码中改用基本数据类型

----------条件语句----------
Condition.kt
- 表达式：
    if/else if表达式
    range表达式：in A..B
    when表达式：只要代码包含else if分支，都建议改用when

StringTemplate.kt
- string模板
    在字符串引号内放入变量值
    字符串里计算表达式的值并插入结果

----------函数----------
Function.kt
- 函数头
- 函数参数默认值参
- 具名函数参数
- Unit函数：没有返回值的函数，也就是说他们的返回类型是Unit
- Nothing类型：TODO函数的任务就是抛出异常，返回Nothing类型
    public inline fun TODO(reason: String): Nothing = throw NotImplementedError("An operation is not implemented: $reason")

SpecialFunc.kt
- 反引号中的函数名：使用空格和特殊字符对函数命名，函数名用一对反引号括起来，支持Kotlin和Java互操作，避免冲突（不同的保留关键字）

$$kotlin02
----------匿名函数----------
AnonymousFunc.kt
- 匿名函数：匿名函数通常整体传递给其他函数，或者从其他函数返回；使用匿名函数给标准函数制定规则
- 函数类型：函数的类型，由传入的参数和返回值类型决定
- 隐式返回: 自动返回函数体最后一行语句的结果
- 函数参数：参数的类型放在匿名函数的类型定义中，参数名放在函数定义中
- it关键字：只有一个参数，用it来表示参数名
- 类型推断：
    定义一个变量时，若把匿名函数作为变量赋值给它，不需要显示指明变量类型（返回值的类型推断）
    带参的匿名函数的参数名和类型必须有（参数的类型推断）

----------lambda----------
- lambda
将匿名函数称为lambda，将它的定义称为lambda表达式，它返回的数据称为lambda结果
lambda也可以用希腊字符λ表示，是lambda演算的简称，是一套数理演算逻辑，由数学家Alonzo Church(阿隆佐.丘齐)于20世纪30年代发明，在定义匿名函数时，使用了lambda演算记法。

AnonymousFunc2.kt
- 定义参数是函数的函数

AnonymousFunc3.kt
- 简略写法：若一个函数的lambda参数排在最后，或者是唯一的参数，那么括住lambda值参的一对圆括号可以省略

- 函数内联
在JVM上，你定义的lambda会以对象实例的形式存在， JVM会为所有同lambda打交道的变量分配内存，这就产生了内存开销，带来严重的性能问题。
Kotlin有一种优化机制叫内联，有了内联，JVM就不需要使用lambda对象实例了，因而避免了变量内存分配。哪里需要lambda，编译器会将**函数体复制粘贴**到哪里。（类似C/C++语言中预编译指令的宏定义（宏替换））
使用lambda的**递归函数无法内联**，因为会导致复制粘贴无限循环，编译会发出警告。

PassingFunReference.kt
- 函数引用
要把函数作为参数传给其他函数使用，除了lambda表达式，可以传递函数引用，函数引用可以把一个具名函数转换成一个值参，**使用lambda表达式的地方，都可以使用函数引用**。

----------闭包----------
Closure.kt
- 函数类型作为返回类型
- 闭包
在Kotlin中，匿名函数能修改并引用定义在自已作用域之外的变量，匿名函数引用着定义自身的函数里的变量，**Kotlin中的lambda就是闭包**。（相当于Java中的Package，作用域）
能接收函数或者返回函数的函数又叫做高级函数，高级函数广泛应用于函数式编程当中。

JavaAnonymousClass.java
- lambda与匿名内部类
为什么要在代码中使用函数类型？函数类型能让开发者**少写模式化代码，写出更灵活的代码**。
Java8支持面向对象编程和lambda表达式，但不支持将函数作为参数传给另一个函数或变量，不过Java的替代方案是**匿名内部类**。

$$kotlin03
----------null----------
NullSafe.kt
- null：提前在编译期强迫我们重视起来
- 可空性：除非另有规定，变量不可为null值
- Kotlin的null类型：为了避免NullPointException，Kotlin的做法是不让给非空类型变量赋null值，但null在Kotlin中依然存在
- null安全：Kotlin区分可空类型和非可空类型，不允许在可空类型值上调用函数，除非**主动接手安全管理**
    1）安全调用操作符：?. 遇到null值跳过函数调用
    使用带let的安全调用：let函数的主要作用是在指定的作用域内定义一个或多个变量
    2）非空断言操作符：!!.又称感叹号操作符，遇到null值抛KotlinNullPointException
    3）使用if判断null值情况：相比之下安全操作符更灵活简洁，可以进行多个函数的链式调用
- 空合并操作符：?: 如果左边的值为null，就使用右边的结果值；可以和let函数一起使用代替if/else语句

----------异常----------
ExceptionFix.kt
- 抛出异常，自定义异常，处理异常

----------先决条件函数----------
- 先决条件函数：kotlin标准库提供了一些便利函数，可以抛出带自定义信息的异常，可以用它定义先决条件，条件必须满足，目标代码才能执行
    checkNotNull：参数为null，抛出IllegalStateException，否则返回非null值
    require：参数为false，抛出IllegalArgumentException
    requireNotNull：参数为null，抛出IllegalStateException，否则返回非null值
    error：参数为null，抛出IllegalStateException并输出错误信息，否则返回非null值
    assert：参数为false，抛出AssertError，并打上断言编译器标记

----------字符串操作----------
StringText.kt
- subString：字符串截取，支持IntRange类型的参数，until创建的范围不包括上限值
- split：返回List集合数据，List集合支持**解构语法特性**，解构常用来简化变量的赋值
- replace：字符串替换
- 字符串比较：
    kotlin中，==检查两个字符串中的字符是否匹配，===检查两个变量是否指向内存堆上同一个对象
    java中，==引用计较，equals结构比较
- forEach：遍历字符

----------数字类型----------
NumberConvert.kt
- 数字类型：和Java一样，所有数字类型都有符号，即既可以表示正数，也可以表示负数。
    Byte,Short,Int,Long,Float,Double
- 安全转换函数：toIntOrNull()
- Double类型格式化："%.2f".format(8.956756)
- Double转Int：toInt(), roundToInt()

----------标准库函数----------
ApplyTest.kt LetTest.kt RunTest.kt WithTest.kt AlsoTest.kt TakeIfTest.kt
- apply（常用）：可看作一个配置函数，可以传入一个接收者，然后调用一系列函数来配置它，如果提供lambda给apply函数执行，它会返回配置好的接收者
    变量名省掉了，这是因为，在lambda表达式里，apply能让每个配置函数都作用于接收者，这种行为又叫做**相关作用域**，或者说，它们是针对接收者的**隐式调用**
- let（常用）：let函数能使某个变量作用于其lambda表达式中，让it关键字能引用它。
    let与apply比较，let会把接收者传给lambda，而apply什么都不传，匿名函数执行完，**apply会返回当前接收者，而let会返回lambda的最后一行**。
- run（常用）：光看作用域行为，run和apply差不多，但与apply不同，run**返回的是lambda结果**
    run也能执行函数引用，便于链式调用
- with：是run的变体，值参作为其第一个参数传入
- also：和let功能相似，和let一样，also也把接收者作为值参传给lambda，但不同的是also返回接收者对象，而let返回lambda结果
    适合针对同一原始对象，基于原始接收者对象执行额外的链式调用
- takeIf：需要判断lambda中提供的条件表达式，true返回接收者对象，false返回null
    适合需要判断某个条件是否满足，再决定是否可以赋值变量或执行某项任务，类似if语句，但优势是可直接在对象实例上调用，避免临时变量赋值的麻烦
- takeUnless：takeIf辅助函数takeUnless，false返回接收者对象，true返回null

$$kotlin04
- 集合：List,Set,Map类型的变量分为两类，只读和可变
----------List----------
ListTest.kt MutableListTest.kt ForEachListTest.kt
- List创建：listOf
- 元素获取：getOrElse,getOrNull安全索引取值函数
- 可变列表：mutableListOf
    toList(),toMutableList()相互转换
- mutator函数：
    能修改可变列表的函数有一个统一的名字：mutator函数
    添加与删除元素运算符
    基于lambda表达式指定的条件删除元素
- 集合遍历
    for in
    forEach
    forEachIndexed
- 解构：通过_符号过滤不想要的元素

----------Set----------
SetTest.kt
- Set创建：setOf
- 元素获取：elementAt, elementAtOrElse, elementAtOrNull
- 可变集合：mutableSetOf
- 集合转换
    把List转换成Set，去除重复元素
    快捷函数distinct

----------数组类型----------
ArrayTypeTest.kt
Kotlin提供各种Array，虽然是引用类型，但可以编译成Java基本数据类型
数组类型：IntArray,DoubleArray,LongArray,ShortArray,ByteArray,FloatArray,BooleanArray,Array
创建函数：intArrayOf,doubleArrayOf,..., arrayOf

----------Map----------
MapTest.kt MutableMapTest.kt
- Map创建：mapOf, to是个省略了点号和参数的特殊函数，to函数将左右两边的值转换成一对Pair
- 元素获取：
    []取值运算符，读取键对应的值，如果键不存在就返回null
    getValue，读取键对应的值，如果键不存在就抛出异常
    getOrElse，读取键对应的值，或者使用匿名函数返回默认值
    getOrDefault，读取键对应的值，或者返回默认值
- 遍历: forEach
- 可变集合：mutableMapOf, getOrPut

$$kotlin05
----------定义类----------
ClassDefinitionTest.kt
- field：针对定义的每一个属性，Kotlin都会产生一个field、一个getter、一个setter，field用来存储属性数据，
你不能直接定义field，Kotlin会封装field，保护它里面的数据，只暴露给getter和setter使用。
每个属性都有getter方法，只有可变属性才有setter方法，在需要控制如何读写属性数据时，可以自定义
- 计算属性：通过一个覆盖的get或set运算符来定义，这时field就不需要了
- 防范竞态条件：如果一个类属性可空又可变，那么引用它之前必须保证它非空，一个办法是使用also标准函数

----------初始化----------
ConstructorTest.kt
- 主构造函数
在类的定义头中定义一个主构造函数，使用临时变量为类的各个属性提供初始值，在Kotlin中，为便于识别，临时变量（包括仅引用一次的参数），通常以**下划线开头的名字命名**

ConstructorTest2.kt
- 在主构造函数里定义属性
- 次构造函数：多个次构造函数来配置不同的参数组合；初始化代码逻辑

InitTest.kt
- 默认参数
- 初始化块：在构造类实例时执行

InitOrderTest.kt
- 初始化顺序：
    1）主构造函数里声明的属性
    2）类级别的属性赋值
    2）init初始化块里的属性赋值和函数调用
    这两个按代码位置先后顺序
    3）次构造函数里的属性赋值和函数调用

LateInitTest.kt
- 延迟初始化：lateinit：在用它之前负责初始化；isInitialized检查
- 惰性初始化：by lazy 可以暂时不初始化某个变量，直到首次使用它

InitTrapTest.kt
- 初始化陷阱：属性被使用时必须保证已经完成初始化，注意顺序
    使用初始化块时，顺序非常重要，必须保证块中的所有属性已经完成初始化
    属性被使用时，必须保证使用到的属性已经完成初始化
    一个属性的初始化使用了其他属性时，必须保证使用到的属性已经完成初始化

$$kotlin06
----------继承----------
ExtendTest.kt
- 继承：类默认封闭，开放open关键字修饰
- 函数重载：父类函数open修饰，子类override修饰
- 类型检测：is
- Kotlin层次：所有类的超类Any（Any类下的方法在不同平台有不同的实现）
- 类型转换：as
- 智能类型转换：转一次以后，后面不需要转，直接使用

----------对象----------
SingletonTest.kt SingletonTest2.kt SingletonTest3.kt
- object关键字：使用object关键字，可以定义一个只能产生一个实例的类-单例
三种方式：
    1）对象声明：object修饰类
        object ApplicationConfig{}
    2）对象表达式：只需用一次，用完就丢的类实例，连命名都可以省了。这个对象表达式是XX的子类，这个匿名类一旦实例化只有唯一实例
        val player = object : Player() {override fun load() = "anonymous class load..."}
    3）伴生对象：一个类只能有一个伴生对象
        open class ConfigMap{companion object{}}

InnerClassTest.kt
- 嵌套类：如果一个类只对另一个类有用

DataClassTest.kt
- 数据类：
    专门设计用来存储数据的类；
    提供了toString, equals和hashCode的个性化实现；
    == 比较内容，equals，Any默认实现===，比较引用
    === 比较引用

- copy：数据类提供用来复制一个对象，**只复制主构造函数中定义的属性**

DeconstructionTest.kt
- 解构声明：后台实现就是声明component1、component2等若干个组件函数，每个函数负责管理你想返回的一个属性数据
    数据类自动为定义在主构造函数的属性添加对应的组件函数

- 使用数据类的条件：
    数据类必须至少带一个参数的主构造函数
    数据类主构造函数的参数必须是val或var
    数据类不能使用abstract、open、sealed、inner修饰符

EnumClassTest.kt EnumClassTest2.kt
- 枚举类：用来定义常量集合的一种特殊类，也可以定义函数

OperatorOverloadingTest.kt
- 运算符重载
    如要将内置运算符用在自定义类上，必须重写运算符函数
        operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
    操作符 函数名
    +   plus
    +=  plusAssign
    ==  equals
    >   compareTo
    []  get
    ..  rangeTo
    in  contains

AlgebraicDataType.kt
- 代数数据类型：可以用来表示一组子类型的闭集，枚举类就是一种简单的ADT（枚举类，密封类都是ADT）

ScaledClassTest.kt
- 密封类：对于更复杂的ADT，可以使用密封类，密封类可以用来定义类似枚举类的ADT，但可以更灵活地控制某个子类型
    密封类可以有若干个子类，这些**子类必须和它定义在同一个文件里**。

----------接口----------
InterfaceTest.kt
- 接口定义： 接口属性和函数实现都要使用override，接口中定义的函数不需要open修饰，默认open
- 默认实现： 可以在接口里提供默认属性的getter方法和函数实现

----------抽象类----------
AbstractClassTest.kt
- 抽象类：abstract class

----------泛型----------
GenericClassTest.kt
- 定义泛型类：
    泛型类的构造函数可以接受任何类型
    MagicBox类指定的泛型参数由一对<>里的字母T表示，T是个代表item类型的占位符。MagicBox类接受任何类型的item作为主构造函数值
    class MagicBox<T>(item: T) {
    泛型参数通常用字母T(代表英文Type)表示

GenericFuncTest.kt
- 泛型函数: 泛型参数也可以用于函数
    fun fetch(): T?{

MultiGenericParams.kt
- 多泛型参数：泛型函数和泛型类可以有多个泛型参数
    fun <R> fetch(subjectModFunction:(T) -> R) : R? {

GenericTypeConstraint
- 泛型类型约束：指定类型
    class MagicBox<T : Human>(item: T) {

VarargAndGet.kt
- vararg关键字和get函数
    MagicBox能放任何类型的Human实例，但一次只能放一个，要放多个实例要用vararg
    class MagicBox<T : Human>(vararg item: T) {
        private var subject: Array<out T> = item
        fun fetch(index:Int): T?{return subject[index].takeIf { available }}
    }
- []操作符取值：重载get函数

InOutTest.kt
- out（协变）：泛型类只将泛型类型作为函数的返回（输出），使用out，可称为生产类/接口
- in（逆变）：泛型类只将泛型类型作为函数的入参（输入），使用in，可称为消费类/接口
- invariant（不变）：泛型类将泛型类型作为函数参数和函数输出，不用out和in
- 为什么使用in&out? （父-in->子-out->父）
    父类泛型对象可以赋值给子类泛型对象，用in
    子类泛型对象可以赋值给父类泛型对象，用out

ReifiedTest.kt
- reified：帮助检查泛型参数类型（必须和inline一起使用），保存泛型类型
    Kotlin不允许对泛型参数T做类型检查，因为泛型参数类型会被类型擦除，即T的类型信息在运行时是不可知的，即is T写法错误
    inline fun <reified T> randomOrBackup(backup: () -> T) : T {

$$kotlin08
----------扩展----------
- 扩展可以在不直接修改类定义的情况下增加类功能。适用于无法解除某个类定义，或者某个类没有open无法继承

ExtensionFunc.kt
- 定义扩展函数：需指定接收者类型
    fun Any.easyPrint() = println(this)

GenericExtensionFunc.kt
- 泛型扩展函数：支持任何类型的接收者，并保留了接收者的类型信息
    fun <T> T.easyPrint() : T{
        println(this)
        return this
    }
    泛型扩展函数在标准库里随处可见，如let函数，被定义成了泛型扩展函数，
    所以能支持任何类型，它接收一个lambda表达式，这个lambda表达式接收者T作为值参，返回R-lambda表达式返回的任何新类型
    public inline fun <T, R> T.let(block: (T) -> R): R {
        return block(this)
    }

ExtensionField.kt
- 扩展属性

ExtensionNullableClass.kt
- 可空类扩展
- infix关键字：适用于有单个参数的扩展和类函数（to函数）

IterableExt.kt
ExtensionFile.kt
- 定义扩展文件：扩展函数需要在多个文件里使用，可以将它定义在单独的文件，然后import
- 重命名扩展： as
- Kotlin标准库中的扩展：包含类扩展的标准文件通常以类名加s后缀来命名，如Maps.kt

DSLTest.kt
- 带接收者的函数字面量
    apply函数时如何做到支持接收者对象的隐式调用的。（泛型的扩展函数）1）扩展函数里自带了接收者对象的this的隐式调用；2）泛型支持任何类型
    public inline fun <T> T.apply(block: T.() -> Unit): T { //() -> Unit是匿名函数，T是接收者
        block()
        return this
    }

- DSL（领域特定语言），一种API编程范式，暴露接收者的函数和特性，以便使用你定义的lambda表达式来读取和配置它们。

$$kotlin09
----------函数式编程----------
- 函数式编程：基于抽象数学的λ验算发展而来的函数式编程范式，主要依赖于高阶函数（以函数为参数或返回函数）返回的数据
- 函数类别：一个函数式应用通常由三大类函数构成：变换transform、过滤filter、合并combine。每类函数针对集合数据类型设计，目标是产生一个最终的结果。函数式编程用到的函数都是可组合的。

FunctionalTest.kt
- 变换：遍历集合内容，用传入的变换器函数，变化每一个元素，返回包含已修改元素的集合。
    最常用map, flatMap（多个集合中的元素合并）
    函数式编程范式支持的设计理念就是不可变数据的副本在链上的函数间传递

FunctionalTest2.kt
- 过滤：过滤函数接受一个predicate函数，用它按给定条件检查接收者集合里的元素并给出true或false的判定。predicate返回true，受检元素添加到返回的新集合里，false移出新集合
    filter
    //求素数：除了1和本身，并不能被任何数整除的数
    val nums = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = nums.filter { num ->
        //num: 7, 4, ...; it: [2: num)比如[2:7)[2:4)
        (2 until num).map { num % it }
            //取模为0，说明能整除，如果没有一个为0，说明是素数
            .none {it == 0}
    }

FunctionalTest3.kt
- 合并：将不同的集合合并成一个新集合。
    zip，返回一个包含键值对的新集合
    fold，接受一个初始累加器值，随后会根据匿名函数的结果更新

FunctionalTest4.kt VS FunctionalTest.java
- 为什么要使用函数式编程
    累加变量都是隐式的
    函数运算结果会自动复制给累加变量，降低代码出错的机会
    执行新任务很容易添加到函数调用链上，因为他们都兼容iterable类型

SequenceTest.kt
- 序列
    及早集合，List, Set, Map这几个集合类型统称为及早集合。任何一个实例在创建后，包含的元素都会被加入并允许访问
    惰性集合，集合元素是按需产生的。
    kotlin内置惰性集合类型：序列Sequence，序列不会索引排序它的内容，也不记录元素数目，序列里的值可能有无限多。
    序列构造函数generateSequence，接受一个初始种子值作为序列的起步值，在用generateSequence定义的序列上调用一个函数时，generateSequence函数会调用你指定的迭代器函数，决定下一个要产生的值

$$kotlin10
----------Kotlin与Java互操作----------
Hello.kt
- 互操作性与可空性：java里所有对象都可能为null
- 类型映射：代码运行时，所有的映射类型都会重新映射回对应的Java类型
- 属性访问：赋值语法代替setter方法

AnnotationTest.kt
- @JvmName：指定编译类的名字
    Hello.kt默认编译类的名字为HelloKt；@file:JvmName("Hello")
- @JvmField：暴露属性给java，避免使用getter
- @JvmOverloads：重载
- @JvmStatic：直接调用伴生对象里的函数
- @Throws：抛出一个需要检查的指定异常
- 函数类型：Kotlin函数类型使用FunctionN这样的名字的接口来表示，FunctionN中的N代表值参数目。
这样的Function接口有23个，从Function0到Function22，每一个FunctionN都包含一个invoke函数，用于调用函数类型函数。
    //添加一个translator的函数类型，接收一个字符串，将其改为小写字母，再大写第一个字符，最后打印结果。
    val translator = { text: String ->
        println(text.toLowerCase().capitalize())
    }
    //java
    Function1<String, Unit> translator = HelloKt.getTranslator();
    translator.invoke("TRUE");

- Android开发使用Kotlin：创建Kotlin文件，配置Kotlin环境