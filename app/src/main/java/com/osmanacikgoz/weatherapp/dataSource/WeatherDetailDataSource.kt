package com.osmanacikgoz.weatherapp.dataSource

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.api.transform
import com.osmanacikgoz.weatherapp.model.response.WeatherResponse

class WeatherDetailDataSource(
    private val detailServices: WeatherServices
) {
    fun fetchWeatherDetail(
        locationKey: String,
        onResultDetail: (response: ApiResponse<WeatherResponse>) -> Unit
    ) {
        this.detailServices.getWeather(locationKey, "true").transform(onResultDetail)
    }
}