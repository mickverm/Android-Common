package be.mickverm.common.extensions

import android.view.View

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) View.GONE else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.visible(visible: Boolean = true, gone: Boolean = true) {
    visibility = when {
        visible -> View.VISIBLE
        gone -> View.GONE
        else -> View.INVISIBLE
    }
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isInvisible() = visibility == View.INVISIBLE || visibility == View.GONE

fun View.isGone() = visibility == View.GONE
