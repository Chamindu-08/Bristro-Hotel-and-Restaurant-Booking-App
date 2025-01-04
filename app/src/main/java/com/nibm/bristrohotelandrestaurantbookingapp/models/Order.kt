package com.nibm.bristrohotelandrestaurantbookingapp.models

data class Order(
    val orderId: String,
    val mealName: String,
    val placeName: String,
    val location: String,
    val status: String,
    val imageUrl: String
)
