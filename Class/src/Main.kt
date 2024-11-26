fun main() {
    val firstClass: FirstClass = FirstClass()
    println("First Class: $firstClass")

    val thirdClass: ThirdClass = ThirdClass()
    println("ThirdClass a: ${thirdClass.a}")
    println("ThirdClass b: ${thirdClass.b}")
    thirdClass.funA()

    thirdClass.b = 100

    val newClass: NewClass = NewClass()

}

class FirstClass

class ThirdClass() {
    // 멤버 변수
    val a = 0
    var b = 0

    // 멤버 메서드
    fun funA() {
        println("This is funA()")
    }
}