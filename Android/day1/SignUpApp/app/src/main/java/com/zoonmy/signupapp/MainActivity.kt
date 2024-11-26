package com.zoonmy.signupapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var gen = ""
    var date = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val editText1 = findViewById<EditText>(R.id.editText1)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val buttonDate = findViewById<Button>(R.id.buttonDate)

        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        val genList = listOf("남자", "여자")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                gen = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(applicationContext, gen, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        buttonDate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_WEEK)

            // DatePickerDialog 생성
            val datePickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    // 선택한 날짜를 텍스트뷰에 표시
                    date = "${selectedYear}년${selectedMonth + 1}월${selectedDay}일"
                    buttonDate.text = date
                }, year, month, day)

            // 다이얼로그 표시
            datePickerDialog.show()

        }

        val listView = findViewById<ListView>(R.id.listView)

        val arrayList : ArrayList<String> = ArrayList<String>()
        val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = arrayAdapter

        buttonRegister.setOnClickListener {
            if (editText.text.isEmpty() || date.isEmpty() || gen.isEmpty() || editText1.text.isEmpty()) {
                Toast.makeText(applicationContext, "값을 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val name = editText.text.toString()
            val fighting = editText1.text.toString()
            arrayList.add(0, "${name} | ${gen} | ${date} | ${fighting}")
            arrayAdapter.notifyDataSetChanged()
        }
    }
}