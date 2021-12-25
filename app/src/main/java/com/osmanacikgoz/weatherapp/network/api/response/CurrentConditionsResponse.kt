package com.osmanacikgoz.weatherapp.network.api.response

import com.google.gson.annotations.SerializedName

class CurrentConditionsResponse :
    ArrayList<CurrentConditionsResponse.CurrentConditionsResponseItem>() {
    data class CurrentConditionsResponseItem(
        @SerializedName("LocalObservationDateTime")
        val localObservationDateTime: String?,
        @SerializedName("EpochTime")
        val epochTime: Int?,
        @SerializedName("WeatherText")
        val weatherText: String?,
        @SerializedName("WeatherIcon")
        val weatherIcon: Int?,
        @SerializedName("HasPrecipitation")
        val hasPrecipitation: Boolean?,
        @SerializedName("PrecipitationType")
        val precipitationType: Any?,
        @SerializedName("IsDayTime")
        val ısDayTime: Boolean?,
        @SerializedName("Temperature")
        val temperature: Temperature?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("Link")
        val link: String?
    ) {
        data class Temperature(
            @SerializedName("Metric")
            val metric: Metric?,
            @SerializedName("Imperial")
            val ımperial: Imperial?
        ) {
            data class Metric(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Imperial(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )
        }
    }
}