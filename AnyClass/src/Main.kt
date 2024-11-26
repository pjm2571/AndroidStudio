fun main() {
    val obj1 = TestClass1()
    println("obj1: $obj1")

    val obj2 = TestClass2()
    testFun1(obj2)
}

class TestClass1 {
    override fun toString(): String {
        return "TestClass1의 객체입니다."
    }
}

class TestClass2 {
    override fun toString(): String {
        return "TestClass2의 객체입니다."
    }
}

fun testFun1(a1: Any) {
    println("a1 : $a1")
}