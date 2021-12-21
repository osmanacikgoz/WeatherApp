package com.osmanacikgoz.weatherapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.model.response.SearchItem
import com.osmanacikgoz.weatherapp.repository.WeatherCityRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(
    private val weatherCityRepository: WeatherCityRepository
) : ViewModel() {

    private val _searchCitiesLiveData = MutableLiveData<List<SearchItem>>()
    val searchCitiesLiveData get() = _searchCitiesLiveData

    fun searchByCity(searchParam: String) {
        viewModelScope.launch {
            weatherCityRepository.searchCity(searchParam) {
                _searchCitiesLiveData.postValue(it)
            }
        }
    }

}