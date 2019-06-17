package com.codefood.arch

/**
 * Stateful container for any kind of async operation (e.g. network responses)
 * @param oldStatus Previous status of the given entity. On initial call this will be [Status.LOADING]
 * @param status The current status of the given entity.
 * @param data The actual data. Not exclusive with error in order to model requests.
 * @param error The most immediate error. If status is not [Status.FAILED], it could be some warning.
 */
data class Stateful<T>(
    val oldStatus: Status,
    val status: Status,
    val data: T? = null,
    val error: Throwable? = null
)

enum class Status {
    LOADING, SUCCESS, FAILED
}