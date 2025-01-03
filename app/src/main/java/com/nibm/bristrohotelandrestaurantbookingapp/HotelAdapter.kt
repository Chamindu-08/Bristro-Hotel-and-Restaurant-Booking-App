import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.DrawableRes

class HotelAdapter(private val context: Context, private val hotels: List<Hotel>) : BaseAdapter() {

    override fun getCount(): Int = hotels.size
    override fun getItem(position: Int): Any = hotels[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_hotel, parent, false)

        val hotel = hotels[position]

        val hotelImage = view.findViewById<ImageView>(R.id.hotelImage)
        val hotelName = view.findViewById<TextView>(R.id.hotelName)
        val hotelDescription = view.findViewById<TextView>(R.id.hotelDescription)
        val reserveButton = view.findViewById<Button>(R.id.reserveButton)

        hotelImage.setImageResource(hotel.imageResId)
        hotelName.text = hotel.name
        hotelDescription.text = hotel.description

        reserveButton.setOnClickListener {
            Toast.makeText(context, "Reserved: ${hotel.name}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
