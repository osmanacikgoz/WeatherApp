package com.osmanacikgoz.weatherapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.model.entity.WeatherDetail
import com.osmanacikgoz.weatherapp.model.response.GeoPositionResponse
import com.osmanacikgoz.weatherapp.repository.WeatherDetailRepository
import com.osmanacikgoz.weatherapp.repository.WeatherGeoRepository
import kotlinx.coroutines.launch

class DetailViewModel(
    private val weatherDetailRepository: WeatherDetailRepository,
    private val geoRepository: WeatherGeoRepository
) : ViewModel() {
    private val _detailLiveData = MutableLiveData<List<WeatherDetail>>()
    val detailLiveData get() = _detailLiveData

    private val _geoLiveData = MutableLiveData<List<GeoPositionResponse>>()
    val geoLiveData get() = _geoLiveData

    fun weatherDetail(locationKey: String) {
        viewModelScope.launch {
            weatherDetailRepository.detailCity(locationKey) {
                _detailLiveData.postValue(it)

            }
        }
    }

    fun geoDetail(latLang:String) {
        viewModelScope.launch {
            geoRepository.getGeo(latLang){
                _geoLiveData.postValue(it)
            }
        }
    }
}