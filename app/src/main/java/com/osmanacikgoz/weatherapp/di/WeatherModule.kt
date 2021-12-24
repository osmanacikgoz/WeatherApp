package com.osmanacikgoz.weatherapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.osmanacikgoz.weatherapp.api.RequestInterceptor
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.const.Const
import com.osmanacikgoz.weatherapp.dataSource.WeatherDataSource
import com.osmanacikgoz.weatherapp.dataSource.WeatherDetailDataSource
import com.osmanacikgoz.weatherapp.dataSource.WeatherGeoDataSource
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherModule = module {
    single(named("weather_okhttp")) {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    single(named("weather_retrofit")) {
        Retrofit.Builder()
            .client(get(named("weather_okhttp")))
            .baseUrl(Const.WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>(named("weather_retrofit")).create(WeatherServices::class.java) }

    single { WeatherDataSource(get()) }
    single { WeatherDetailDataSource(get()) }
    single { WeatherGeoDataSource(get()) }
}
