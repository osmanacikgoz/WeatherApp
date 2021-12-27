package com.osmanacikgoz.weatherapp.di

import com.osmanacikgoz.weatherapp.ui.main.MainViewModel
import com.osmanacikgoz.weatherapp.ui.search.SearchViewModel
import com.osmanacikgoz.weatherapp.ui.weather_detail.WeatherDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { WeatherDetailViewModel(get()) }
}