package com.osmanacikgoz.weatherapp.di

import com.osmanacikgoz.weatherapp.repository.SearchRepository
import com.osmanacikgoz.weatherapp.repository.WeatherDetailRepository
import com.osmanacikgoz.weatherapp.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { SearchRepository(searchClient = get(), searchDao = get()) }
    single { WeatherDetailRepository() }
    single { MainRepository(mainWeatherClient = get()) }
}