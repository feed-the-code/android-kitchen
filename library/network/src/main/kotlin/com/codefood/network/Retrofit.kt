package com.codefood.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

internal object Retrofit {
    @JvmStatic
    fun build(networkConfig: NetworkConfig, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(networkConfig.baseUrl)
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .client(client)
        .build()
}