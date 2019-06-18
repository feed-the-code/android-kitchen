package com.codefood.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

/**
 * Controller which serves as a delegate for LiveData<Stateful<T>> properties.
 * State functions supports only standard use cases, for other configs call [mutate].
 */
class StateController<T> {

    private val liveData: MutableLiveData<Stateful<T>> =
        MutableLiveData()

    var status: Status = Status.LOADING
        private set

    var data: T? = null
        private set

    var error: Throwable? = null
        private set

    fun loading(data: T? = null) {
        this.data = data
        dispatchState(Status.LOADING)
    }

    fun success(data: T) {
        this.data = data
        dispatchState(Status.SUCCESS)
    }

    fun failed(error: Throwable) {
        this.error = error
        dispatchState(Status.FAILED)
    }

    fun mutate(mutation: Mutator.() -> Unit) {
        Mutator(status, data, error).apply(mutation).let { result ->
            this.data = result.data
            this.error = result.error
            dispatchState(result.status)
        }
    }

    /**
     * @param action Any instant operation which produces data of type [T]
     */
    inline fun of(action: () -> T) {
        try {
            success(action())
        } catch (e: Throwable) {
            failed(e)
        }
    }

    /**
     * @param initialData Caller should model expected result of [action] from existing data.
     * @param action Any long operation which produces data of type [T]
     */
    // keep suspend modifier
    suspend inline fun async(initialData: T? = null, action: () -> T) {
        loading(initialData)
        try {
            success(action())
        } catch (e: Throwable) {
            failed(e)
        }
    }

    private fun dispatchState(status: Status) {
        runOnMainThread {
            liveData.value = Stateful(this.status, status, data, error)
        }
        this.status = status
    }

    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): LiveData<Stateful<T>> = liveData

    inner class Mutator(
        var status: Status,
        var data: T?,
        var error: Throwable?
    )
}