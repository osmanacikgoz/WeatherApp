package com.osmanacikgoz.weatherapp.api

import com.osmanacikgoz.weatherapp.model.response.SearchCityResponse
import com.osmanacikgoz.weatherapp.model.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServices {
    @GET("adminareas/TR/search")
    fun getSearch(): Call<SearchCityResponse>

    @GET("locationKey")
    fun getWeather(
        @Query("q") city: String,
    ): Call<WeatherResponse>
}