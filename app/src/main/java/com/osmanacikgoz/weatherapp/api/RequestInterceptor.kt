package com.osmanacikgoz.weatherapp.api

import com.osmanacikgoz.weatherapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder
            .addHeader("Authorization","Bearer ${BuildConfig.API_KEY}")
            .build()

        return chain.proceed(request)
    }
}