package com.codefood.util.validation

interface Rule<T> {
    fun validate(input: T): String?

    companion object {
        operator fun <T> invoke(impl: (T) -> String?): Rule<T> = object : Rule<T> {
            override fun validate(input: T): String? = impl(input)
        }
    }
}