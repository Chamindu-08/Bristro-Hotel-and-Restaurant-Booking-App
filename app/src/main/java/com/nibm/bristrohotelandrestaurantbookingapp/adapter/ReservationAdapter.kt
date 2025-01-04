package com.nibm.bristrohotelandrestaurantbookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nibm.bristrohotelandrestaurantbookingapp.R
import com.nibm.bristrohotelandrestaurantbookingapp.model.Reservation

class ReservationAdapter(
    private val reservations: List<Reservation>,
    private val onItemClicked: (Reservation) -> Unit
) : RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder>() {

    class ReservationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewPlaceName)
        val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
        val imageView: ImageView = itemView.findViewById(R.id.imageViewReservation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reservation, parent, false)
        return ReservationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        val reservation = reservations[position]

        holder.nameTextView.text = reservation.name
        holder.dateTextView.text = reservation.date

        Glide.with(holder.itemView.context)
            .load(reservation.imageUrl)
            .placeholder(R.drawable.img_1)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            onItemClicked(reservation)
        }
    }

    override fun getItemCount(): Int = reservations.size
}
