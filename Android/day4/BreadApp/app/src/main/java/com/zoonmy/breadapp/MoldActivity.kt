package com.zoonmy.breadapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.zoonmy.breadapp.models.Bread
import com.zoonmy.breadapp.models.FishBread
import com.zoonmy.breadapp.models.FlowerBread

class MoldActivity : AppCompatActivity() {
    var fishBread = false
    var bread: Bread = Bread() // nullable 타입으로 설정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mold)

        // 컴포넌트 초기화
        val imageView = findViewById<ImageView>(R.id.imageView)
        val radioGroupMold = findViewById<RadioGroup>(R.id.radioGroupMold)
        val radioButtonFish = findViewById<RadioButton>(R.id.radioButtonFish)
        val radioButtonFlower = findViewById<RadioButton>(R.id.radioButtonFlower)
        val radioGroupSauce = findViewById<RadioGroup>(R.id.radioGroupSauce)
        val radioButtonBean = findViewById<RadioButton>(R.id.radioButtonBean)
        val radioButtonCream = findViewById<RadioButton>(R.id.radioButtonCream)
        val buttonMake = findViewById<Button>(R.id.buttonMake)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)

        // 몰드 선택 라디오 버튼
        radioButtonFish.setOnClickListener {
            imageView.setImageResource(R.drawable.fish_mold)
            bread.shape = "붕어빵"
        }
        radioButtonFlower.setOnClickListener {
            imageView.setImageResource(R.drawable.flower_mold)
            bread.shape = "국화빵"
        }

        // 소스 선택 라디오 버튼
        radioButtonBean.setOnClickListener {
            bread.sauce = "팥앙금"
        }
        radioButtonCream.setOnClickListener {
            bread.sauce = "슈크림"
        }

        // 만들기 버튼
        buttonMake.setOnClickListener {
            // 결과를 반환하는 코드
            val resultIntent = Intent()
            resultIntent.putExtra("shape", bread.shape) // 결과 데이터를 인텐트에 담기
            resultIntent.putExtra("sauce", bread.sauce) // 결과 데이터를 인텐트에 담기
            setResult(Activity.RESULT_OK, resultIntent) // 결과 코드와 인텐트 설정
            finish() // 액티비티 종료
        }

    }
}