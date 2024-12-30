package com.nibm.bristrohotelandrestaurantbookingapp

data class Restaurant(
    val image: Int,  // Resource ID for image
    val name: String,
    val address: String,
    val locationIcon: Int  // Resource ID for location icon
) {

}

data class Hotel(
    val image: Int,  // Resource ID for image
    val name: String,
    val address: String,
    val locationIcon: Int  // Resource ID for location icon
)
