package com.codefood.network

import org.koin.dsl.module

val networkModule = module {
    single { Logging.build(get()) }
    single { Client.build(getAll()) }
    single { Retrofit.build(get(), get()) }
}