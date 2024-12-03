package com.autoever.hyundaicarapp.activities

import android.os.Bundle
import com.autoever.hyundaicarapp.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.autoever.hyundaicarapp.models.Car

class MainActivity : AppCompatActivity() {

    private val carList = mutableListOf<Car>() // 차량 리스트
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextCarName: EditText
    private lateinit var buttonAdd: Button

    private var editModeCar: Car? = null // 수정 모드에서 현재 편집 중인 차량

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editTextCarName = findViewById(R.id.editTextCarName)
        buttonAdd = findViewById(R.id.buttonAdd)

        carAdapter = CarAdapter(carList,
            onDeleteClick = { car ->
                carList.remove(car)
                carAdapter.notifyDataSetChanged()
            },
            onEditClick = { car ->
                editModeCar = car
                editTextCarName.setText(car.name)
                buttonAdd.text = "수정"
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = carAdapter

        buttonAdd.setOnClickListener {
            val carName = editTextCarName.text.toString()
            if (carName.isNotEmpty()) {
                if (editModeCar == null) {
                    // 추가
                    val newCar = Car(id = carList.size + 1, name = carName)
                    carList.add(newCar)
                } else {
                    // 수정
                    editModeCar?.name = carName
                    editModeCar = null
                    buttonAdd.text = "추가"
                }
                editTextCarName.text.clear()
                carAdapter.notifyDataSetChanged()
            }
        }
    }
}

class CarAdapter(
    private val carList: List<Car>,                // 차량 리스트
    private val onDeleteClick: (Car) -> Unit,      // 삭제 콜백
    private val onEditClick: (Car) -> Unit         // 수정 콜백
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    // 뷰 홀더 클래스
    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName: TextView = itemView.findViewById(R.id.textCarName)
        val deleteButton: Button = itemView.findViewById(R.id.buttonDelete)
        val editButton: Button = itemView.findViewById(R.id.buttonEdit)
    }

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    // 뷰 홀더와 데이터 연결
    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.carName.text = car.name

        holder.deleteButton.setOnClickListener { onDeleteClick(car) }
        holder.editButton.setOnClickListener { onEditClick(car) }
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int = carList.size
}
