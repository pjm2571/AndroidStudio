fun main() {
    val t1 = TestClass1<Int>()
    t1.testMethod1(100)

    val t2 = TestClass1<String>()
    t2.testMethod1("안녕하세요")

    println("--------------------")
// 불변성 : 객체를 생성할 때 설정한 제네릭과 같은 변수에 담을 수 있다.
    // 클래스간의 상속 관계에 상관없이 제네릭에 설정한 클래스 타입이 다르면 오류가 발생한다.
    val t5: TestClass3<SubClass1> = TestClass3<SubClass1>()
    // 변수의 타입에 제네릭을 설정하였기 때문에 생략이 가능하다.
    // val t5:TestClass3<SubClass1> = TestClass3()
    // val t6:TestClass3<SuperClass1> = TestClass3<SubClass1>()
    // val t7:TestClass3<SubClass2> = TestClass3<SubClass1>()

    // 공변성 : 변수에 설정한 제네릭이 객체를 생성했을 때 사용한 제네릭과 같거나
    // 부모 클래스인 경우 담을 수 있다.
    val t8: TestClass4<SubClass1> = TestClass4<SubClass1>()
    val t9: TestClass4<SuperClass1> = TestClass4<SubClass1>()
    // val t10:TestClass4<SubClass2> = TestClass4<SubClass1>()

    // 반 공변성 : 변수에 설정한 제네릭이 객체를 생성했을 때 사용한 제네릭과 같거나
    // 자식 클래스인 경우에 담을 수 있다.
    val t11: TestClass5<SubClass1> = TestClass5<SubClass1>()
    // val t12:TestClass5<SuperClass1> = TestClass5<SubClass1>()
    val t13: TestClass5<SubClass2> = TestClass5<SubClass1>()
}

class TestClass1<T> {
    val a1: T? = null
    fun testMethod1(a1: T) {
        println("a1 : $a1")
    }
}

class TestClass2<A, B, C, D>(var a1: A, var a2: B) {

    fun testMethod3(a3: C, a4: D) {
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
        println("a4 : $a4")
    }
}

open class SuperClass1

open class SubClass1 : SuperClass1()

class SubClass2 : SubClass1()

// 불변성 (제네릭에 키워드를 붙히지 않는다)
class TestClass3<T>

// 공변성
class TestClass4<out A>()

// 반 공변성
class TestClass5<in A>()