package com.codefood.kitchen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject

internal class SplashActivity : AppCompatActivity() {
    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        navigator.entry(from = this)
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }
}