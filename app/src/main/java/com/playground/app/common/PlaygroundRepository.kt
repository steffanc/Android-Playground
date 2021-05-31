package com.playground.app.common

import com.playground.app.common.model.Resource
import com.playground.app.common.network.ApiException
import com.playground.app.common.network.PlaygroundService
import com.playground.app.common.network.NetworkException
import retrofit2.Response
import retrofit2.adapter.rxjava3.Result
import timber.log.Timber
import java.io.IOException

class PlaygroundRepository(private val service: PlaygroundService) {

    private fun <T> toResource(result: Result<T>): Resource<T> {
        return if (result.isError) {
            val error = result.error()!!
            if (error is IOException) {
                // Network error, problem with the transport to the remote server
                Timber.d(error)
                Resource.Error(NetworkException(error))
            } else {
                // Configuration error, programmer error
                Timber.e(error)
                throw error
            }
        } else {
            val response: Response<T> = result.response()!!
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                // API error, non-2XX response HTTP response
                Timber.d(response.message())
                Resource.Error(ApiException(response.message()))
            }
        }
    }
}
