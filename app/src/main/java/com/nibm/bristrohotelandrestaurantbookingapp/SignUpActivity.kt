package com.example.bristroapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nibm.bristrohotelandrestaurantbookingapp.R
import com.nibm.bristrohotelandrestaurantbookingapp.SignInActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signInText: TextView = findViewById(R.id.signInText)

        signInText.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
