package com.osmanacikgoz.weatherapp.ui.weather_detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osmanacikgoz.weatherapp.databinding.ActivityWeatherDetailBinding
import com.osmanacikgoz.weatherapp.ui.search.SearchActivity
import org.koin.android.viewmodel.ext.android.viewModel


class WeatherDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailBinding

    private val viewModel: WeatherDetailViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        setOnClickListener()
        currentDetailLiveData()
        oneDailyForecastLiveData()
        getCurrentConditions()

    }

    private fun setOnClickListener() {
        with(binding) {
            ivSearch.setOnClickListener {
                navigateSearchPage()
            }
        }
    }

    private fun navigateSearchPage() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }

    private fun currentDetailLiveData() {
        viewModel.currentConditionsLiveData.observe(this) { currentConditions ->
            with(binding) {
                currentConditions?.let {
                    this.tvTemperature.text = it[0].temperature.toString()
                    this.tvWeatherText.text = it[0].weatherText.toString()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun oneDailyForecastLiveData() {
        viewModel.oneDailyForecastLiveData.observe(this) { oneDailyForecast ->
            with(binding) {
                oneDailyForecast?.let {
                    this.tvDayAndNight.text =
                        it.dailyForecasts?.get(0)?.temperature?.maximum.toString() + "/" +
                                it.dailyForecasts?.get(0)?.temperature?.minimum.toString()
                }
            }
        }
    }

    private fun getCurrentConditions() {
        val locationKey = intent.getStringExtra("locationKey")
        locationKey?.let {
            viewModel.getCurrentConditions(it)
            viewModel.getOneDailyForecast(it)
        }
    }

}