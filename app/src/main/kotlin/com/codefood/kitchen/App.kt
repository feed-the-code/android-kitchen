package com.codefood.kitchen

import android.app.Application
import com.codefood.network.networkModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, networkModule))
        }
    }
}