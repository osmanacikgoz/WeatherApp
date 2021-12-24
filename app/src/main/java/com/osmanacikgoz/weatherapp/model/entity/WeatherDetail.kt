package com.osmanacikgoz.weatherapp.model.entity

import com.google.gson.annotations.SerializedName

data class WeatherDetail(

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
@SerializedName("RealFeelTemperature")
val realFeelTemperature: RealFeelTemperature?,
@SerializedName("RealFeelTemperatureShade")
val realFeelTemperatureShade: RealFeelTemperatureShade?,
@SerializedName("RelativeHumidity")
val relativeHumidity: Int?,
@SerializedName("IndoorRelativeHumidity")
val ındoorRelativeHumidity: Int?,
@SerializedName("DewPoint")
val dewPoint: DewPoint?,
@SerializedName("Wind")
val wind: Wind?,
@SerializedName("WindGust")
val windGust: WindGust?,
@SerializedName("UVIndex")
val uVIndex: Int?,
@SerializedName("UVIndexText")
val uVIndexText: String?,
@SerializedName("Visibility")
val visibility: Visibility?,
@SerializedName("ObstructionsToVisibility")
val obstructionsToVisibility: String?,
@SerializedName("CloudCover")
val cloudCover: Int?,
@SerializedName("Ceiling")
val ceiling: Ceiling?,
@SerializedName("Pressure")
val pressure: Pressure?,
@SerializedName("PressureTendency")
val pressureTendency: PressureTendency?,
@SerializedName("Past24HourTemperatureDeparture")
val past24HourTemperatureDeparture: Past24HourTemperatureDeparture?,
@SerializedName("ApparentTemperature")
val apparentTemperature: ApparentTemperature?,
@SerializedName("WindChillTemperature")
val windChillTemperature: WindChillTemperature?,
@SerializedName("WetBulbTemperature")
val wetBulbTemperature: WetBulbTemperature?,
@SerializedName("Precip1hr")
val precip1hr: Precip1hr?,
@SerializedName("PrecipitationSummary")
val precipitationSummary: PrecipitationSummary?,
@SerializedName("TemperatureSummary")
val temperatureSummary: TemperatureSummary?,
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

    data class RealFeelTemperature(
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
            val unitType: Int?,
            @SerializedName("Phrase")
            val phrase: String?
        )

        data class Imperial(
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
            val unitType: Int?,
            @SerializedName("Phrase")
            val phrase: String?
        )

        data class Imperial(
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

    data class DewPoint(
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

    data class Wind(
        @SerializedName("Direction")
        val direction: Direction?,
        @SerializedName("Speed")
        val speed: Speed?
    ) {
        data class Direction(
            @SerializedName("Degrees")
            val degrees: Int?,
            @SerializedName("Localized")
            val localized: String?,
            @SerializedName("English")
            val english: String?
        )

        data class Speed(
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

    data class WindGust(
        @SerializedName("Speed")
        val speed: Speed?
    ) {
        data class Speed(
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

    data class Visibility(
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

    data class Ceiling(
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

    data class Pressure(
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

    data class PressureTendency(
        @SerializedName("LocalizedText")
        val localizedText: String?,
        @SerializedName("Code")
        val code: String?
    )

    data class Past24HourTemperatureDeparture(
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

    data class ApparentTemperature(
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

    data class WindChillTemperature(
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

    data class WetBulbTemperature(
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

    data class Precip1hr(
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

    data class PrecipitationSummary(
        @SerializedName("Precipitation")
        val precipitation: Precipitation?,
        @SerializedName("PastHour")
        val pastHour: PastHour?,
        @SerializedName("Past3Hours")
        val past3Hours: Past3Hours?,
        @SerializedName("Past6Hours")
        val past6Hours: Past6Hours?,
        @SerializedName("Past9Hours")
        val past9Hours: Past9Hours?,
        @SerializedName("Past12Hours")
        val past12Hours: Past12Hours?,
        @SerializedName("Past18Hours")
        val past18Hours: Past18Hours?,
        @SerializedName("Past24Hours")
        val past24Hours: Past24Hours?
    ) {
        data class Precipitation(
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

        data class PastHour(
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

        data class Past3Hours(
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

        data class Past6Hours(
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

        data class Past9Hours(
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

        data class Past12Hours(
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

        data class Past18Hours(
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

        data class Past24Hours(
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

    data class TemperatureSummary(
        @SerializedName("Past6HourRange")
        val past6HourRange: Past6HourRange?,
        @SerializedName("Past12HourRange")
        val past12HourRange: Past12HourRange?,
        @SerializedName("Past24HourRange")
        val past24HourRange: Past24HourRange?
    ) {
        data class Past6HourRange(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
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

            data class Maximum(
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

        data class Past12HourRange(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
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

            data class Maximum(
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

        data class Past24HourRange(
            @SerializedName("Minimum")
            val minimum: Minimum?,
            @SerializedName("Maximum")
            val maximum: Maximum?
        ) {
            data class Minimum(
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

            data class Maximum(
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
}

