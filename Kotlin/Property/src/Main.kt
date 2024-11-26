fun main() {
    val obj = TestClass()
    obj.a1 = 1
    obj.a2 = 2
    obj.a3 = 3000
    println("obj a1: ${obj.a1}, obj a2: ${obj.a2}, obj a3: ${obj.a3}")
}

class TestClass{
    var a1: Int = 0
    var a2: Int = 0
    var a3: Int = 0
        get() {
            println("v3 get() 호출")
            return field
        }
        // get() == field 와 같음ㄴ
        set(value) {
            println("v3 set() 호출")
            field = value
        }
}