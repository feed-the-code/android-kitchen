package com.codefood.network

import org.koin.dsl.module

val networkModule = module {
    single { Client.build(get()) }
    single { Retrofit.build(get(), get()) }
}