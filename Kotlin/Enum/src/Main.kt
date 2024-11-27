fun main(){
    printDirection1(DirectionClass.SOUTH)
    printDirection1(DirectionClass.EAST)

    printDirection2(DirectionEnum.SOUTH)
    printDirection2(DirectionEnum.EAST)

    val str1 = getDirectionString1(DirectionClass.SOUTH)
    println("str1 : $str1")

    val str2 = getDirectionString2(DirectionEnum.SOUTH)
    println("str2 : $str2")

    printNumber(Number.TWO)
}

class DirectionClass{
    companion object{
        val NORTH = 0;
        val SOUTH = 1;
        val WEST = 2;
        val EAST = 3;
    }
}

fun printDirection1(dir:Int){
    when(dir){
        DirectionClass.NORTH -> println("북쪽입니다")
        DirectionClass.SOUTH -> println("남쪽입니다")
        DirectionClass.WEST -> println("서쪽입니다")
        DirectionClass.EAST -> println("동쪽입니다")
    }
}

// 열거형 정의
enum class DirectionEnum{
    NORTH, SOUTH, WEST, EAST
}

fun printDirection2(dir:DirectionEnum){
    // enum class 타입으로 분기를 할 경우
    // 모든 값에 대한 경우를 구현하지 않으면 오류가 발생한다.
    when(dir){
        DirectionEnum.NORTH -> println("북쪽입니다")
        DirectionEnum.SOUTH -> println("남쪽입니다")
        DirectionEnum.WEST -> println("서쪽입니다")
        DirectionEnum.EAST -> println("동쪽입니다")
    }
}

fun getDirectionString1(dir:Int) = when(dir){
    DirectionClass.NORTH -> "북쪽입니다"
    DirectionClass.SOUTH -> "남쪽입니다"
    DirectionClass.WEST -> "서쪽입니다"
    DirectionClass.EAST -> "동쪽입니다"
    else -> "애매하네요"
}

fun getDirectionString2(dir:DirectionEnum) = when(dir){
    DirectionEnum.NORTH -> "북쪽입니다"
    DirectionEnum.SOUTH -> "남쪽입니다"
    DirectionEnum.WEST -> "서쪽입니다"
    DirectionEnum.EAST -> "동쪽입니다"
}

// 하나에 대해 여러가지 값으로 표현할 수 있는 경우(예 : 원소기호 - 원소기호, 원소이름, 원소번호)에 사용한다.
enum class Number(val num:Int, val str:String){
    ONE(1, "일"),
    TWO(2, "이"),
    THREE(3, "삼")
}

fun printNumber(v1:Number){
    when(v1){
        Number.ONE -> println("1 입니다")
        Number.TWO -> println("2 입니다")
        Number.THREE -> println("3 입니다")
    }

    when(v1.num){
        1 -> println("1 입니다")
        2 -> println("2 입니다")
        3 -> println("3 입니다")
    }

    when(v1.str){
        "일" -> println("1 입니다")
        "이" -> println("2 입니다")
        "삼" -> println("3 입니다")
    }
}