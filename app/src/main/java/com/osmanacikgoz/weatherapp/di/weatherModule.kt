package com.osmanacikgoz.weatherapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.osmanacikgoz.weatherapp.api.RequestInterceptor
import com.osmanacikgoz.weatherapp.api.WeatherServices
import com.osmanacikgoz.weatherapp.const.Const
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherModule = module {
    val searchModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        }

        single {
            Retrofit.Builder()
                .client(get())
                .baseUrl(Const.LOCATION_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        single {
            get<Retrofit>().create(WeatherServices::class.java)

        }
    }
}