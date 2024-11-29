package com.autoever.jamanchu.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.autoever.jamanchu.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextEmail = findViewById<TextView>(R.id.editTextEmail)
        val editTextPW = findViewById<TextView>(R.id.editTextPW)
        val editTextNickname = findViewById<TextView>(R.id.editTextNick)
        val editTextIntroduction = findViewById<TextView>(R.id.editTextIntroduction)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val spinner = findViewById<Spinner>(R.id.spinner)

        // 문자열 배열 어댑터 생성
        ArrayAdapter.createFromResource(
            this,
            R.array.age_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // 드롭다운 레이아웃 설정
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // 어댑터 설정
            spinner.adapter = adapter
        }


    }
}