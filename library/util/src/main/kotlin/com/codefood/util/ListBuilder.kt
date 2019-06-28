package com.codefood.util

class ListBuilder<T> {
    private val list = mutableListOf<T>()

    operator fun T.unaryPlus() {
        list.add(this)
    }

    fun build(): List<T> = list
}