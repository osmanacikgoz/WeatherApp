package com.osmanacikgoz.weatherapp.api

import com.osmanacikgoz.weatherapp.model.network.SearchResponse
import com.osmanacikgoz.weatherapp.model.network.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServices {
    @GET("cities/TR/search")
    suspend fun getSearch(
        @Query("q") city: String,
        @Query("key") key: String
    ): Response<SearchResponse>

    @GET("locationKey")
    suspend fun getWeather(
        @Query("key") key: String
    ): Response<WeatherResponse>
}