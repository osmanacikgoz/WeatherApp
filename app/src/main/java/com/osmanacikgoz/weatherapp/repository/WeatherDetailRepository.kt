package com.osmanacikgoz.weatherapp.repository

import com.osmanacikgoz.weatherapp.network.api.ApiResponse
import com.osmanacikgoz.weatherapp.network.api.client.MainWeatherClient
import com.osmanacikgoz.weatherapp.network.api.message
import com.osmanacikgoz.weatherapp.network.api.response.CurrentConditionsResponse
import com.osmanacikgoz.weatherapp.network.api.response.OneDailyForecastsResponse
import timber.log.Timber

class WeatherDetailRepository constructor(
    private val mainWeatherClient: MainWeatherClient

) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherDetailRepository")

    }
    fun getCurrentCondition(
        locationKey:String,
        onResult:(CurrentConditionsResponse?) ->Unit
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

    fun getOneDailyForecast(
        locationKey: String,
        onResult: (OneDailyForecastsResponse?) -> Unit
    ){
        isLoading = true

        mainWeatherClient.oneDailyForecast(locationKey) {apiResponse->
            when(apiResponse) {
                is ApiResponse.Success -> {
                    val oneDailyForecastsResponse: OneDailyForecastsResponse? = apiResponse.data
                    onResult(oneDailyForecastsResponse)
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }
        }
    }

}