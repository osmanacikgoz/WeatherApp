package com.osmanacikgoz.weatherapp.dataSource

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.api.transform
import com.osmanacikgoz.weatherapp.model.response.SearchCityResponse

class WeatherDataSource(
    private val weatherServices: WeatherServices,
) {
    fun searchCity(
        query: String,
        onResult: (response: ApiResponse<SearchCityResponse>) -> Unit
    ) {
        this.weatherServices.getSearch(query).transform(onResult)
    }
}