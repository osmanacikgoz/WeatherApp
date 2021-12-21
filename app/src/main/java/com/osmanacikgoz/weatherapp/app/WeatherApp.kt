package com.osmanacikgoz.weatherapp.app

import android.app.Application
import com.osmanacikgoz.weatherapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)

            modules(
                listOf(
                    persistenceModule,
                    searchModule,
                    weatherModule,
                    repositoryModule,
                    viewModelModule
                )
            )

        }
    }
}