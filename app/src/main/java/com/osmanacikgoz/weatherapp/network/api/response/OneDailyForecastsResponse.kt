package com.osmanacikgoz.weatherapp.network.api.response


import com.google.gson.annotations.SerializedName

data class OneDailyForecastsResponse(
    @SerializedName("Headline")
    val headline: Headline?,
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecast?>?
) {
    data class Headline(
        @SerializedName("EffectiveDate")
        val effectiveDate: String?,
        @SerializedName("EffectiveEpochDate")
        val effectiveEpochDate: Int?,
        @SerializedName("Severity")
        val severity: Int?,
        @SerializedName("Text")
        val text: String?,
        @SerializedName("Category")
        val category: String?,
        @SerializedName("EndDate")
        val endDate: Any?,
        @SerializedName("EndEpochDate")
        val endEpochDate: Any?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("Link")
        val link: String?
    )

    data class DailyForecast(
        @SerializedName("Date")
        val date: String?,
        @SerializedName("EpochDate")
        val epochDate: Int?,
        @SerializedName("Temperature")
        val temperature: Temperature?,
        @SerializedName("Day")
        val day: Day?,
        @SerializedName("Night")
        val night: Night?,
        @SerializedName("Sources")
        val sources: List<String?>?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("Link")
        val link: String?
    ) {
        data class Temperature(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
                @SerializedName("Value")
                val value: Int?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Maximum(
                @SerializedName("Value")
                val value: Int?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )
        }

        data class Day(
            @SerializedName("Icon")
            val ıcon: Int?,
            @SerializedName("IconPhrase")
            val ıconPhrase: String?,
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean?
        )

        data class Night(
            @SerializedName("Icon")
            val ıcon: Int?,
            @SerializedName("IconPhrase")
            val ıconPhrase: String?,
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean?
        )
    }
}