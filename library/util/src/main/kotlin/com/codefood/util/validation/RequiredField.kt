package com.codefood.util.validation

internal class RequiredField<T>(
    private val alsoNull: T? = null,
    private val nullMessage: String,
    rules: List<Rule<T>>,
    value: T? = null
) : BaseField<T>(rules, value) {
    override val isValid: Boolean
        get() = isDirty && super.isValid

    override val error: String?
        get() {
            if (!isDirty) return null
            if (value == null || value == alsoNull) return nullMessage
            return value?.let(::validate)
        }
}
