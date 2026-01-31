package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.html.NativeLabel

// ============================================
// NativeLabel extensions
// ============================================

/**
 * Reactive for attribute for NativeLabel.
 */
@JvmName("nativeLabelForIdSignal")
fun NativeLabel.forId(signal: Signal<String?>) {
    fun apply(forId: String?) {
        setFor(forId)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
