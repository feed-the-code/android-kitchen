package com.codefood.util.validation

internal class OptionalField<T>(
    rules: List<Rule<T?>>,
    value: T? = null
) : BaseField<T?>(rules, value)