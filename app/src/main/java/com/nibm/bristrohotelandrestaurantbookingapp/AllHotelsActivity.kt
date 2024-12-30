import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.nibm.bristrohotelandrestaurantbookingapp.R

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hotelList = listOf(
            Hotel("Luxury Hotel", "A luxury experience with sea views.", R.drawable.hotel1),
            Hotel("Budget Inn", "Affordable rooms for travelers.", R.drawable.hotel2),
            Hotel("Mountain Resort", "Relax in the hills.", R.drawable.hotel3),
            Hotel("City Stay", "Conveniently located downtown.", R.drawable.hotel4)
        )

        val listView = findViewById<ListView>(R.id.hotelListView)
        listView.adapter = HotelAdapter(this, hotelList)

        // Handle back button
        findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            finish() // Close the activity
        }
    }
}
