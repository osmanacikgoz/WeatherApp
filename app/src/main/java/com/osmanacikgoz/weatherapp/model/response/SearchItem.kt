package com.osmanacikgoz.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class SearchItem(
    @SerializedName("Version")
    val version: Int?,
    @SerializedName("Key")
    val key: String?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Rank")
    val rank: Int?,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("EnglishName")
    val englishName: String?,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String?,
    @SerializedName("IsAlias")
    val isAlias: Boolean?
)