package com.osmanacikgoz.weatherapp.ui.weather_detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.databinding.ActivityWeatherDetailBinding
import com.osmanacikgoz.weatherapp.ui.search.SearchActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class WeatherDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailBinding

    private val viewModel: WeatherDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather_detail)
        val locationKey = intent.getStringExtra("locationKey")
        getCurrentConditions(locationKey)

        val localizedName = intent.getStringExtra("localizedName")
        binding.tvCityName.text = localizedName
        initUI()
    }

    private fun initUI() {
        setOnClickListener()
        currentDetailLiveData()
        oneDailyForecastLiveData()
        changeBackground()

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

    private fun getCurrentConditions(locationKey: String?) {
        locationKey?.let {
            viewModel.getCurrentConditions(it)
            viewModel.getOneDailyForecast(it)
        }
    }

    private fun currentDetailLiveData() {
        viewModel.currentConditionsLiveData.observe(this) { currentConditions ->
            with(binding) {
                currentConditions?.let {
                    this.tvTemperature.text = it[0].temperature?.metric?.value.toString()
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
                        it.dailyForecasts?.get(0)?.temperature?.maximum?.value.toString() + "/" +
                                it.dailyForecasts?.get(0)?.temperature?.minimum?.value.toString()
                }
            }
        }
    }

    private fun changeBackground() {
        val constraint = binding.background
        val calendar: Calendar = Calendar.getInstance()
        when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 8..12 -> {
                constraint.setBackgroundResource(R.drawable.daytime)
            }
            in 18..24 -> {
                constraint.setBackgroundResource(R.drawable.night)
            }
            in 0..8 -> {
                constraint.setBackgroundResource(R.drawable.night)
            }

        }
    }
}