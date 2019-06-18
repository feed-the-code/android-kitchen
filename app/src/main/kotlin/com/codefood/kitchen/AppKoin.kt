package com.codefood.kitchen

import com.codefood.network.networkModule
import org.koin.dsl.koinApplication

val koinApp = koinApplication {
    modules(listOf(appModule, networkModule))
}