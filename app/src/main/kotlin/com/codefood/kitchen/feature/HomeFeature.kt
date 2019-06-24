package com.codefood.kitchen.feature

import android.content.Context
import android.content.Intent

interface HomeFeature : Screen {
    override fun intent(from: Context): Intent
}