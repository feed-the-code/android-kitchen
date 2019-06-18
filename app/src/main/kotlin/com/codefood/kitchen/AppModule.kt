package com.codefood.kitchen

import org.koin.dsl.module

val appModule = module {
    single { AppConfig.networkConfig }
}