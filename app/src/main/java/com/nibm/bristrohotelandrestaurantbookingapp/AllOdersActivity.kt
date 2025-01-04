package com.nibm.bristrohotelandrestaurantbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.nibm.bristrohotelandrestaurantbookingapp.adapter.OrdersAdapter
import com.nibm.bristrohotelandrestaurantbookingapp.models.Order

class AllOdersActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var backBtn: ImageView
    private lateinit var ordersAdapter: OrdersAdapter
    private lateinit var database: DatabaseReference
    private val ordersList = mutableListOf<Order>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_oders)

        recyclerView = findViewById(R.id.recyclerViewOrders)
        backBtn = findViewById(R.id.back_btn)

        recyclerView.layoutManager = LinearLayoutManager(this)
        ordersAdapter = OrdersAdapter(this, ordersList) { order ->
            // Handle item click
            val intent = Intent(this, OrderDetailsActivity::class.java)
            intent.putExtra("orderId", order.orderId)
            startActivity(intent)
        }
        recyclerView.adapter = ordersAdapter

        backBtn.setOnClickListener { finish() }

        fetchOrdersFromFirebase()
    }

    private fun fetchOrdersFromFirebase() {
        database = FirebaseDatabase.getInstance().getReference("orders")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ordersList.clear()
                for (orderSnapshot in snapshot.children) {
                    val order = orderSnapshot.getValue(Order::class.java)
                    if (order != null) {
                        ordersList.add(order)
                    }
                }
                ordersAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}
