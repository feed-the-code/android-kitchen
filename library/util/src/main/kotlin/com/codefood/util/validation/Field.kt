package com.codefood.util.validation

import com.codefood.util.ListBuilder

interface Field<T> {
    var isDirty: Boolean
    val isValid: Boolean
    val value: T?
    val error: String?

    fun input(value: T)

    interface Builder<T> {
        fun build(): Field<T>

        class Required<T> : Builder<T> {
            var value: T? = null
            var alsoNull: T? = null
            var message: String = ""
            var rules: List<Rule<T>> = emptyList()

            fun rules(block: ListBuilder<Rule<T>>.() -> Unit) {
                rules = ListBuilder<Rule<T>>().apply(block).build()
            }

            override fun build(): Field<T> = RequiredField(
                alsoNull = alsoNull,
                nullMessage = message,
                rules = rules,
                value = value
            )
        }

        class Optional<T> : Builder<T?> {
            var value: T? = null
            var rules: List<Rule<T?>> = emptyList()

            fun rules(block: ListBuilder<Rule<T?>>.() -> Unit) {
                rules = ListBuilder<Rule<T?>>().apply(block).build()
            }

            override fun build(): Field<T?> = OptionalField(rules, value)
        }
    }

    companion object {
        fun <T> required(block: Builder.Required<T>.() -> Unit): Field<T> = Builder.Required<T>().apply(block).build()
        fun <T> optional(block: Builder.Optional<T>.() -> Unit): Field<T?> = Builder.Optional<T>().apply(block).build()
    }
}