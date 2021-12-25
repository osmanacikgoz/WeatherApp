package com.osmanacikgoz.weatherapp.network.api.client

import com.osmanacikgoz.weatherapp.network.api.ApiResponse
import com.osmanacikgoz.weatherapp.network.api.WeatherServices
import com.osmanacikgoz.weatherapp.network.api.response.AutoCompleteSearchResponse
import com.osmanacikgoz.weatherapp.network.api.transform

class SearchClient(
    private val service: WeatherServices
) {

    fun autoCompleteSearch(
        searchParam: String,
        onResult: (response: ApiResponse<AutoCompleteSearchResponse>) -> Unit
    ) {
        this.service.getAutoCompleteSearch(searchParam).transform(onResult)
    }

}