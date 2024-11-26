fun main() {
    val firstClass = FirstClass(100)
    val fourthClass = FourthClass(100, 200)
    val fourthClass2 = FourthClass(100)
}

class FourthClass(a1: Int, a2: Int) {
    init {
        println("FourthClass a1=$a1 a2=$a2")
    }

    constructor(a1: Int) : this(a1, 100) {
        println("보조 생성자 실행 a1:$a1")
    }
}

class FirstClass {
    // init 블록: 객체가 생성될 때 생성됨
    init {
        println("First Class init")
    }

    // 생성자
    constructor() {
        println("First Class constructor")
    }

    constructor(a1: Int) {
        println("First Class constructor() a1:$a1")
    }
}

// 주생성자 (기본 생성자)
class SecondClass constructor() {}

// 주생성자의 축약형
class ThirdClass() {}