package com.nibm.bristrohotelandrestaurantbookingapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        // Delay for 2 seconds and then start SignInActivity
        Handler().postDelayed({
            // Create an intent to start SignInActivity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)  // Start the SignInActivity
            finish()  // Close LoadActivity so user can't go back to it
        }, 2000)  // Delay of 2 seconds
    }
}
