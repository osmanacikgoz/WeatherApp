package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class TimeZone(
    @SerializedName("Code")
    val code: String?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("GmtOffset")
    val gmtOffset: Double?,
    @SerializedName("IsDaylightSaving")
    val ısDaylightSaving: Boolean?,
    @SerializedName("NextOffsetChange")
    val nextOffsetChange: Any?
)
