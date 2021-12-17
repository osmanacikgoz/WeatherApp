package com.osmanacikgoz.weatherapp.app

import android.app.Application
import com.osmanacikgoz.weatherapp.di.searchModule
import com.osmanacikgoz.weatherapp.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)

            modules(listOf(searchModule, weatherModule))

        }
    }
}