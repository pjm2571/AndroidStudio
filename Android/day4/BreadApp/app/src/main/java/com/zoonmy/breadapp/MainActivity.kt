package com.zoonmy.breadapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.zoonmy.breadapp.models.Bread
import com.zoonmy.breadapp.models.FishBread
import com.zoonmy.breadapp.models.FlowerBread

class MainActivity : AppCompatActivity() {
    private lateinit var getResult: ActivityResultLauncher<Intent>
    val breadList: MutableList<Bread> = mutableListOf()

    private lateinit var imageViews: ArrayList<ImageView>
    private lateinit var textViews: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // textViews 초기화
        val numberTextViewIds = arrayOf(
            R.id.textView0,
            R.id.textView1,
            R.id.textView2,
            R.id.textView3,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6,
            R.id.textView7,
            R.id.textView8
        )

        // imageViews 초기화
        val numberImageViews = arrayOf(
            R.id.imageView0,
            R.id.imageView1,
            R.id.imageView2,
            R.id.imageView3,
            R.id.imageView4,
            R.id.imageView5,
            R.id.imageView6,
            R.id.imageView7,
            R.id.imageView8
        )

        // textViews 설정
        textViews = ArrayList()
        for (id in numberTextViewIds) {
            val textView = findViewById<TextView>(id)
            textViews.add(textView)
        }

        // imageViews 설정
        imageViews = ArrayList()
        for (id in numberImageViews) {
            val imageView = findViewById<ImageView>(id)
            imageViews.add(imageView)
        }

        getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            // 결과값으로 bread 객체를 만든다.
            val data: Intent? = result.data
            val shape = data?.getStringExtra("shape")
            val sauce = data?.getStringExtra("sauce")
            var bread = if (shape == "붕어빵") FishBread() else FlowerBread()
            bread.shape = shape!!
            bread.sauce = sauce!!
            breadList.add(bread)

            for ((i, bread) in breadList.withIndex()) {
                when (bread.shape) {
                    "붕어빵" -> imageViews[i].setImageResource(R.drawable.fish)
                    "국화빵" -> imageViews[i].setImageResource(R.drawable.flower)
                }
                textViews[i].text = bread.sauce
            }

        }

        val buttonMake = findViewById<Button>(R.id.makeButton)
        buttonMake.setOnClickListener {
            val intent = Intent(this, MoldActivity::class.java)
            getResult.launch(intent)
        }

        val textViewToday = findViewById<TextView>(R.id.moneyView)
        val buttonSell = findViewById<Button>(R.id.saleButton)
        buttonSell.setOnClickListener {
            var earn = 0
            for (bread in breadList) {
                earn += bread.price
            }
            textViewToday.text = "${earn}원"

            breadList.clear()
            for (imageView in imageViews) {
                imageView.setImageDrawable(null)
            }
            for (textView in textViews) {
                textView.text = ""
            }
        }


    }
}