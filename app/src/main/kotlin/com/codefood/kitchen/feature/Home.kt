package com.codefood.kitchen.feature

import android.content.Context
import android.content.Intent

interface Home {
    fun homeIntent(from: Context): Intent
}