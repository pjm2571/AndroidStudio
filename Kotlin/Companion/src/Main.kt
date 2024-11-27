fun main() {
}


class TestClass1 {
    var a1 = 10

    fun testMethod1(){
        println("testMethod1")
        // 일반 맴버 변수 사용
        println("testMethod1 - a1 : $a1")
        // 정적 맴버 변수 사용
        println("testMethod1 - a2 : $a2")
    }

    // companion object 정의
    companion object{
        var a2 = 200
        // @JvmStatic : companion 맴버를 자바에서 사용할 때 Companion를 클래스를 거치지 않고
        // 직접 사용할 수 있도록 할 수 있다.
        @JvmStatic var a3 = 300

        fun testMethod2(){
            println("testMethod2")
            // 정적 맴버 변수 사용
            println("testMethod2 - a2 : $a2")
        }

        @JvmStatic fun testMethod3(){
            println("testMethod3")
        }
    }
}