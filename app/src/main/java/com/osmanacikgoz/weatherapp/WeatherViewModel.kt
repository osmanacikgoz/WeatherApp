package com.osmanacikgoz.weatherapp

import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.base.DispatchViewModel
import timber.log.Timber

class WeatherViewModel constructor(
    private val weatherServices: WeatherServices
) : DispatchViewModel() {

    init {
        Timber.d("Injection:WeatherViewModel")
    }

}