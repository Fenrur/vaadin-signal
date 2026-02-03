package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasText

// ============================================
// HasText extensions
// ============================================

/**
 * Reactive text for any component implementing HasText.
 */
@JvmName("hasTextTextSignal")
fun <C> C.text(signal: Signal<String?>)
        where C : HasText, C : AttachNotifier, C : DetachNotifier {
    fun apply(text: String?) {
        setText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive whitespace mode for any component implementing HasText.
 */
@JvmName("hasTextWhitespaceSignal")
fun <C> C.whitespace(signal: Signal<HasText.WhiteSpace?>)
        where C : HasText, C : AttachNotifier, C : DetachNotifier {
    fun apply(whitespace: HasText.WhiteSpace?) {
        setWhiteSpace(whitespace)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
