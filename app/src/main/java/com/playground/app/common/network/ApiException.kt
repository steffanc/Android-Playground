package com.playground.app.common.network

/**
 * Exception for an unexpected, non-2xx HTTP response.
 */
class ApiException : Exception {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}

