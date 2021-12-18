package com.osmanacikgoz.weatherapp.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class SearchItemEntity(
    @SerializedName("ID")
    val id: String,
    @SerializedName("LocalizedName")
    @PrimaryKey
    val localizedName: String?,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("Level")
    val level: Int,
    @SerializedName("LocalizedType")
    val localizedType: String,
    @SerializedName("EnglishType")
    val englishType: String,
    @SerializedName("CountryID")
    val countryID: String,
    var addCity:Boolean = false,
    var isCurrentCity: Boolean = false

) : Parcelable
