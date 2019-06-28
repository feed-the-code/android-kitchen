package com.codefood.kitchen.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

fun ImageView.loadImage(url: String, builder: RequestBuilder<Drawable>.() -> Unit = {}) {
    Glide.with(this)
        .load(url)
        .apply(builder)
        .into(this)
}