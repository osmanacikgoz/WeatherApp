package com.osmanacikgoz.weatherapp.model.network


import com.google.gson.annotations.SerializedName
import com.osmanacikgoz.weatherapp.model.entity.Temperature

class WeatherResponse : ArrayList<WeatherResponse.WeatherResponseItem>() {
    data class WeatherResponseItem(
        @SerializedName("LocalObservationDateTime")
        val localObservationDateTime: String?,
        @SerializedName("EpochTime")
        val epochTime: Int?,
        @SerializedName("WeatherText")
        val weatherText: String?,
        @SerializedName("WeatherIcon")
        val weatherIcon: Int?,
        @SerializedName("HasPrecipitation")
        val hasPrecipitation: Boolean?,
        @SerializedName("PrecipitationType")
        val precipitationType: Any?,
        @SerializedName("IsDayTime")
        val ısDayTime: Boolean?,
        @SerializedName("Temperature")
        val temperature: Temperature?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("Link")
        val link: String?
    )
}