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
fun <C : Component> C.visible(signal: Signal<Boolean>): C {
    fun apply(v: Boolean) {
        isVisible = v
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactively sets the ID of a component.
 */
@JvmName("componentIdSignal")
fun <C : Component> C.id(signal: Signal<String?>): C {
    fun apply(id: String?) {
        setId(id)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
