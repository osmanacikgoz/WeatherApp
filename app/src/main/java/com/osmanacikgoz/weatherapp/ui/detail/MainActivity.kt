package com.osmanacikgoz.weatherapp.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.databinding.ActivityMainBinding
import com.osmanacikgoz.weatherapp.ui.search.SearchActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModelDetail: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            ivSearch.setOnClickListener {
                startActivity(Intent(this@MainActivity, SearchActivity::class.java))
            }
        }
    }

    private fun weatherCityDetail(position: Int) {
        viewModelDetail.detailLiveData.observe(this, { cityDetail ->
            cityDetail?.let {
                it[position].apply {
                    binding.tvWeatherText.text = this.weatherText
                    binding.tvTemperature.text = this.temperature?.metric?.value.toString()
                    binding.tvRealTemperature.text =  this.realFeelTemperature?.metric?.value.toString()
                    binding.tvHumidity.text = this.relativeHumidity.toString()
                    binding.tvWind.text =  this.wind?.speed.toString()
                    this.localObservationDateTime
                }
            }
        })
    }
}