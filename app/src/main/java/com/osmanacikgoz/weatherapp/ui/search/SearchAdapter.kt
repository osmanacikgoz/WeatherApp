import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.base.BaseViewHolder
import com.osmanacikgoz.weatherapp.base.bindings
import com.osmanacikgoz.weatherapp.databinding.ItemSearchResultBinding
import com.osmanacikgoz.weatherapp.network.api.response.AutoCompleteSearchResponse

class SearchAdapter(
    private val onItemClickListener: (model: AutoCompleteSearchResponse.AutoCompleteSearchResponseItem, position: Int) -> Unit
) : RecyclerView.Adapter<SearchAdapter.CityViewHolder>() {

    private var cities = listOf<AutoCompleteSearchResponse.AutoCompleteSearchResponseItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityViewHolder {
        return CityViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position], position, onItemClickListener)
    }

    override fun getItemCount() = cities.size

    fun setData(searchItems: List<AutoCompleteSearchResponse.AutoCompleteSearchResponseItem>) {
        this.cities = searchItems
        notifyDataSetChanged()
    }

    class CityViewHolder(parent: ViewGroup) :
        BaseViewHolder<AutoCompleteSearchResponse.AutoCompleteSearchResponseItem>(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_search_result,
                parent,
                false
            )
        ) {

        private val binding by bindings<ItemSearchResultBinding>(itemView)

        override fun bind(
            item: AutoCompleteSearchResponse.AutoCompleteSearchResponseItem,
            position: Int,
            setOnClickListener: (model: AutoCompleteSearchResponse.AutoCompleteSearchResponseItem, position: Int) -> Unit
        ) {
            with(binding) {
                tvCityName.text = item.localizedName

                itemView.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        setOnClickListener.invoke(item, position)
                    }

                })
            }
        }
    }

}