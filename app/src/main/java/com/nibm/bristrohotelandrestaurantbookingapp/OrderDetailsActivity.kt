package com.nibm.bristrohotelandrestaurantbookingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class OrderDetailsActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val reservationID = "#716001"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        fetchReservationDetails(reservationID)

        back_btn.setOnClickListener {
            finish()
        }

        buttonCancelReservation.setOnClickListener {
            cancelReservation(reservationID)
        }
    }

    private fun fetchReservationDetails(reservationID: String) {
        db.collection("reservations").document(reservationID).get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val placeName = document.getString("placeName") ?: ""
                    val location = document.getString("location") ?: ""
                    val date = document.getString("date") ?: ""
                    val time = document.getString("time") ?: ""
                    val people = document.getLong("people") ?: 0
                    val status = document.getString("status") ?: ""

                    textViewPlaceName.text = placeName
                    textViewLocation.text = location
                    textViewDate.text = date
                    textViewTime.text = time
                    textViewPeople.text = "$people People"
                } else {
                    Toast.makeText(this, "No reservation found!", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to fetch details: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun cancelReservation(reservationID: String) {
        db.collection("reservations").document(reservationID)
            .update("status", "Cancelled")
            .addOnSuccessListener {
                Toast.makeText(this, "Reservation cancelled successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to cancel reservation: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
