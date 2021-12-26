package com.osmanacikgoz.weatherapp.repository

import timber.log.Timber

class WeatherDetailRepository constructor(

) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherDetailRepository")

    }

}