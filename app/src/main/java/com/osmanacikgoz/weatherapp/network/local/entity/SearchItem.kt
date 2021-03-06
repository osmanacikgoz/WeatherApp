package com.osmanacikgoz.weatherapp.network.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "city")
data class SearchItem(
    @SerializedName("Version")
    val version: Int?,
    @PrimaryKey
    @SerializedName("Key")
    val key: String,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Rank")
    val rank: Int?,
    @SerializedName("LocalizedName")
    val localizedName: String?,
    @SerializedName("EnglishName")
    val englishName: String? = null,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String? = null,
    @SerializedName("IsAlias")
    val isAlias: Boolean? = null,
    val createdDate: Long
)