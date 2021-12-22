package com.osmanacikgoz.weatherapp.model


import com.google.gson.annotations.SerializedName

data class TestWeather(
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
        val endDate: String?,
        @SerializedName("EndEpochDate")
        val endEpochDate: Int?,
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
        @SerializedName("Sun")
        val sun: Sun?,
        @SerializedName("Moon")
        val moon: Moon?,
        @SerializedName("Temperature")
        val temperature: Temperature?,
        @SerializedName("RealFeelTemperature")
        val realFeelTemperature: RealFeelTemperature?,
        @SerializedName("RealFeelTemperatureShade")
        val realFeelTemperatureShade: RealFeelTemperatureShade?,
        @SerializedName("HoursOfSun")
        val hoursOfSun: Double?,
        @SerializedName("DegreeDaySummary")
        val degreeDaySummary: DegreeDaySummary?,
        @SerializedName("AirAndPollen")
        val airAndPollen: List<AirAndPollen?>?,
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
        data class Sun(
            @SerializedName("Rise")
            val rise: String?,
            @SerializedName("EpochRise")
            val epochRise: Int?,
            @SerializedName("Set")
            val `set`: String?,
            @SerializedName("EpochSet")
            val epochSet: Int?
        )

        data class Moon(
            @SerializedName("Rise")
            val rise: String?,
            @SerializedName("EpochRise")
            val epochRise: Int?,
            @SerializedName("Set")
            val `set`: String?,
            @SerializedName("EpochSet")
            val epochSet: Int?,
            @SerializedName("Phase")
            val phase: String?,
            @SerializedName("Age")
            val age: Int?
        )

        data class Temperature(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Maximum(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )
        }

        data class RealFeelTemperature(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Phrase")
                val phrase: String?
            )

            data class Maximum(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Phrase")
                val phrase: String?
            )
        }

        data class RealFeelTemperatureShade(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Phrase")
                val phrase: String?
            )

            data class Maximum(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Phrase")
                val phrase: String?
            )
        }

        data class DegreeDaySummary(
            @SerializedName("Heating")
            val heating: Heating?,
            @SerializedName("Cooling")
            val cooling: Cooling?
        ) {
            data class Heating(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Cooling(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )
        }

        data class AirAndPollen(
            @SerializedName("Name")
            val name: String?,
            @SerializedName("Value")
            val value: Int?,
            @SerializedName("Category")
            val category: String?,
            @SerializedName("CategoryValue")
            val categoryValue: Int?,
            @SerializedName("Type")
            val type: String?
        )

        data class Day(
            @SerializedName("Icon")
            val ıcon: Int?,
            @SerializedName("IconPhrase")
            val ıconPhrase: String?,
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean?,
            @SerializedName("ShortPhrase")
            val shortPhrase: String?,
            @SerializedName("LongPhrase")
            val longPhrase: String?,
            @SerializedName("PrecipitationProbability")
            val precipitationProbability: Int?,
            @SerializedName("ThunderstormProbability")
            val thunderstormProbability: Int?,
            @SerializedName("RainProbability")
            val rainProbability: Int?,
            @SerializedName("SnowProbability")
            val snowProbability: Int?,
            @SerializedName("IceProbability")
            val ıceProbability: Int?,
            @SerializedName("Wind")
            val wind: Wind?,
            @SerializedName("WindGust")
            val windGust: WindGust?,
            @SerializedName("TotalLiquid")
            val totalLiquid: TotalLiquid?,
            @SerializedName("Rain")
            val rain: Rain?,
            @SerializedName("Snow")
            val snow: Snow?,
            @SerializedName("Ice")
            val ıce: Ice?,
            @SerializedName("HoursOfPrecipitation")
            val hoursOfPrecipitation: Double?,
            @SerializedName("HoursOfRain")
            val hoursOfRain: Double?,
            @SerializedName("HoursOfSnow")
            val hoursOfSnow: Double?,
            @SerializedName("HoursOfIce")
            val hoursOfIce: Double?,
            @SerializedName("CloudCover")
            val cloudCover: Int?,
            @SerializedName("Evapotranspiration")
            val evapotranspiration: Evapotranspiration?,
            @SerializedName("SolarIrradiance")
            val solarIrradiance: SolarIrradiance?
        ) {
            data class Wind(
                @SerializedName("Speed")
                val speed: Speed?,
                @SerializedName("Direction")
                val direction: Direction?
            ) {
                data class Speed(
                    @SerializedName("Value")
                    val value: Double?,
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?
                )

                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("Localized")
                    val localized: String?,
                    @SerializedName("English")
                    val english: String?
                )
            }

            data class WindGust(
                @SerializedName("Speed")
                val speed: Speed?,
                @SerializedName("Direction")
                val direction: Direction?
            ) {
                data class Speed(
                    @SerializedName("Value")
                    val value: Double?,
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?
                )

                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("Localized")
                    val localized: String?,
                    @SerializedName("English")
                    val english: String?
                )
            }

            data class TotalLiquid(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Rain(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Snow(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Ice(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Evapotranspiration(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class SolarIrradiance(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )
        }

        data class Night(
            @SerializedName("Icon")
            val ıcon: Int?,
            @SerializedName("IconPhrase")
            val ıconPhrase: String?,
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean?,
            @SerializedName("ShortPhrase")
            val shortPhrase: String?,
            @SerializedName("LongPhrase")
            val longPhrase: String?,
            @SerializedName("PrecipitationProbability")
            val precipitationProbability: Int?,
            @SerializedName("ThunderstormProbability")
            val thunderstormProbability: Int?,
            @SerializedName("RainProbability")
            val rainProbability: Int?,
            @SerializedName("SnowProbability")
            val snowProbability: Int?,
            @SerializedName("IceProbability")
            val ıceProbability: Int?,
            @SerializedName("Wind")
            val wind: Wind?,
            @SerializedName("WindGust")
            val windGust: WindGust?,
            @SerializedName("TotalLiquid")
            val totalLiquid: TotalLiquid?,
            @SerializedName("Rain")
            val rain: Rain?,
            @SerializedName("Snow")
            val snow: Snow?,
            @SerializedName("Ice")
            val ıce: Ice?,
            @SerializedName("HoursOfPrecipitation")
            val hoursOfPrecipitation: Double?,
            @SerializedName("HoursOfRain")
            val hoursOfRain: Double?,
            @SerializedName("HoursOfSnow")
            val hoursOfSnow: Double?,
            @SerializedName("HoursOfIce")
            val hoursOfIce: Double?,
            @SerializedName("CloudCover")
            val cloudCover: Int?,
            @SerializedName("Evapotranspiration")
            val evapotranspiration: Evapotranspiration?,
            @SerializedName("SolarIrradiance")
            val solarIrradiance: SolarIrradiance?
        ) {
            data class Wind(
                @SerializedName("Speed")
                val speed: Speed?,
                @SerializedName("Direction")
                val direction: Direction?
            ) {
                data class Speed(
                    @SerializedName("Value")
                    val value: Double?,
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?
                )

                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("Localized")
                    val localized: String?,
                    @SerializedName("English")
                    val english: String?
                )
            }

            data class WindGust(
                @SerializedName("Speed")
                val speed: Speed?,
                @SerializedName("Direction")
                val direction: Direction?
            ) {
                data class Speed(
                    @SerializedName("Value")
                    val value: Double?,
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?
                )

                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("Localized")
                    val localized: String?,
                    @SerializedName("English")
                    val english: String?
                )
            }

            data class TotalLiquid(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Rain(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Snow(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Ice(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class Evapotranspiration(
                @SerializedName("Value")
                val value: Double?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?
            )

            data class SolarIrradiance(
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