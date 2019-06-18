package com.codefood.kitchen.feature

import android.content.Context
import android.content.Intent

interface AuthFeature {
    fun entryIntent(from: Context): Intent
}