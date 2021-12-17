package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class AdministrativeArea(
    @SerializedName("ID")
    val ıD: String?,
    @SerializedName("LocalizedName")
    val localizedName: String?,
    @SerializedName("EnglishName")
    val englishName: String?,
    @SerializedName("Level")
    val level: Int?,
    @SerializedName("LocalizedType")
    val localizedType: String?,
    @SerializedName("EnglishType")
    val englishType: String?,
    @SerializedName("CountryID")
    val countryID: String?
)
