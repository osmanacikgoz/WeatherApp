package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("ID")
    val ıD: String?,
    @SerializedName("LocalizedName")
    val localizedName: String?,
    @SerializedName("EnglishName")
    val englishName: String?
)
