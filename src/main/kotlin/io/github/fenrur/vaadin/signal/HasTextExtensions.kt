package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasText

// ============================================
// HasText extensions
// ============================================

/**
 * Reactive text content for any component implementing HasText.
 *
 * **Note:** Use `textContent()` instead of `text()` to avoid ambiguity with
 * Karibu-DSL's `text()` which creates a Text child component.
 * This function sets the component's own text content via `setText()`.
 */
@JvmName("hasTextTextContentSignal")
fun <C> C.textContent(signal: Signal<String?>): C
        where C : HasText, C : AttachNotifier, C : DetachNotifier {
    fun apply(text: String?) {
        setText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive whitespace mode for any component implementing HasText.
 */
@JvmName("hasTextWhitespaceSignal")
fun <C> C.whitespace(signal: Signal<HasText.WhiteSpace?>): C
        where C : HasText, C : AttachNotifier, C : DetachNotifier {
    fun apply(whitespace: HasText.WhiteSpace?) {
        setWhiteSpace(whitespace)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
