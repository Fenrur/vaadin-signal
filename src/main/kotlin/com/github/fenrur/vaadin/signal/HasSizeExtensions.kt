package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasSize

// ============================================
// HasSize extensions
// ============================================

/**
 * Reactive width for any component implementing HasSize.
 */
@JvmName("hasSizeWidthSignal")
fun <C> C.width(signal: Signal<String>): C
        where C : Component, C : HasSize {
    fun apply(width: String) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive nullable width for any component implementing HasSize.
 */
@JvmName("hasSizeWidthNullableSignal")
fun <C> C.width(signal: Signal<String?>): C
        where C : Component, C : HasSize {
    fun apply(width: String?) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive height for any component implementing HasSize.
 */
@JvmName("hasSizeHeightSignal")
fun <C> C.height(signal: Signal<String>): C
        where C : Component, C : HasSize {
    fun apply(height: String) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive nullable height for any component implementing HasSize.
 */
@JvmName("hasSizeHeightNullableSignal")
fun <C> C.height(signal: Signal<String?>): C
        where C : Component, C : HasSize {
    fun apply(height: String?) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive min-width for any component implementing HasSize.
 */
@JvmName("hasSizeMinWidthSignal")
fun <C> C.minWidth(signal: Signal<String?>): C
        where C : Component, C : HasSize {
    fun apply(minWidth: String?) {
        setMinWidth(minWidth)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max-width for any component implementing HasSize.
 */
@JvmName("hasSizeMaxWidthSignal")
fun <C> C.maxWidth(signal: Signal<String?>): C
        where C : Component, C : HasSize {
    fun apply(maxWidth: String?) {
        setMaxWidth(maxWidth)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive min-height for any component implementing HasSize.
 */
@JvmName("hasSizeMinHeightSignal")
fun <C> C.minHeight(signal: Signal<String?>): C
        where C : Component, C : HasSize {
    fun apply(minHeight: String?) {
        setMinHeight(minHeight)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max-height for any component implementing HasSize.
 */
@JvmName("hasSizeMaxHeightSignal")
fun <C> C.maxHeight(signal: Signal<String?>): C
        where C : Component, C : HasSize {
    fun apply(maxHeight: String?) {
        setMaxHeight(maxHeight)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive size full for any component implementing HasSize.
 */
@JvmName("hasSizeSizeFullSignal")
fun <C> C.sizeFull(signal: Signal<Boolean>): C
        where C : Component, C : HasSize {
    fun apply(full: Boolean) {
        if (full) {
            setSizeFull()
        } else {
            setSizeUndefined()
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
