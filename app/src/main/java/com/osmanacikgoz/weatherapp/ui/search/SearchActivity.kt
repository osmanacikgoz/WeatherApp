package com.osmanacikgoz.weatherapp.ui.search

import SearchAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.base.toEntity
import com.osmanacikgoz.weatherapp.databinding.ActivitySearchBinding
import com.osmanacikgoz.weatherapp.ui.weather_detail.WeatherDetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    private val viewModel: SearchViewModel by viewModel()

    private var searchAdapter: SearchAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)


        viewModel.getSearchItems { searchItems ->
            val searchKeys = searchItems.map { it.localizedName }

            if (searchKeys.isNullOrEmpty().not()) {
                binding.etSearch.post {
                    val arrayAdapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        searchKeys
                    )
                    binding.etSearch.setAdapter(arrayAdapter)
                    binding.etSearch.showDropDown()
                }
            }
        }

        searchAdapter = SearchAdapter { searchItem, _ ->
            viewModel.insertSearchItem(searchItem.toEntity())
            val intent = Intent(this, WeatherDetailActivity::class.java)
            intent.putExtra("locationKey", searchItem.key)
            intent.putExtra("localizedName", searchItem.localizedName)
            startActivity(intent)

        }

        observeSearchCityLiveData()
        setClickListeners()
        setSearchTextListener()
    }

    private fun setClickListeners() {
        with(binding) {
            ivSearch.setOnClickListener {
                viewModel.searchParam?.let { mSearchParam ->
                    viewModel.autoCompleteSearch(mSearchParam)
                }
            }
        }
    }

    private fun setSearchTextListener() {
        binding.etSearch.addTextChangedListener { editable ->
            editable?.let {
                val searchParam = it.toString()
                viewModel.searchParam = searchParam
            }
        }
    }

    private fun observeSearchCityLiveData() {
        viewModel.searchItemsLiveData.observe(this, { searchItems ->
            searchItems?.let {
                binding.rvSearchItems.apply {
                    adapter = searchAdapter
                    searchAdapter?.setData(it)
                }
            }
        })
    }
}