package com.osmanacikgoz.weatherapp.repository

import androidx.lifecycle.MutableLiveData
import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.message
import com.osmanacikgoz.weatherapp.dataSource.WeatherDetailDataSource
import com.osmanacikgoz.weatherapp.model.entity.WeatherDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class WeatherDetailRepository constructor(
    private val weatherDetailDataSource: WeatherDetailDataSource
) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherDetailRepository")

    }

    suspend fun loadDetail(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        var liveData = MutableLiveData<List<WeatherDetail>>()

        weatherDetailDataSource.fetchWeatherDetail { response ->
            isLoading = false
            when (response) {
                is ApiResponse.Success -> {
                    response.data?.let { data ->
                        data.map {
                            liveData.postValue(data)
                        }
                    }
                }
                is ApiResponse.Failure.Error -> error(response.message())
                is ApiResponse.Failure.Exception -> error(response.message())
            }
        }
    }
}