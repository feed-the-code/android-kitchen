package com.codefood.kitchen

import android.util.Log
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

inline fun <reified T> KoinComponent.getOrNull(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = try {
    get<T>(qualifier, parameters)
} catch (e: Throwable) {
    Log.d("KoinComponent", "Instance of ${T::class.java.name} not found.")
    null
}

inline fun <reified T> KoinComponent.injectOrNull(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = try {
    inject<T>(qualifier, parameters)
} catch (e: Throwable) {
    Log.d("KoinComponent", "Instance of ${T::class.java.name} not found.")
    null
}