package com.osmanacikgoz.weatherapp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Elevation(
    @SerializedName("Metric")
    val metric: Metric?,
    @SerializedName("Imperial")
    val ımperial: Imperial?
):Parcelable

