package com.playground.app.common

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfiniteScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val listener: Listener,
    private val threshold: Int = 0
) : RecyclerView.OnScrollListener() {

    interface Listener {
        fun onScrollThresholdReached()
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (dy > 0) {
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

            if ((visibleItemCount + pastVisibleItems) >= (totalItemCount - threshold)) {
                listener.onScrollThresholdReached()
            }
        }
    }
}
