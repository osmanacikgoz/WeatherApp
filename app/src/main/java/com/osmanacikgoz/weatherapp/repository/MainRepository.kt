package com.osmanacikgoz.weatherapp.repository

import com.osmanacikgoz.weatherapp.network.api.ApiResponse
import com.osmanacikgoz.weatherapp.network.api.client.MainWeatherClient
import com.osmanacikgoz.weatherapp.network.api.message
import com.osmanacikgoz.weatherapp.network.api.response.CurrentConditionsResponse
import com.osmanacikgoz.weatherapp.network.api.response.GeopositionSearchResponse
import timber.log.Timber

class MainRepository(
    private val mainWeatherClient: MainWeatherClient
) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection MainRepository")
    }

    fun geoPosition(
        latLang: String,
        onResult: (GeopositionSearchResponse?) -> Unit
    ) {
        isLoading = true

        mainWeatherClient.geoPositionSearch(latLang) { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Success -> {
                    val geoPositionResponse: GeopositionSearchResponse? = apiResponse.data
                    onResult(geoPositionResponse)
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }
        }
    }

    fun currentConditions(
        locationKey: String,
        onResult: (CurrentConditionsResponse?) -> Unit
    ) {
        isLoading = true

        mainWeatherClient.currentConditions(locationKey) { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Success -> {
                    val currentConditionsResponse: CurrentConditionsResponse? = apiResponse.data
                    onResult(currentConditionsResponse)
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }
        }
    }

}