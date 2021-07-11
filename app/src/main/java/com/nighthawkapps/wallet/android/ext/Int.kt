package com.nighthawkapps.wallet.android.ext

import android.content.res.Resources
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import com.nighthawkapps.wallet.android.NighthawkWalletApp

/**
 * Grab a color out of the application resources, using the default theme
 */
@ColorInt
internal inline fun @receiver:ColorRes Int.toAppColor(): Int {
    return ResourcesCompat.getColor(
        NighthawkWalletApp.instance.resources,
        this,
        NighthawkWalletApp.instance.theme
    )
}

/**
 * Grab a string from the application resources
 */
internal inline fun @receiver:StringRes Int.toAppString(lowercase: Boolean = false): String {
    return NighthawkWalletApp.instance.getString(this).let {
        if (lowercase) it.toLowerCase() else it
    }
}

/**
 * Grab a formatted string from the application resources
 */
internal inline fun @receiver:StringRes Int.toAppStringFormatted(vararg formatArgs: Any): String {
    return NighthawkWalletApp.instance.getString(this, *formatArgs)
}

/**
 * Grab an integer from the application resources
 */
internal inline fun @receiver:IntegerRes Int.toAppInt(): Int {
    return NighthawkWalletApp.instance.resources.getInteger(this)
}

fun Float.toPx() = this * Resources.getSystem().displayMetrics.density

fun Int.toPx() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

fun Int.toDp() = (this / Resources.getSystem().displayMetrics.density + 0.5f).toInt()
