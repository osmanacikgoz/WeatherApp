package com.osmanacikgoz.weatherapp.network.local.entity

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchItemEntity(
    val version: Int?,
    @PrimaryKey
    val key: String = "",
    val type: String?,
    val rank: Int?,
    val localizedName: String,
    val englishName: String?,
    val primaryPostalCode: String?,
    val isAlias: Boolean?

) : Parcelable
