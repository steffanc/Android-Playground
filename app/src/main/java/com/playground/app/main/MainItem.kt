package com.playground.app.main

import com.playground.app.common.BaseItem

sealed class MainItem : BaseItem {
    data class Item(override val id: String) : MainItem()
}
