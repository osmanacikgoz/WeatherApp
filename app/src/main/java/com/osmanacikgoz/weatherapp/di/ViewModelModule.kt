package com.osmanacikgoz.weatherapp.di

import com.osmanacikgoz.weatherapp.ui.detail.DetailViewModel
import com.osmanacikgoz.weatherapp.ui.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}