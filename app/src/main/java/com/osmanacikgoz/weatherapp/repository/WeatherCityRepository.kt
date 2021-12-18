package com.osmanacikgoz.weatherapp.repository

import androidx.lifecycle.MutableLiveData
import com.osmanacikgoz.weatherapp.api.ApiResponse
import com.osmanacikgoz.weatherapp.api.message
import com.osmanacikgoz.weatherapp.data.Repository
import com.osmanacikgoz.weatherapp.dataSource.WeatherDataSource
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity
import com.osmanacikgoz.weatherapp.room.SearchDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class WeatherCityRepository(
    private val weatherDataSource: WeatherDataSource,
    private val searchDao: SearchDao
) : Repository {
    override var isLoading: Boolean = false

    init {
        Timber.d("Injection WeatherCityRepository")
    }

    suspend fun getSearchByCity(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<SearchItemEntity>>()
        var searchCitys = searchDao.getSearchCits()

        if (searchCitys.isEmpty()) {
            isLoading = true

            weatherDataSource.fetchWeather { response ->
                isLoading = false
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            data.map {
                                searchCitys = data
                                searchDao.insertSearchCity(data)
                                liveData.postValue(searchCitys)
                            }
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }

        }

        liveData.apply { postValue(searchCitys) }
    }
    fun getAddingCity():List<SearchItemEntity> = searchDao.getAddCity()

    fun getCurrentCity():SearchItemEntity?=searchDao.getCurrentSpaceStation()

    fun addCity(addCitys:SearchItemEntity) {
        addCitys.isCurrentCity !=addCitys.isCurrentCity
    }
}
