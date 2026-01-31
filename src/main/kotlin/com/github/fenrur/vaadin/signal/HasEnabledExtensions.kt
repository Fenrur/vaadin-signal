package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasEnabled

// ============================================
// HasEnabled extensions
// ============================================

/**
 * Reactively controls the enabled state of a component.
 */
@JvmName("hasEnabledEnabledSignal")
fun <C> C.enabled(signal: Signal<Boolean>): C
        where C : Component, C : HasEnabled {

    fun apply(v: Boolean) {
        isEnabled = v
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
