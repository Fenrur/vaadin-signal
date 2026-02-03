package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.EmailField

// =============================================================================
// EMAILFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive required for EmailField.
 */
@JvmName("emailFieldRequiredSignal")
fun EmailField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for EmailField.
 */
@JvmName("emailFieldClearButtonVisibleSignal")
fun EmailField.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}