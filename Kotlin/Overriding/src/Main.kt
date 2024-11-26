fun main() {

    println("---- 서브 클래스 ---- ")

    val obj3: SubClass2 = SubClass2()
    obj3.superMethod2()
    println("---- 슈퍼 클래스 ----")

    val obj4: SuperClass2 = SuperClass2()
    obj4.superMethod2()


}

open class SuperClass2 {
    open fun superMethod2(){
        println("SuperClass2의 superMethod2()")
    }
}

class SubClass2: SuperClass2() {
    override fun superMethod2() {
        println("SubClass2의 superMethod2")
    }
}


open class SuperClass1 {
    var superA1 = 100
    fun superMethod1() {
        println("SuperClass1의 superMethod1()")
    }
}

class Subclass1 : SuperClass1() {
    var subA1 = 200
    fun subMethod1() {
        println("SubClass1의 subMethod1()")
    }
}

