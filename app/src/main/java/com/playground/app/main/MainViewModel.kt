package com.playground.app.main

import androidx.lifecycle.SavedStateHandle
import com.playground.app.common.BaseState
import com.playground.app.common.BaseViewModel
import com.playground.app.common.PlaygroundRepository

class MainViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository: PlaygroundRepository
) : BaseViewModel<MainViewModel.State>(State()) {

    data class State(
        val isLoading: Boolean = false
    ) : BaseState
}
