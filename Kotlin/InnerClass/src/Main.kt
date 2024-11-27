fun main() {
    val obj1 = OuterClass()
    val obj2 = obj1.InnerClass()

    // 인터페이스를 구현한 클래스의 객체를 생성한다.
    val t1 = InterfaceClass()
    t1.interMethod1()
    t1.interMethod2()

    // 만약 인터페이스를 구현한 클래스를 가지고 객체를 딱 한번만 만들어서 사용하겠다면
    // 중첩 클래스를 사용할 수 있다.
    val t2 = object : Interface {
        override fun interMethod1() {
            println("익명 중첩 클래스의 innerMethod1")
        }

        override fun interMethod2() {
            println("익명 중첩 클래스의 innerMethod2")
        }
    }

    t2.interMethod1()
    t2.interMethod2()
}

class OuterClass {
    var outerValue = 100

    fun outerMethod() {
        println("outerMethod()")
    }

    inner class InnerClass {

        var innerValue = 200

        fun innerMethod() {
            // 외부 클래스에 정의한 맴버를 사용한다.
            // 내부클래스의 객체를 생성하기 위해서는 외부 클래스의 객체가 필요하다.
            // 이에 내부 클래스 입장에서는 외부 클래스의 객체가 생성되어 있다는 것을
            // 보장받을 수 있기때문에 맴버 사용이 가능하다.
            println("outerValue : $outerValue")
            outerMethod()
        }
    }
}

interface Interface {
    fun interMethod1()
    fun interMethod2()
}

// 인터페이스를 구현한 클래스를 작성한다.
class InterfaceClass : Interface {
    override fun interMethod1() {
        println("InterfaceClass의 interMethod1")
    }

    override fun interMethod2() {
        println("InterfaceClass의 interMethod2")
    }
}