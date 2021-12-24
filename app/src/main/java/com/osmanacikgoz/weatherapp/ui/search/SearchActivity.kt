package com.osmanacikgoz.weatherapp.ui.search

import SearchAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.databinding.ActivitySearchBinding
import com.osmanacikgoz.weatherapp.ui.detail.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    private val viewModel: SearchViewModel by viewModel()
    private var searchAdapter: SearchAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        searchAdapter = SearchAdapter {
            viewModel.insertSearchCity(it)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("locationKey", it.key)
            startActivity(intent)
        }
        with(binding) {
            etSearch.addTextChangedListener { text ->
                text?.let {
                    val searchParam = it.toString()
                    if (searchParam.length >= 3) {
                        viewModel.searchByCity(searchParam)
                        binding.searchList.visibility = View.VISIBLE
                    }
                }
            }
        }
        observeSearchCityLiveData()
    }

    private fun observeSearchCityLiveData() {
        viewModel.searchCitiesLiveData.observe(this, { searchCities ->
            searchCities?.let {
                binding.searchList.apply {
                    searchAdapter?.setListOfCities(it)
                    adapter = searchAdapter
                    searchAdapter?.updateData()
                    hasFixedSize()
                }
            }
        })
    }
}