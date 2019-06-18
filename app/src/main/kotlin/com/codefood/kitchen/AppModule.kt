package com.codefood.kitchen

import org.koin.dsl.module

internal val appModule = module {
    single { AppConfig.networkConfig }
    single { Navigator() }
}