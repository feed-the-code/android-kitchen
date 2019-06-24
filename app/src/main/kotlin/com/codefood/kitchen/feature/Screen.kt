package com.codefood.kitchen.feature

import android.content.Context
import android.content.Intent

interface Screen {
    fun intent(from: Context): Intent
}