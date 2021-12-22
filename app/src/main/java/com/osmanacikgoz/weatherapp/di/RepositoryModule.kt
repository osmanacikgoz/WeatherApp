package com.osmanacikgoz.weatherapp.di

import com.osmanacikgoz.weatherapp.repository.WeatherCityRepository
import com.osmanacikgoz.weatherapp.repository.WeatherDetailRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherCityRepository(get(), get()) }
    single { WeatherDetailRepository(get()) }
}