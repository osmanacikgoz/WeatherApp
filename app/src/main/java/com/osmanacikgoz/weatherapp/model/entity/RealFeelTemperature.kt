package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class RealFeelTemperature(
    @SerializedName("Metric")
    val metric: Metric?,
    @SerializedName("Imperial")
    val imperial: Imperial?
)
