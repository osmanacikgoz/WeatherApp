package com.osmanacikgoz.weatherapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.osmanacikgoz.weatherapp.base.Const
import com.osmanacikgoz.weatherapp.network.api.RequestInterceptor
import com.osmanacikgoz.weatherapp.network.api.WeatherServices
import com.osmanacikgoz.weatherapp.network.api.client.SearchClient
import com.osmanacikgoz.weatherapp.network.api.client.MainWeatherClient
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(Const.WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(WeatherServices::class.java) }

    single { SearchClient(get()) }

    single { MainWeatherClient(get()) }

}
