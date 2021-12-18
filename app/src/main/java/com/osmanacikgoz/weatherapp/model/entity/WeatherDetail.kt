package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class WeatherDetail(
    val localObservationDateTime: String?,
    val epochTime: Int?,
    val weatherText: String?,
    val weatherIcon: Int?,
    val hasPrecipitation: Boolean?,
    val precipitationType: Any?,
    val ısDayTime: Boolean?,
    val temperature: Temperature?,
    val mobileLink: String?,
    val link: String?
)