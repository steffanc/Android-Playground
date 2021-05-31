package com.playground.app.common.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> AppCompatActivity.createViewModel(
    bundle: Bundle? = null,
    crossinline block: (handle: SavedStateHandle) -> T
): T {
    return ViewModelProvider(this, object : AbstractSavedStateViewModelFactory(this, bundle) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return block(handle) as T
        }
    }).get(T::class.java)
}
