data class Prdouct(
    val name: String,
    var price: Double
)


fun main() {
    // 같은 클래스로 만들어진 두 개의 객체 생성
    val t1 = TestClass1(100, 200)
    val t2 = TestClass1(100, 200)

    // 두 객체의 equlas 비교
    if (t1 == t2) {
        println("t1과 t2는 같습니다.")
    } else {
        println("t1과 t2는 다릅니다.")
    }

    // 같은 데이터 클래스로 만들어진 두 개의 객체 생성
    val t3 = TestClass2(100, 200)
    val t4 = TestClass2(100, 200)

    // 두 데이터 클래스 객체의 equals 비교
    if (t3 == t4) {
        println("t3와 t4는 같습니다.")
    } else {
        println("t3와 t4는 다릅니다.")
    }

    // 데이터 클래스는 주생성자의 멤버변수의 값만 같으면 같다고 인식
    t3.a3 = 1000
    t4.a3 = 2000
    // 두 데이터 클래스 객체의 equals 비교
    if (t3 == t4) {
        println("t3와 t4는 같습니다.")
    } else {
        println("t3와 t4는 다릅니다.")
    }

    println("t1 : $t1")
    println("t3 : $t3")

    println("--------------------")

    val t100 = t3.copy()
    println("t3.a1 : ${t3.a1}")
    println("t100.a1 : ${t100.a1}")

    t100.a1 = 5000
    println("t3.a1 : ${t3.a1}")
    println("t100.a1 : ${t100.a1}")

    val t1000 = t3
    t3.a1 = 3000
    println("t1000.a1 : ${t1000.a1}") // data class도 역시 참조형이기 때문에 t1000.a1은 3000이 출력된다.

    println("-------------------------------------")
    // data class에 추가되는 메서드이다.
    // 주 생성자에 정의되어 있는 변수의 수 만큼 만들어지는 메서드이다.
    // 주 생성자에 정의되어 있는 첫 번째 변수의 값을 반환한다.
    val num1 = t3.component1()
    // 주 생성자에 정의되어 있는 두 번째 변수의 값을 반환한다.
    val num2 = t3.component2()
    println("num1 : $num1")
    println("num2 : $num2")

    // 객체 분해 : 주 생성자를 통해 정의된 맴버 변수의 값을 하나씩 추출하여
    // 좌측에 작성한 변수들에 순서대로 담아준다.
    // 이 때, componentN 메서드를 호출하여 반환하는 값을 담아준다.
    val (num10, num20) = t3
    println("num10 : $num10")
    println("num20 : $num20")
}

// 일반 클래스
class TestClass1(var a1: Int, var a2: Int) {
    var a3: Int = 0
}

// 데이터 클래스
data class TestClass2(var a1: Int, var a2: Int) {
    var a3: Int = 0
}