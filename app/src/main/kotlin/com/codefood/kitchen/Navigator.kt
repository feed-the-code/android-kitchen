package com.codefood.kitchen

import android.content.Context

interface Navigator {
    fun entry(from: Context)
    fun home(from: Context)
}