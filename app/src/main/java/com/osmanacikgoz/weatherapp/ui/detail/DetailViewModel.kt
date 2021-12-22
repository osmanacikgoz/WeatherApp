package com.osmanacikgoz.weatherapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.model.TestWeather
import com.osmanacikgoz.weatherapp.model.entity.WeatherDetail
import com.osmanacikgoz.weatherapp.repository.WeatherDetailRepository
import kotlinx.coroutines.launch

class DetailViewModel(
    private val weatherDetailRepository: WeatherDetailRepository
) : ViewModel() {
    private val _detailLiveData = MutableLiveData<List<TestWeather>>()
    val detailLiveData get() = _detailLiveData

    fun weatherDetail(locationKey: String) {
        viewModelScope.launch {
            weatherDetailRepository.detailCity(locationKey) {
                _detailLiveData.postValue(it)

            }
        }
    }
}