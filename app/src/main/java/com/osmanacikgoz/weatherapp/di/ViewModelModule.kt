package com.osmanacikgoz.weatherapp.di

import com.osmanacikgoz.weatherapp.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
viewModel { WeatherViewModel(get()) }
}