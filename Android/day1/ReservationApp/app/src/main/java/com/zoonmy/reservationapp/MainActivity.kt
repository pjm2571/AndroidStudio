package com.zoonmy.reservationapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var location: String = ""
    var date = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val buttonDate = findViewById<Button>(R.id.buttonDate)
        val buttonBook = findViewById<Button>(R.id.buttonBook)

        val locationList = listOf(
            "서울", "대구", "부산", "대전"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, locationList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                location = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(applicationContext, location, Toast.LENGTH_SHORT).show()
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
                    date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    buttonDate.text = date
                }, year, month, day)

            // 다이얼로그 표시
            datePickerDialog.show()

        }

        buttonBook.setOnClickListener {
            if (editTextName.text.isEmpty() || date.isEmpty() || location.isEmpty()) {
                Toast.makeText(applicationContext, "값을 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val userName = editTextName.text.toString()

            showDefaultDialog(userName, location, date)
        }
    }

    fun showDefaultDialog(userName: String, location: String, date: String) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("클럽 예약 완료")
        builder.setMessage("이름 : $userName \n지점 : $location\n예약일 : $date")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}