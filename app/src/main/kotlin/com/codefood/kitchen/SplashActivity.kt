package com.codefood.kitchen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codefood.kitchen.feature.AuthFeature
import org.koin.android.ext.android.get

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val authFeature: AuthFeature = get()
            startActivity(authFeature.entryIntent(this))
        } catch (e: Throwable) {
            Log.d("Splash", "Auth feature not installed, starting guest mode.")
        }
    }
}