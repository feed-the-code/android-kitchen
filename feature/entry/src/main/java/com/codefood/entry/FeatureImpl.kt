package com.codefood.entry

import android.content.Context
import android.content.Intent
import com.codefood.entry.ui.login.LoginActivity
import com.codefood.kitchen.feature.AuthFeature

object FeatureImpl : AuthFeature {
    override fun entryIntent(from: Context): Intent = Intent(from, LoginActivity::class.java)
}