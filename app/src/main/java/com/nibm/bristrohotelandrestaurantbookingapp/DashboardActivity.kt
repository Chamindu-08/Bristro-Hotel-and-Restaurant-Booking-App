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

            // Sample data for restaurants
            val restaurants = listOf(
                Restaurant(R.drawable.restaurant_image_1, "Restaurant 1", "123 Main St", R.drawable.ic_location),
                Restaurant(R.drawable.restaurant_image_2, "Restaurant 2", "456 Oak St", R.drawable.ic_location)
            )

            // Sample data for hotels
            val hotels = listOf(
                Hotel(R.drawable.hotel_image_1, "Hotel 1", "789 Pine St", R.drawable.ic_location),
                Hotel(R.drawable.hotel_image_2, "Hotel 2", "101 Maple St", R.drawable.ic_location)
            )

            val restaurantAdapter = RestaurantAdapter(restaurants)
            rvRestaurants.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvRestaurants.adapter = restaurantAdapter

            val hotelAdapter = HotelAdapter(hotels)
            rvHotels.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvHotels.adapter = hotelAdapter
        }
    }

