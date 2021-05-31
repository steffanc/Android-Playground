package com.playground.app.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.playground.app.R
import com.playground.app.common.BaseListAdapter
import com.playground.app.common.BaseViewHolder
import com.playground.app.databinding.MainItemViewBinding

class MainAdapter(private val listener: Listener) : BaseListAdapter<MainItem>() {

    interface Listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MainItem> {
        val inflater = LayoutInflater.from(parent.context)

        @Suppress("UNCHECKED_CAST")
        return when (viewType) {
            R.layout.main_item_view -> MainViewHolder(MainItemViewBinding.inflate(inflater))
            else -> throw IllegalStateException("unexpected view type: $viewType")

        } as BaseViewHolder<MainItem>
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainItem.Item -> R.layout.main_item_view
        }
    }

    private class MainViewHolder(private val binding: MainItemViewBinding) :
        BaseViewHolder<MainItem.Item>(binding.root) {

        override fun bind(item: MainItem.Item) {
            TODO("Not yet implemented")
        }
    }
}
