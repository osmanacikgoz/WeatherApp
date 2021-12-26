package com.osmanacikgoz.weatherapp.network.api.response


import com.google.gson.annotations.SerializedName

class AutoCompleteSearchResponse : ArrayList<AutoCompleteSearchResponse.AutoCompleteSearchResponseItem>(){
    data class AutoCompleteSearchResponseItem(
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
        @SerializedName("Country")
        val country: Country?,
        @SerializedName("AdministrativeArea")
        val administrativeArea: AdministrativeArea?
    ) {
        data class Country(
            @SerializedName("ID")
            val ıD: String?,
            @SerializedName("LocalizedName")
            val localizedName: String?
        )
    
        data class AdministrativeArea(
            @SerializedName("ID")
            val ıD: String?,
            @SerializedName("LocalizedName")
            val localizedName: String?
        )
    }
}