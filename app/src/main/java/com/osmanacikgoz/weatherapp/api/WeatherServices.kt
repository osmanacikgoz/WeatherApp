package com.osmanacikgoz.weatherapp.api

import com.osmanacikgoz.weatherapp.model.response.GeoPositionResponse
import com.osmanacikgoz.weatherapp.model.response.SearchCityResponse
import com.osmanacikgoz.weatherapp.model.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherServices {
    @GET("locations/v1/cities/autocomplete")
    fun getSearch(
        @Query("q") city: String
    ): Call<SearchCityResponse>

    @GET("currentconditions/v1/{locationKey}")
    fun getWeather(
        @Path("locationKey") locationKey: String,
        @Query("details") detail: String
    ): Call<WeatherResponse>
    @GET("locations/v1/cities/geoposition/search")
    fun getGeoPosition(
        @Query("q") latlang:String
    ):Call<GeoPositionResponse>
}