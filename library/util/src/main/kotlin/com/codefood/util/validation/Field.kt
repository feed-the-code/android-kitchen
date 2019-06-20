package com.codefood.util.validation

class Field<T>(
    internal val rules: List<Rule<T?>>,
    value: T? = null
) {
    var isDirty: Boolean = false
        internal set

    var value: T? = value
        private set

    val error: String?
        get() {
            if (!isDirty) return null
            for (rule in rules) {
                val result = rule.validate(value)
                if (result != null) {
                    return result
                }
            }
            return null
        }

    fun input(value: T) {
        isDirty = true
        this.value = value
    }
}

