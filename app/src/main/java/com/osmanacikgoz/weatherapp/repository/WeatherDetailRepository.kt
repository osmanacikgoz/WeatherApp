package com.osmanacikgoz.weatherapp.repository

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.message
import com.osmanacikgoz.weatherapp.dataSource.WeatherDetailDataSource
import com.osmanacikgoz.weatherapp.model.entity.WeatherDetail
import timber.log.Timber

class WeatherDetailRepository constructor(
    private val weatherDetailDataSource: WeatherDetailDataSource
) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherDetailRepository")

    }

    fun detailCity(onResult: (List<WeatherDetail>) -> Unit) {
        var citiesDetail: List<WeatherDetail> = emptyList()
        isLoading = true

        weatherDetailDataSource.fetchWeatherDetail { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Success -> {
                    apiResponse.data?.let { data ->
                        citiesDetail = data
                        onResult.invoke(citiesDetail)
                    }
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }
        }
    }
}