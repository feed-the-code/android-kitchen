package com.codefood.kitchen

import android.content.Context
import android.util.Log
import com.codefood.kitchen.feature.AuthFeature
import com.codefood.kitchen.feature.HomeFeature
import com.codefood.kitchen.feature.ScreenNotInstalledException
import org.koin.core.KoinComponent

internal class NavigatorImpl : KoinComponent, Navigator {
    override fun entry(from: Context) {
        val intent = getOrNull<AuthFeature>()?.intent(from)
            ?: getOrNull<HomeFeature>()?.intent(from)?.also {
                Log.d(
                    "Navigator",
                    "Auth feature not installed, starting guest mode."
                )
            }
            ?: throw Throwable("Nothing is installed. What do you expect?")

        from.startActivity(intent)
    }

    override fun home(from: Context) {
        val intent = getOrNull<HomeFeature>()?.intent(from) ?: throw ScreenNotInstalledException("Home")
        from.startActivity(intent)
    }
}