package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("Speed")
    val speed: Speed?
)
