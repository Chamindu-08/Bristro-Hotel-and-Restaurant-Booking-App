package com.nibm.bristrohotelandrestaurantbookingapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var roomCount = 1  // Initial number of rooms
    private var peopleCount = 1  // Initial number of people

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Enable edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Date Picker functionality
        val datePickerEditText: EditText = findViewById(R.id.datePickerEditText)
        val timePickerEditText: EditText = findViewById(R.id.timePickerEditText)

        datePickerEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                datePickerEditText.setText(selectedDate)
            }, year, month, day)

            datePickerDialog.show()
        }

        // Time Picker functionality
        timePickerEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                timePickerEditText.setText(selectedTime)
            }, hour, minute, true)

            timePickerDialog.show()
        }

        // Room Count functionality (Increase/Decrease)
        val roomCountText: TextView = findViewById(R.id.roomCountText)
        val increaseRoomButton: Button = findViewById(R.id.increaseRoomButton)
        val decreaseRoomButton: Button = findViewById(R.id.decreaseRoomButton)

        increaseRoomButton.setOnClickListener {
            roomCount++
            roomCountText.text = roomCount.toString()
        }

        decreaseRoomButton.setOnClickListener {
            if (roomCount > 1) {
                roomCount--
                roomCountText.text = roomCount.toString()
            }
        }

        // People Count functionality (Increase/Decrease)
        val peopleCountText: TextView = findViewById(R.id.peopleCountText)
        val increasePeopleButton: Button = findViewById(R.id.increasePeopleButton)
        val decreasePeopleButton: Button = findViewById(R.id.decreasePeopleButton)

        increasePeopleButton.setOnClickListener {
            peopleCount++
            peopleCountText.text = peopleCount.toString()
        }

        decreasePeopleButton.setOnClickListener {
            if (peopleCount > 1) {
                peopleCount--
                peopleCountText.text = peopleCount.toString()
            }
        }

        // Handle Reserve button click
        val placeOrderButton: Button = findViewById(R.id.placeOrderButton)
        placeOrderButton.setOnClickListener {
            // Handle the place order functionality
        }
    }
}
