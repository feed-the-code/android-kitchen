package com.codefood.kitchen.feature

import android.content.Context
import android.content.Intent

interface HomeFeature {
    fun homeIntent(from: Context): Intent
}