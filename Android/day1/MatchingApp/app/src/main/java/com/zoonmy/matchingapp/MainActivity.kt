package com.zoonmy.matchingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText1 = findViewById<EditText>(R.id.editText1)
        var editText2 = findViewById<EditText>(R.id.editText2)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if (editText1.text.isEmpty() || editText2.text.isEmpty()) {
                Toast.makeText(applicationContext, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }
            // user 이름 첫 글자 가져오기
            var char1: Char = editText1.text.toString()[0]
            var char2: Char = editText2.text.toString()[0]

            // 유니코드 번호로 변환
            var int1: Int = char1.code
            var int2: Int = char2.code

            // 두 값을 더해서 mod 연산
            val percentage = (int1 + int2) % 100


//            var percentage: Int = Random.nextInt(0, 101)
            Log.d("MainActivity", "매칭 확률은 $percentage% 입니다.")

            showDefaultDialog(editText1.text.toString(), editText2.text.toString(), percentage)
        }
    }

    fun showDefaultDialog(user1: String, user2: String, percentage: Int) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("커플 매칭확률")
        builder.setMessage("$user1 님과 $user2 님의 매칭 확률은 $percentage% 입니다.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}