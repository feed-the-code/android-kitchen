package com.codefood.network

import okhttp3.logging.HttpLoggingInterceptor

internal object Logging {
    @JvmStatic
    fun build(networkConfig: NetworkConfig) =
        HttpLoggingInterceptor().apply {
            level =
                if (networkConfig.printLogs) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
        }
}
