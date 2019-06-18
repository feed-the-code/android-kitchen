package com.codefood.arch

import android.os.Handler
import android.os.Looper

fun runOnMainThread(from: Thread = Thread.currentThread(), action: () -> Unit) {
    val mainLooper = Looper.getMainLooper()
    if (mainLooper.thread == from) {
        action()
    } else {
        Handler(mainLooper).post(action)
    }
}
