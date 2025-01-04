package com.nibm.bristrohotelandrestaurantbookingapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val back = findViewById<ImageView>(R.id.backButton)
        val edit = findViewById<ImageView>(R.id.editProfileButton)
        val home = findViewById<LinearLayout>(R.id.homeLayout)
        val reservation = findViewById<LinearLayout>(R.id.reservationLayout)
        val order = findViewById<LinearLayout>(R.id.ordersLayout)
        val changePassword = findViewById<LinearLayout>(R.id.changePasswordLayout)
        val logout = findViewById<LinearLayout>(R.id.logoutLayout)

        back.setOnClickListener {
            finish()
        }

        edit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        reservation.setOnClickListener {
            val intent = Intent(this, AllReservationActivity::class.java)
            startActivity(intent)
        }

        order.setOnClickListener {
            val intent = Intent(this, AllOdersActivity::class.java)
            startActivity(intent)
        }

        changePassword.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
        }
    }
}
