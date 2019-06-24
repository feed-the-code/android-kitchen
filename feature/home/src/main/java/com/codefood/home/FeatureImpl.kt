package com.codefood.home

import android.content.Context
import android.content.Intent
import com.codefood.kitchen.feature.HomeFeature

object FeatureImpl : HomeFeature {
    override fun homeIntent(from: Context): Intent = Intent(from, MainActivity::class.java)
}