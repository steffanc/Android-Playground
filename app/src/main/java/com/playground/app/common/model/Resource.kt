package com.playground.app.common.model

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: Throwable) : Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            Loading -> "Loading"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[error=$error]"
        }
    }
}
