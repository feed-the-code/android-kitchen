package com.codefood.arch

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val cause: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[cause=$cause]"
        }
    }

    infix fun <R : Any> then(f: (T) -> Result<R>): Result<R> = when (this) {
        is Success -> f(data)
        is Error -> this
    }

    fun <R : Any> map(f: (T) -> R): Result<R> = when (this) {
        is Success -> Success(f(data))
        is Error -> this
    }

    fun mapError(f: (Exception) -> Exception): Result<T> = when (this) {
        is Success -> this
        is Error -> Error(f(cause))
    }

    infix fun otherwise(f: (Throwable) -> Unit) {
        if (this is Error) f(cause)
    }

    infix fun run(f: (T) -> Unit) = also { if (this is Success) f(data) }
}

infix fun <T : Any, R : Any> T.into(f: (T) -> Result<R>): Result<R> = Result.Success(this).then(f)