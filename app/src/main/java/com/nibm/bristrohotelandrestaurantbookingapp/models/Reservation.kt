package com.nibm.bristrohotelandrestaurantbookingapp.model

data class Reservation(
    val reservationId: String = "",
    val userId: String = "",
    val name: String = "",
    val date: String = "",
    val time: String = "",
    val people: Int = 0,
    val location: String = "",
    val imageUrl: String = ""
)
