package com.osmanacikgoz.weatherapp.network.api.client

import com.osmanacikgoz.weatherapp.network.api.ApiResponse
import com.osmanacikgoz.weatherapp.network.api.WeatherServices
import com.osmanacikgoz.weatherapp.network.api.response.CurrentConditionsResponse
import com.osmanacikgoz.weatherapp.network.api.response.GeopositionSearchResponse
import com.osmanacikgoz.weatherapp.network.api.response.OneDailyForecastsResponse
import com.osmanacikgoz.weatherapp.network.api.transform

class MainWeatherClient(
    private val services: WeatherServices
) {
    fun geoPositionSearch(
        latLang: String,
        onResult: (response: ApiResponse<GeopositionSearchResponse>) -> Unit
    ) {
        this.services.getGeoPosition(latLang).transform(onResult)
    }

    fun currentConditions(
        locationKey: String,
        onResult: (response: ApiResponse<CurrentConditionsResponse>) -> Unit
    ) {
        this.services.getCurrentConditions(locationKey,"tr-TR").transform(onResult)
    }

    fun oneDailyForecast(
        locationKey: String,
        onResult: (response: ApiResponse<OneDailyForecastsResponse>) -> Unit
    ){
        this.services.getOneDailyForecasts(locationKey).transform(onResult)
    }

}