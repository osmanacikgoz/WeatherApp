package com.osmanacikgoz.weatherapp.ui.weather_detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osmanacikgoz.weatherapp.databinding.ActivityWeatherDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel


class WeatherDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailBinding

    private val viewModel: WeatherDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}