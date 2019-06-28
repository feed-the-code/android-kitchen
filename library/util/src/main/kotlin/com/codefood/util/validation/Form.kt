package com.codefood.util.validation

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

interface Form {
    val isValid
        get() = fieldMembers
            .all { it.isValid }

    fun validate() {
        fieldMembers
            .forEach { it.isDirty = true }
    }
}

@Suppress("UNCHECKED_CAST")
internal val Form.fieldMembers
    get() = (this::class as KClass<Form>)
        .declaredMemberProperties
        .mapNotNull { it.get(this) as? Field<*> }
