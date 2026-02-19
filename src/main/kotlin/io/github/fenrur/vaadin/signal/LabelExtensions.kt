package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.html.Label

// ============================================
// Label extensions (deprecated)
// ============================================

/**
 * Reactive for attribute for Label.
 */
@Suppress("DEPRECATION")
@JvmName("labelForIdSignal")
fun Label.forId(signal: Signal<String?>): Label {
    fun apply(forId: String?) {
        setFor(forId)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
