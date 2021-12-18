package com.osmanacikgoz.weatherapp.dataSource

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.api.transform
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity
import com.osmanacikgoz.weatherapp.model.response.SearchCityResponse
import com.osmanacikgoz.weatherapp.model.response.WeatherResponse

class WeatherDetailDataSource(private val detailServices: WeatherServices) {
    private val city:SearchItemEntity?=null
    private val resultCity=city?.localizedName
    fun fetchWeatherDetail(
        onResultDetail: (response: ApiResponse<WeatherResponse>) -> Unit
    ) {
        this.detailServices.getWeather(resultCity!!).transform(onResultDetail)
    }
}