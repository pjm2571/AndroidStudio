package com.zoonmy.memoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)

        val listView : ListView = findViewById(R.id.listView)

        val arrayList : ArrayList<String> = ArrayList<String>()

        arrayList.add("memo 1")
        arrayList.add("memo 2")
        arrayList.add("memo 3")

        val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = arrayAdapter

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            arrayList.add(editText.text.toString())
            arrayAdapter.notifyDataSetChanged()
        }


    }
}