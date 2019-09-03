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

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.isGone() = visibility == View.GONE

fun View.isNotVisible() = isInvisible() || isGone()

fun List<View>.hide(gone: Boolean = true) = forEach { view ->
    view.hide(gone)
}

fun List<View>.show() = forEach { view ->
    view.show()
}

fun List<View>.visible(visible: Boolean = true, gone: Boolean = true) = forEach { view ->
    view.visible(visible, gone)
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun List<View>.enable() = forEach { view ->
    view.enable()
}

fun List<View>.disable() = forEach { view ->
    view.disable()
}

fun List<View>.enabled(enabled: Boolean = true) = forEach { view ->
    view.isEnabled = enabled
}
