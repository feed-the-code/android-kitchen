package com.codefood.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

infix fun ViewGroup.inflate(@LayoutRes layout: Int): View =
    LayoutInflater.from(context)
        .inflate(layout, this, false)


infix fun ViewGroup.inflateAttached(@LayoutRes layout: Int): View =
    LayoutInflater.from(context)
        .inflate(layout, this, true)