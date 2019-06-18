package com.codefood.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal object Client {
    @JvmStatic
    internal fun build(interceptors: List<Interceptor>): OkHttpClient = OkHttpClient.Builder()
        .apply {
            interceptors.forEach { addInterceptor(it) }
        }
        .build()
}