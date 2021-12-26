package com.osmanacikgoz.weatherapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.network.api.response.AutoCompleteSearchResponse
import com.osmanacikgoz.weatherapp.network.local.SearchDao
import com.osmanacikgoz.weatherapp.network.local.entity.SearchItem
import com.osmanacikgoz.weatherapp.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
) : ViewModel() {

    var searchParam: String? = null

    private val _searchItemsLiveData = MutableLiveData<AutoCompleteSearchResponse?>()
    val searchItemsLiveData get() = _searchItemsLiveData

    fun autoCompleteSearch(searchParam: String) {
        viewModelScope.launch {
            searchRepository.autoCompleteSearch(searchParam) { searchItems ->
                _searchItemsLiveData.postValue(searchItems)
            }
        }
    }

    fun insertSearchItem(searchItem: SearchItem) {
        viewModelScope.launch {
            searchRepository.insertSearchItem(searchItem)
        }
    }

    fun getSearchItems(onResult: (searchItems: List<SearchItem>) -> Unit) {
        viewModelScope.launch {
            onResult.invoke(searchRepository.getSearchItems())
        }
    }

}