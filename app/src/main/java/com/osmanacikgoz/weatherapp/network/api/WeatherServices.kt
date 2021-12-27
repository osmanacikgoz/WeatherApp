package com.osmanacikgoz.weatherapp.network.api

import com.osmanacikgoz.weatherapp.network.api.response.AutoCompleteSearchResponse
import com.osmanacikgoz.weatherapp.network.api.response.CurrentConditionsResponse
import com.osmanacikgoz.weatherapp.network.api.response.GeopositionSearchResponse
import com.osmanacikgoz.weatherapp.network.api.response.OneDailyForecastsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherServices {
    @GET("locations/v1/cities/autocomplete")
    fun getAutoCompleteSearch(
        @Query("q") city: String
    ): Call<AutoCompleteSearchResponse>

    @GET("forecasts/v1/daily/1day/{locationKey}")
    fun getOneDailyForecasts(
        @Path("locationKey") locationKey: String
    ): Call<OneDailyForecastsResponse>

    @GET("currentconditions/v1/{locationKey}")
    fun getCurrentConditions(
        @Path("locationKey") locationKey: String,
        @Query("language") language:String
    ): Call<CurrentConditionsResponse>

    @GET("locations/v1/cities/geoposition/search")
    fun getGeoPosition(
        @Query("q") locationLatLng: String
    ): Call<GeopositionSearchResponse>
}