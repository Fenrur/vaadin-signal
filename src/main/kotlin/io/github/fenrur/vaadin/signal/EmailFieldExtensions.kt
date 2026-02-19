package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.EmailField

// =============================================================================
// EMAILFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive required for EmailField.
 */
@JvmName("emailFieldRequiredSignal")
fun EmailField.required(signal: Signal<Boolean>): EmailField {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive clear button visible for EmailField.
 */
@JvmName("emailFieldClearButtonVisibleSignal")
fun EmailField.clearButtonVisible(signal: Signal<Boolean>): EmailField {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}