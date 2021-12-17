package com.osmanacikgoz.weatherapp.model.network


import com.google.gson.annotations.SerializedName
import com.osmanacikgoz.weatherapp.model.entity.*

class SearchResponse : ArrayList<SearchResponse.SearchResponseItem>(){
    data class SearchResponseItem(
        @SerializedName("Version")
        val version: Int?,
        @SerializedName("Key")
        val key: String?,
        @SerializedName("Type")
        val type: String?,
        @SerializedName("Rank")
        val rank: Int?,
        @SerializedName("LocalizedName")
        val localizedName: String?,
        @SerializedName("EnglishName")
        val englishName: String?,
        @SerializedName("PrimaryPostalCode")
        val primaryPostalCode: String?,
        @SerializedName("Region")
        val region: Region?,
        @SerializedName("Country")
        val country: Country?,
        @SerializedName("AdministrativeArea")
        val administrativeArea: AdministrativeArea?,
        @SerializedName("TimeZone")
        val timeZone: TimeZone?,
        @SerializedName("GeoPosition")
        val geoPosition: GeoPosition?,
        @SerializedName("IsAlias")
        val ısAlias: Boolean?,
        @SerializedName("SupplementalAdminAreas")
        val supplementalAdminAreas: List<Any?>?,
        @SerializedName("DataSets")
        val dataSets: List<String?>?
    )
}