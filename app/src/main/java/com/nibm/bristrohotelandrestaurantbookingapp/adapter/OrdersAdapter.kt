package com.nibm.bristrohotelandrestaurantbookingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nibm.bristrohotelandrestaurantbookingapp.R
import com.nibm.bristrohotelandrestaurantbookingapp.models.Order

class OrdersAdapter(
    private val context: Context,
    private val orders: List<Order>,
    private val onItemClicked: (Order) -> Unit
) : RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    class OrdersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderImage: ImageView = view.findViewById(R.id.imageViewOrder)
        val orderId: TextView = view.findViewById(R.id.textViewOrderID)
        val mealName: TextView = view.findViewById(R.id.textViewMealName)
        val placeName: TextView = view.findViewById(R.id.textViewPlaceName)
        val location: TextView = view.findViewById(R.id.textViewLocation)
        val status: TextView = view.findViewById(R.id.textViewStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false)
        return OrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        val order = orders[position]

        holder.orderId.text = order.orderId
        holder.mealName.text = order.mealName
        holder.placeName.text = order.placeName
        holder.location.text = order.location
        holder.status.text = order.status

        Glide.with(context)
            .load(order.imageUrl)
            .placeholder(R.drawable.img_retaurant)
            .into(holder.orderImage)

        holder.itemView.setOnClickListener { onItemClicked(order) }
    }

    override fun getItemCount(): Int = orders.size
}
