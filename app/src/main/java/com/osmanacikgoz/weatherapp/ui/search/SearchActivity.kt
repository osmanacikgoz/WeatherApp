package com.osmanacikgoz.weatherapp.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.databinding.ActivitySearchBinding
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        with(binding) {
            etSearch.addTextChangedListener { text ->
                text?.let {
                    val searchParam = it.toString()
                    if (searchParam.length >= 3) {
                        viewModel.searchByCity(searchParam)
                    }
                }
            }
        }

        observeSearchCityLiveData()
    }

    private fun observeSearchCityLiveData() {
        viewModel.searchCitiesLiveData.observe(this, { searchCities ->
            searchCities?.let {
                Timber.d("")
                //System.currentTimeMillis()
                //orderby date limit 5
            }
        })
    }

    private fun initUI() {

    }

}