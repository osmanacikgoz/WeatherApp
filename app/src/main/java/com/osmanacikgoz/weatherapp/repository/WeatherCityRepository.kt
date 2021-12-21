package com.osmanacikgoz.weatherapp.repository

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.message
import com.osmanacikgoz.weatherapp.dataSource.WeatherDataSource
import com.osmanacikgoz.weatherapp.model.response.SearchItem
import timber.log.Timber

class WeatherCityRepository(
    private val weatherDataSource: WeatherDataSource
) : Repository {

    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherCityRepository")
    }

    fun searchCity(searchParam: String, onResult: (searchItems: List<SearchItem>) -> Unit) {
        var searchCities: List<SearchItem> = emptyList()
        isLoading = true

        weatherDataSource.searchCity(searchParam) { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Success -> {
                    apiResponse.data?.let { data ->
                        searchCities = data
                        onResult.invoke(searchCities)
                    }
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }
        }
    }
}
