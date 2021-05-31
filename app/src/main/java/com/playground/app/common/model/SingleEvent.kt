package com.playground.app.common.model

data class SingleEvent<T>(private val data: T) {
    private var consumed = false

    fun maybeConsume(consumer: (T) -> Unit) {
        if (!consumed) {
            consumed = true
            consumer(data)
        }
    }
}
