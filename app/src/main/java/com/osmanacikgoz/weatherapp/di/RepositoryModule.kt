package com.osmanacikgoz.weatherapp.di

import com.osmanacikgoz.weatherapp.repository.WeatherCityRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherCityRepository(get()) }
}