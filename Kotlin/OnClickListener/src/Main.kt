fun main() {
    val view1 = View("view1", 100, 200)
    val onClickListener1 = OnClickListener1()
    view1.registerOnClickListener(onClickListener1)
    view1.clicked()

    val view2 = View("view2", 300, 600)
    val onClickListener2 = OnClickListener2()
    view2.registerOnClickListener(onClickListener2)
    view2.clicked()
}

class OnClickListener1 : View.OnClickListener {
    override fun onClick(view: View) {
        println("안녕하세요. 저는 ${view.id} 입니다.")
    }
}

class OnClickListener2 : View.OnClickListener {
    override fun onClick(view: View) {
        println("Hello. I am ${view.id}.")
    }
}