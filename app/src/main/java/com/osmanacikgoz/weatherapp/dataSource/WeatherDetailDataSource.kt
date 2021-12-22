package com.osmanacikgoz.weatherapp.dataSource

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.api.transform
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity
import com.osmanacikgoz.weatherapp.model.response.WeatherResponse

class WeatherDetailDataSource(
    private val detailServices: WeatherServices
) {
    fun fetchWeatherDetail(
        onResultDetail: (response: ApiResponse<WeatherResponse>) -> Unit
    ) {
        this.detailServices.getWeather("true").transform(onResultDetail)
    }
}