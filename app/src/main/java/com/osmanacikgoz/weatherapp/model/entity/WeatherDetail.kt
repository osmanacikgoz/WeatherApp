package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class WeatherDetail(
    @SerializedName("localObservationDateTime")
    val localObservationDateTime: String?,
    @SerializedName("epochTime")
    val epochTime: Int?,
    @SerializedName("weatherText")
    val weatherText: String?,
    @SerializedName("weatherIcon")
    val weatherIcon: Int?,
    @SerializedName("hasPrecipitation")
    val hasPrecipitation: Boolean?,
    @SerializedName("precipitationType")
    val precipitationType: Any?,
    @SerializedName("ısDayTime")
    val ısDayTime: Boolean?,
    @SerializedName("temperature")
    val temperature: Temperature?,
    @SerializedName("mobileLink")
    val mobileLink: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("RealFeelTemperature")
    val realFeelTemperature: RealFeelTemperature?,
    @SerializedName("RelativeHumidity")
    val relativeHumidity: Int?,
    @SerializedName("Wind")
    val wind: Wind?,
)