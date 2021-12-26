package com.osmanacikgoz.weatherapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.network.api.response.CurrentConditionsResponse
import com.osmanacikgoz.weatherapp.network.api.response.GeopositionSearchResponse
import com.osmanacikgoz.weatherapp.network.api.response.OneDailyForecastsResponse
import com.osmanacikgoz.weatherapp.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _geoPositionLiveData = MutableLiveData<GeopositionSearchResponse?>()
    val geoPositionLiveData get() = _geoPositionLiveData

    private val _currentConditionsLiveData = MutableLiveData<CurrentConditionsResponse?>()
    val currentConditionsLiveData get() = _currentConditionsLiveData

    private val _oneDailyForecastLiveData = MutableLiveData<OneDailyForecastsResponse?>()
    val oneDailyForecastLiveData get() = _oneDailyForecastLiveData

    fun getGeoPosition(latLang:String) {
        viewModelScope.launch {
            mainRepository.geoPosition(latLang) {geoPositionSearch ->
                _geoPositionLiveData.postValue(geoPositionSearch)
            }
        }
    }

    fun getCurrentConditions(locationKey: String) {
        viewModelScope.launch {
            mainRepository.currentConditions(locationKey) { currentConditions ->
                _currentConditionsLiveData.postValue(currentConditions)
            }
        }
    }

    fun getOneDailyForecast(locationKey: String) {
        viewModelScope.launch {
            mainRepository.getOneDailyForecast(locationKey) {oneDailyForecast ->
                _oneDailyForecastLiveData.postValue(oneDailyForecast)
            }
        }
    }

}