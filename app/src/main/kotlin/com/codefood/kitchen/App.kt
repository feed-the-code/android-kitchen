package com.codefood.kitchen

import android.app.Application
import org.koin.core.context.GlobalContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.start(koinApp)
        koinApp.createEagerInstances()
    }
}