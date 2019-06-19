package com.codefood.arch

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T : Any> {

    open val data: T? = null

    data class Success<out T : Any>(override val data: T) : Result<T>()
    data class Error<out T : Any>(val cause: Exception, override val data: T? = null) : Result<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[cause=$cause]"
        }
    }

    infix fun <R : Any> then(f: (T) -> R): Result<R> = when (this) {
        is Success -> Success(f(data))
        is Error -> Error(cause, data?.let(f))
    }

    infix fun otherwise(f: (T?, Exception) -> Exception): Result<T> = when (this) {
        is Success -> this
        is Error -> Error(f(data, cause), data)
    }
}