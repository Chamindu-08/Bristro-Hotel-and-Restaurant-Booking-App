package com.nibm.bristrohotelandrestaurantbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backButton: ImageView = findViewById(R.id.backButton)
        val editProfileButton: TextView = findViewById(R.id.editProfileButton)

        val homeOption: TextView = findViewById(R.id.homeOption)
        val reservationOption: TextView = findViewById(R.id.reservationOption)
        val ordersOption: TextView = findViewById(R.id.ordersOption)
        val changePasswordOption: TextView = findViewById(R.id.changePasswordOption)
        val privacyPoliciesOption: TextView = findViewById(R.id.privacyPoliciesOption)
        val aboutAppOption: TextView = findViewById(R.id.aboutAppOption)
        val helpOption: TextView = findViewById(R.id.helpOption)
        val logoutOption: TextView = findViewById(R.id.logoutOption)

        backButton.setOnClickListener {
            finish()
        }

        editProfileButton.setOnClickListener {

            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        homeOption.setOnClickListener {
            Toast.makeText(this, "Navigating to Home", Toast.LENGTH_SHORT).show()

        }

        reservationOption.setOnClickListener {
            Toast.makeText(this, "Navigating to Reservations", Toast.LENGTH_SHORT).show()

        }

        ordersOption.setOnClickListener {
            Toast.makeText(this, "Navigating to Orders", Toast.LENGTH_SHORT).show()
        }

        changePasswordOption.setOnClickListener {
            Toast.makeText(this, "Navigating to Change Password", Toast.LENGTH_SHORT).show()
        }


        privacyPoliciesOption.setOnClickListener {
            Toast.makeText(this, "Viewing Privacy & Policies", Toast.LENGTH_SHORT).show()
        }

        aboutAppOption.setOnClickListener {
            Toast.makeText(this, "Viewing About App", Toast.LENGTH_SHORT).show()
        }

        helpOption.setOnClickListener {
            Toast.makeText(this, "Navigating to Help", Toast.LENGTH_SHORT).show()
        }

        logoutOption.setOnClickListener {
            Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
        }
    }
}
