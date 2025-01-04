package com.nibm.bristrohotelandrestaurantbookingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AllRestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_restaurant) // Ensure this layout exists

        // Handle system bar insets for the view
        val restaurantImageView = findViewById<View>(R.id.imageView1)
        ViewCompat.setOnApplyWindowInsetsListener(restaurantImageView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
