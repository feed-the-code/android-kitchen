package com.codefood.kitchen

import org.koin.dsl.koinApplication

val koinApp = koinApplication {
    modules(listOf(appModule))
}