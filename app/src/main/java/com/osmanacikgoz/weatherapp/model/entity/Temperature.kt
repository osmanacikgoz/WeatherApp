package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("Metric")
    val metric: Metric?,
    @SerializedName("Imperial")
    val ımperial: Imperial?
)
