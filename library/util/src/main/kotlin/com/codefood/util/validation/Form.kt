package com.codefood.util.validation

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

interface Form {
    val isValid
        get() = fieldMembers
            .onEach { it.isDirty = true }
            .map { it.error }
            .all { it == null }
}

@Suppress("UNCHECKED_CAST")
internal val Form.fieldMembers
    get() = (this::class as KClass<Form>)
        .declaredMemberProperties
        .mapNotNull { it.get(this) as? Field<*> }
