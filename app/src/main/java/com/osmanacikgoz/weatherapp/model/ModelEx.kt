package com.osmanacikgoz.weatherapp.model

import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity
import com.osmanacikgoz.weatherapp.model.response.SearchItem

fun SearchItemEntity.toSearchItem(): SearchItem {
    return SearchItem(
        key = key,
        version = version,
        type = type,
        rank = rank,
        localizedName = localizedName,
        englishName = englishName,
        primaryPostalCode = primaryPostalCode,
        isAlias = isAlias
    )
}

fun SearchItemEntity.toSearchItemEntity(): SearchItemEntity {
    return SearchItemEntity(
        key = key,
        version = version,
        type = type,
        rank = rank,
        localizedName = localizedName,
        englishName = englishName,
        primaryPostalCode = primaryPostalCode,
        isAlias = isAlias
    )
}