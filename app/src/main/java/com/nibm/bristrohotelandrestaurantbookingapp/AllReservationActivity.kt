package com.nibm.bristrohotelandrestaurantbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.nibm.bristrohotelandrestaurantbookingapp.adapter.ReservationAdapter
import com.nibm.bristrohotelandrestaurantbookingapp.model.Reservation

class AllReservationActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var reservationAdapter: ReservationAdapter
    private lateinit var reservationList: MutableList<Reservation>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_reservation)

        firestore = FirebaseFirestore.getInstance()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewReservations)
        reservationList = mutableListOf()
        reservationAdapter = ReservationAdapter(reservationList) { reservation ->
            val intent = Intent(this, ReservationDetailsActivity::class.java)
            intent.putExtra("reservationId", reservation.reservationId)
            intent.putExtra("reservationName", reservation.name)
            intent.putExtra("reservationDate", reservation.date)
            intent.putExtra("reservationTime", reservation.time)
            intent.putExtra("reservationPeople", reservation.people)
            intent.putExtra("reservationLocation", reservation.location)
            intent.putExtra("reservationImageUrl", reservation.imageUrl)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = reservationAdapter

        fetchReservations()
    }

    private fun fetchReservations() {
        firestore.collection("reservations")
            .orderBy("date", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener { querySnapshot ->
                reservationList.clear()
                for (document in querySnapshot.documents) {
                    val reservation = document.toObject(Reservation::class.java)
                    reservation?.let { reservationList.add(it) }
                }
                reservationAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to fetch data: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
