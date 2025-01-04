import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nibm.bristrohotelandrestaurantbookingapp.R

// Define a data class for Accommodation data
data class Accommodation(
    val name: String,
    val location: String,
    val imageUrl: String
)

// Adapter class
class AccommodationAdapter(
    private val accommodationList: List<Accommodation>,
    private val onItemClicked: (Accommodation) -> Unit
) : RecyclerView.Adapter<AccommodationAdapter.AccommodationViewHolder>() {

    // ViewHolder class to hold the item views
    class AccommodationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val accommodationImageView: ImageView = itemView.findViewById(R.id.img_hotel)
        val accommodationNameTextView: TextView = itemView.findViewById(R.id.tv_hotel_name)
        val accommodationLocationTextView: TextView = itemView.findViewById(R.id.tv_hotel_location)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccommodationViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel, parent, false)
        return AccommodationViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccommodationViewHolder, position: Int) {
        // Get the current accommodation
        val accommodation = accommodationList[position]

        // Bind data to the views
        holder.accommodationNameTextView.text = accommodation.name
        holder.accommodationLocationTextView.text = accommodation.location

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(accommodation.imageUrl)
            .into(holder.accommodationImageView)

        // Handle item click
        holder.itemView.setOnClickListener {
            onItemClicked(accommodation)
        }
    }

    override fun getItemCount(): Int {
        return accommodationList.size
    }
}
