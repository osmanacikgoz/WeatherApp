package com.osmanacikgoz.weatherapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.model.entity.SearchItem
import com.osmanacikgoz.weatherapp.repository.WeatherCityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(
    private val weatherCityRepository: WeatherCityRepository,
) : ViewModel() {

    private val _searchCitiesLiveData = MutableLiveData<List<SearchItem>>()
    val searchCitiesLiveData get() = _searchCitiesLiveData
    val getAllSearchedCity = weatherCityRepository.getAllSearchedCity

    fun searchByCity(searchParam: String) {
        viewModelScope.launch {
            weatherCityRepository.searchCity(searchParam) {
                _searchCitiesLiveData.postValue(it)
            }
        }
    }

    fun deleteFirstCity(){
        viewModelScope.launch(Dispatchers.IO) {
            weatherCityRepository.deleteFirstCity()
        }
    }

    fun insertSearchCity(searchCity: SearchItem) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherCityRepository.insertSearchCity(searchCity)
            if (getAllSearchedCity.value?.size == 5){
                deleteFirstCity()
            }
        }
    }
}