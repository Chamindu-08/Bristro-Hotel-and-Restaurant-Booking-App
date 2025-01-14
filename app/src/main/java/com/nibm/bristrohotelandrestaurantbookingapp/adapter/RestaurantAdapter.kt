package com.nibm.bristrohotelandrestaurantbookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nibm.bristrohotelandrestaurantbookingapp.R
import com.nibm.bristrohotelandrestaurantbookingapp.models.RestaurantHotel

class RestaurantAdapter(
    private val restaurantList: List<RestaurantHotel>,
    private val onItemClicked: (RestaurantHotel) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    // ViewHolder class
    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgRestaurant: ImageView = itemView.findViewById(R.id.img_restaurant)
        val tvRestaurantName: TextView = itemView.findViewById(R.id.tv_restaurant_name)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_location)
        val btnView: Button = itemView.findViewById(R.id.btn_view)
    }

    // Create and return a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)
        return RestaurantViewHolder(view)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantList[position]

        holder.tvRestaurantName.text = restaurant.name
        holder.tvLocation.text = restaurant.locationIcon.toString()

        Glide.with(holder.itemView.context)
            .load(restaurant.imageUrl)
            .into(holder.imgRestaurant)

        holder.itemView.setOnClickListener {
            onItemClicked(restaurant)
        }

    }

    // Return the size of the data set
    override fun getItemCount(): Int {
        return restaurantList.size
    }
}