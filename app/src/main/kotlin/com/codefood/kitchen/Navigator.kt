package com.codefood.kitchen

import android.content.Context
import android.util.Log
import com.codefood.kitchen.feature.AuthFeature
import com.codefood.kitchen.feature.HomeFeature
import org.koin.core.KoinComponent

internal class Navigator : KoinComponent {
    fun entry(from: Context) {
        val intent = getOrNull<AuthFeature>()?.entryIntent(from)
            ?: getOrNull<HomeFeature>()?.homeIntent(from)?.also {
                Log.d(
                    "Navigator",
                    "Auth feature not installed, starting guest mode."
                )
            }
            ?: throw Throwable("Nothing is installed. What do you expect?")

        from.startActivity(intent)
    }
}