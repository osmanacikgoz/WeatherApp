package com.osmanacikgoz.weatherapp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Imperial(
    @SerializedName("Value")
    val value: Double?,
    @SerializedName("Unit")
    val unit: String?,
    @SerializedName("UnitType")
    val unitType: Int?
):Parcelable
