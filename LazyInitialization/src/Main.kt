fun main() {
    val obj1 = TestClass()
    println("obj1.a1: ${obj1.a1}")
    println("obj1.a2: ${obj1.a2}")
    obj1.testMethod()
    println("obj1.a4: ${obj1.a4}")
}

class TestClass {
    var a1 = 100
    var a2: Int
    lateinit var a3: String
    val a4: Int by lazy {
        println("a4 init")
        300
    }

    init {
        a2 = 100
    }

    fun testMethod() {
        if (!::a3.isInitialized) {
            a3 = "문자열"
        }
        println("a3: $a3")
    }
}