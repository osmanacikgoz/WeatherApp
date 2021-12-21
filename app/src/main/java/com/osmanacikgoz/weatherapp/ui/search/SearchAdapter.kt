import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osmanacikgoz.weatherapp.databinding.ItemSearchResultBinding
import com.osmanacikgoz.weatherapp.model.response.SearchItem

class SearchAdapter (
    private val cityClickListener:CityClickListener):
        RecyclerView.Adapter<SearchAdapter.CityViewHolder>() {
    private val cities = mutableListOf<SearchItem>()

    interface CityClickListener{
        fun onCityClicked(city:SearchItem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityViewHolder {
        val binding:ItemSearchResultBinding = ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    override fun getItemCount() = cities.size

    fun updateData() {
        notifyDataSetChanged()
    }

    inner class CityViewHolder(var binding: ItemSearchResultBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(city: SearchItem) {
            binding.tvCityName.text = city.localizedName
            itemView.setOnClickListener {
                city.let {
                    cityClickListener.onCityClicked(it)
                }
            }
        }
    }

}