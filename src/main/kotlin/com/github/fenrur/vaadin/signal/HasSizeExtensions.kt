package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasSize

// ============================================
// HasSize extensions
// ============================================

/**
 * Reactive width for any component implementing HasSize.
 */
@JvmName("hasSizeWidthSignal")
fun <C> C.width(signal: Signal<String>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(width: String) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive nullable width for any component implementing HasSize.
 */
@JvmName("hasSizeWidthNullableSignal")
fun <C> C.width(signal: Signal<String?>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(width: String?) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive height for any component implementing HasSize.
 */
@JvmName("hasSizeHeightSignal")
fun <C> C.height(signal: Signal<String>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(height: String) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive nullable height for any component implementing HasSize.
 */
@JvmName("hasSizeHeightNullableSignal")
fun <C> C.height(signal: Signal<String?>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(height: String?) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min-width for any component implementing HasSize.
 */
@JvmName("hasSizeMinWidthSignal")
fun <C> C.minWidth(signal: Signal<String?>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(minWidth: String?) {
        setMinWidth(minWidth)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max-width for any component implementing HasSize.
 */
@JvmName("hasSizeMaxWidthSignal")
fun <C> C.maxWidth(signal: Signal<String?>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(maxWidth: String?) {
        setMaxWidth(maxWidth)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min-height for any component implementing HasSize.
 */
@JvmName("hasSizeMinHeightSignal")
fun <C> C.minHeight(signal: Signal<String?>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(minHeight: String?) {
        setMinHeight(minHeight)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max-height for any component implementing HasSize.
 */
@JvmName("hasSizeMaxHeightSignal")
fun <C> C.maxHeight(signal: Signal<String?>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(maxHeight: String?) {
        setMaxHeight(maxHeight)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive size full for any component implementing HasSize.
 */
@JvmName("hasSizeSizeFullSignal")
fun <C> C.sizeFull(signal: Signal<Boolean>)
        where C : HasSize, C : AttachNotifier, C : DetachNotifier {
    fun apply(full: Boolean) {
        if (full) {
            setSizeFull()
        } else {
            setSizeUndefined()
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
