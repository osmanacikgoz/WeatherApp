package com.osmanacikgoz.weatherapp.app

import android.app.Application
import com.osmanacikgoz.weatherapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)
            modules(networkModule)

        }
    }
}