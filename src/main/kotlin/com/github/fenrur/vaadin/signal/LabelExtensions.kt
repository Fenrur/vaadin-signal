package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.html.Label

// ============================================
// Label extensions (deprecated)
// ============================================

/**
 * Reactive for attribute for Label.
 */
@Suppress("DEPRECATION")
@JvmName("labelForIdSignal")
fun Label.forId(signal: Signal<String?>) {
    fun apply(forId: String?) {
        setFor(forId)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
