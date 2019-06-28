package com.codefood.util.validation

internal abstract class BaseField<T>(
    internal val rules: List<Rule<T>>,
    value: T? = null
) : Field<T> {
    override var isDirty: Boolean = false

    override val isValid: Boolean
        get() = error == null

    override var value: T? = value
        protected set

    override val error: String?
        get() {
            if (!isDirty) return null
            return value?.let(this::validate)
        }

    override fun input(value: T) {
        isDirty = true
        this.value = value
    }

    protected fun validate(value: T): String? {
        for (rule in rules) {
            val result = rule.validate(value)
            if (result != null) {
                return result
            }
        }
        return null
    }
}
