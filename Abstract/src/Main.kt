fun main() {
    val sub2 = Sub2()
    sub2.method1()
    sub2.method2()
}

abstract class Super2 {
    fun method1() {
        println("Super2 클래스의 method1()")
    }

    abstract fun method2()
}

