package com.osmanacikgoz.weatherapp.repository

import com.osmanacikgoz.weatherapp.network.api.ApiResponse
import com.osmanacikgoz.weatherapp.network.api.client.SearchClient
import com.osmanacikgoz.weatherapp.network.api.message
import com.osmanacikgoz.weatherapp.network.api.response.AutoCompleteSearchResponse
import com.osmanacikgoz.weatherapp.network.local.SearchDao
import com.osmanacikgoz.weatherapp.network.local.entity.SearchItem
import timber.log.Timber

class SearchRepository(
    private val searchClient: SearchClient,
    private val searchDao: SearchDao
) : Repository {

    override var isLoading: Boolean = false

    init {
        Timber.d("Injection SearchRepository")
    }

    fun autoCompleteSearch(
        searchParam: String,
        onResult: (AutoCompleteSearchResponse?) -> Unit
    ) {
        isLoading = true

        searchClient.autoCompleteSearch(searchParam) { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Success -> {
                    val searchResponse: AutoCompleteSearchResponse? = apiResponse.data
                    onResult(searchResponse)
                }
                is ApiResponse.Failure.Error -> error(apiResponse.message())
                is ApiResponse.Failure.Exception -> error(apiResponse.message())
            }
        }
    }

    suspend fun insertSearchItem(searchItem: SearchItem) {
        searchDao.insertSearchItem(searchItem)
    }

    fun getSearchItems(): List<SearchItem> {
        return searchDao.getAllSearchedCity()
    }

}
