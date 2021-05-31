package com.playground.app.common.model

import android.content.Context
import androidx.annotation.StringRes
import java.io.Serializable

class StringRes(@StringRes val resId: Int, vararg val formatArgs: Any) : Serializable {

    fun resolve(context: Context): String {
        return context.getString(resId, *formatArgs)
    }

    override fun equals(other: Any?): Boolean {
        return other is com.playground.app.common.model.StringRes
                && other.resId == resId
                && other.formatArgs.contentEquals(formatArgs)
    }

    override fun toString(): String {
        return com.playground.app.common.model.StringRes::class.java.simpleName +
                "(" +
                "resId=$resId, " +
                "formatArgs=${formatArgs.map { it.toString() }}" +
                ")"
    }

    override fun hashCode(): Int {
        var result = resId
        result = 31 * result + formatArgs.contentHashCode()
        return result
    }
}
