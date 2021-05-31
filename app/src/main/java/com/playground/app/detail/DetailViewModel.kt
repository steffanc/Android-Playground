package com.playground.app.detail

import androidx.lifecycle.SavedStateHandle
import com.playground.app.common.BaseState
import com.playground.app.common.BaseViewModel
import com.playground.app.common.PlaygroundRepository

class DetailViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository: PlaygroundRepository
) : BaseViewModel<DetailViewModel.State>(State()) {

    data class State(
        val isLoading: Boolean = false
    ) : BaseState
}
