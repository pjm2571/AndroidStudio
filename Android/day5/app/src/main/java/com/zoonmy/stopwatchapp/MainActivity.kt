package com.zoonmy.stopwatchapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var time = 0.0
    private val lap = mutableListOf<String>()
    private var running = false
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonPause = findViewById<Button>(R.id.buttonPause)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val buttonLap = findViewById<Button>(R.id.buttonLap)

        // ListView 가져오기
        val listView = findViewById<ListView>(R.id.listView)

        // ArrayAdapter 생성 및 설정
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lap)
        listView.adapter = adapter

        // handler 설정
        handler = Handler(Looper.getMainLooper())

        // runnable 정의
        /*
        * interface 상속을 통해 override 정의
        * */
        runnable = object : Runnable {
            override fun run() {
                if (running) {
                    time += 0.01
                    textView.text = String.format("%.2f", time)
                    handler.postDelayed(this, 10)
                }
            }
        }

        // start 버튼이 눌렸을 떄
        buttonStart.setOnClickListener {
            running = true
            handler.post(runnable)
        }

        // pause 버튼이 눌렸을 때
        buttonPause.setOnClickListener {
            running = false
        }

        // reset 버튼이 눌렸을 때
        buttonReset.setOnClickListener {
            running = false
            time = 0.0
            textView.text = String.format("%.2f", time)
            lap.clear() // 랩 타임 리스트 초기화
            adapter.notifyDataSetChanged() // 리스트뷰 업데이트
        }

        // lap 버튼이 눌렸을 때
        buttonLap.setOnClickListener {
            lap.add(String.format("%.2f", time)) // 랩 타임 추가
            adapter.notifyDataSetChanged() // 리스트뷰 업데이트
        }
    }
}