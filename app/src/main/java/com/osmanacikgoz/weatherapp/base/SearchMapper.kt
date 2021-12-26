package com.osmanacikgoz.weatherapp.base

import com.osmanacikgoz.weatherapp.network.api.response.AutoCompleteSearchResponse
import com.osmanacikgoz.weatherapp.network.local.entity.SearchItem

fun AutoCompleteSearchResponse.AutoCompleteSearchResponseItem.toEntity(): SearchItem {
    return SearchItem(
        key = key ?: "",
        version = version,
        type = type,
        rank = rank,
        localizedName = localizedName,
        createdDate = System.currentTimeMillis()
    )
}