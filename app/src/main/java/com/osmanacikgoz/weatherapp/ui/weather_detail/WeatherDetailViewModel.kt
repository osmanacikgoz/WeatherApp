package com.osmanacikgoz.weatherapp.ui.weather_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.weatherapp.network.api.response.CurrentConditionsResponse
import com.osmanacikgoz.weatherapp.network.api.response.OneDailyForecastsResponse
import com.osmanacikgoz.weatherapp.repository.WeatherDetailRepository
import kotlinx.coroutines.launch

class WeatherDetailViewModel(
    private val detailRepository: WeatherDetailRepository
) : ViewModel() {
    private val _currentConditionsLiveData = MutableLiveData<CurrentConditionsResponse?>()
    val currentConditionsLiveData get() = _currentConditionsLiveData

    private val _oneDailyForecastLiveData = MutableLiveData<OneDailyForecastsResponse?>()
    val oneDailyForecastLiveData get() = _oneDailyForecastLiveData

    fun getCurrentConditions(locationKey: String) {
        viewModelScope.launch {
            detailRepository.getCurrentCondition(locationKey) { currentConditions ->
                _currentConditionsLiveData.postValue(currentConditions)
            }
        }
    }

    fun getOneDailyForecast(locationKey: String) {
        viewModelScope.launch {
            detailRepository.getOneDailyForecast(locationKey) {oneDailyForecast ->
                _oneDailyForecastLiveData.postValue(oneDailyForecast)
            }
        }
    }
}