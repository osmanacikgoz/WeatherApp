import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osmanacikgoz.weatherapp.databinding.ItemSearchResultBinding
import com.osmanacikgoz.weatherapp.model.entity.SearchItem

class SearchAdapter(
    val onItemClickListener: (SearchItem) -> Unit
) :
    RecyclerView.Adapter<SearchAdapter.CityViewHolder>() {
    private var cities = listOf<SearchItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityViewHolder {
        val binding: ItemSearchResultBinding =
            ItemSearchResultBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    override fun getItemCount() = cities.size

    fun updateData() {
        notifyDataSetChanged()
    }

    fun setListOfCities(cities: List<SearchItem>){
        this.cities = cities
    }

    inner class CityViewHolder(var binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(city: SearchItem) {
            binding.tvCityName.text = city.localizedName
            binding.root.setOnClickListener {
                city.let {
                    onItemClickListener(city)
                }
            }
        }
    }

}