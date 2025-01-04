package com.nibm.bristrohotelandrestaurantbookingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



    class DashboardActivity : AppCompatActivity() {

        private lateinit var rvRestaurants: RecyclerView
        private lateinit var rvHotels: RecyclerView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dashboard)

            rvRestaurants = findViewById(R.id.rv_restaurants)
            rvHotels = findViewById(R.id.rv_hotels)
        }
    }

