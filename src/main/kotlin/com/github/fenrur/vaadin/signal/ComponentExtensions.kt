package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component

// ============================================
// Component extensions
// ============================================

/**
 * Reactively controls the visibility of a component.
 */
@JvmName("componentVisibleSignal")
fun Component.visible(signal: Signal<Boolean>) {
    fun apply(v: Boolean) {
        isVisible = v
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactively sets the ID of a component.
 */
@JvmName("componentIdSignal")
fun Component.id(signal: Signal<String?>) {
    fun apply(id: String?) {
        setId(id)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
