package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasText

// ============================================
// HasText extensions
// ============================================

/**
 * Reactive text for any component implementing HasText.
 */
@JvmName("hasTextTextSignal")
fun <C> C.text(signal: Signal<String>): C
        where C : Component, C : HasText {
    fun apply(text: String) {
        setText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive nullable text for any component implementing HasText.
 */
@JvmName("hasTextTextNullableSignal")
fun <C> C.text(signal: Signal<String?>): C
        where C : Component, C : HasText {
    fun apply(text: String?) {
        setText(text ?: "")
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
