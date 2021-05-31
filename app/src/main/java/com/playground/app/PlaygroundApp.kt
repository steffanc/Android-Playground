package com.playground.app

import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.playground.app.common.PlaygroundRepository
import com.playground.app.common.network.PlaygroundService
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

class PlaygroundApp : MultiDexApplication() {

    lateinit var repository: PlaygroundRepository

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        RxJavaPlugins.setErrorHandler { throwable: Throwable ->
            if (throwable is UndeliverableException) {
                // Stream has been disposed of and we don't care about exceptions thrown after this happens
                Timber.w(throwable, "Ignoring undeliverable Rx exception")
            } else {
                throw throwable
            }
        }

        val service = Retrofit.Builder()
            .baseUrl("https://s3.amazonaws.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(PlaygroundService::class.java)

        repository = PlaygroundRepository(service)
    }
}
