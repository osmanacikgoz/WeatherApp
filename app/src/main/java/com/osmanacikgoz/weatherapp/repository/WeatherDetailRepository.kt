package com.osmanacikgoz.weatherapp.repository

import androidx.lifecycle.MutableLiveData
import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.data.Repository
import com.osmanacikgoz.weatherapp.dataSource.WeatherDetailDataSource
import com.osmanacikgoz.weatherapp.model.entity.WeatherDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherDetailRepository constructor(
    private val weatherDetailDataSource: WeatherDetailDataSource
) :Repository{
    override var isLoading: Boolean = false

    suspend fun loadDetail(error:(String) ->Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<WeatherDetail>>()

        weatherDetailDataSource.fetchWeatherDetail { response ->
            isLoading = false
            when(response) {
                is ApiResponse.Success-> {
                    response.data?.let { data->
                        data.map {  }
                    }
                }
            }
        }
    }

}