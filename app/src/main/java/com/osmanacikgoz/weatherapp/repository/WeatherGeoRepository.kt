package com.osmanacikgoz.weatherapp.repository

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.message
import com.osmanacikgoz.weatherapp.dataSource.WeatherGeoDataSource
import com.osmanacikgoz.weatherapp.model.response.GeoPositionResponse
import timber.log.Timber

class WeatherGeoRepository(
    private val weatherGeoDataSource: WeatherGeoDataSource
) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherGeoRepository")
    }

    fun getGeo(latLang: String, onResult: (List<GeoPositionResponse>) -> Unit) {
        var citiesGeo: List<GeoPositionResponse> = emptyList()
        isLoading = true

        weatherGeoDataSource.fetchGeoPosition(latLang) { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Success -> {
                    apiResponse.data?.let { data ->
                        citiesGeo = (listOf(data))
                        onResult.invoke(citiesGeo)
                    }
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }

        }
    }
}