package com.codefood.kitchen.feature

import android.content.Context
import android.content.Intent

interface AuthFeature : Screen {
    override fun intent(from: Context): Intent
}