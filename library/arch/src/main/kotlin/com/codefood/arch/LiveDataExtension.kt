package com.codefood.arch

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LifecycleOwner.observe(data: LiveData<T>, crossinline observer: (T?) -> Unit) =
    data.observe(this, Observer { observer(it) })

inline fun <T> LifecycleOwner.observeNotNull(data: LiveData<T>, crossinline observer: (T) -> Unit) =
    this.observe(data) { it?.let(observer) }

inline fun <T> Fragment.observe(data: LiveData<T>, crossinline observer: (T?) -> Unit) =
    this.viewLifecycleOwner.observe(data, observer)

inline fun <T> Fragment.observeNotNull(data: LiveData<T>, crossinline observer: (T) -> Unit) =
    this.viewLifecycleOwner.observeNotNull(data, observer)