fun main() {
    var obj1 = TestClass1()

    println("a1 : ${obj1.a1}")
    println("a2 : ${obj1.a2}")

    obj1.testMethod1()

    var obj2 = SuperClass(100)
    var obj3 = SubClass()
    obj3.subMethod()

}

class TestClass1(var a2: Int) {
    constructor() : this(3) {

    }

    var a1 = 100

    fun testMethod1() {
        var a1 = 200

        println("---- 테스트 메소드 시작 ----")
        println("지역변수 a1 : $a1")
        println("this 변수 a1 : ${this.a1}")


        fun testMethod2() {
            println("testMethod1 내부의 testMethod2()")
        }

        testMethod2()
        this.testMethod2()

        println("---- 테스트 메소드 종료 ----")
    }

    fun testMethod2() {
        println("testMethod2()")
    }

}

open class SuperClass(var a2: Int){
    open var a1 = 100

    open fun superMethod1(){
        println("SuperClass의 superMethod1()")
    }
}

class SubClass: SuperClass(200){
    override var a1 =  1000

    fun subMethod(){
        println("a1 : $a1")
        println("super.a1 : ${super.a1}")

    }
}
