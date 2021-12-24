package com.osmanacikgoz.weatherapp.dataSource

import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.api.transform
import com.osmanacikgoz.weatherapp.model.response.GeoPositionResponse

class WeatherGeoDataSource(
    private val geoDataServices: WeatherServices
) {
    fun fetchGeoPosition(
        latLang: String,
        onResultDetail: (response: ApiResponse<GeoPositionResponse>) -> Unit
    ) {
        this.geoDataServices.getGeoPosition(latLang).transform(onResultDetail)
    }
}