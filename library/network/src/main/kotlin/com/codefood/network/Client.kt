package com.codefood.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal object Client {
    @JvmStatic
    internal fun build(networkConfig: NetworkConfig): OkHttpClient = OkHttpClient.Builder()
        .apply {
            if (networkConfig.printLogs)
                addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
        }
        .build()
}