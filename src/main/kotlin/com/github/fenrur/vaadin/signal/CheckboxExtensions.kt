package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.checkbox.Checkbox

// ============================================
// Checkbox extensions
// ============================================

/**
 * Two-way binding for Checkbox value (checked state).
 */
@JvmName("checkboxValueMutableSignal")
fun Checkbox.value(signal: MutableSignal<Boolean>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive checked state for Checkbox (one-way).
 */
@JvmName("checkboxCheckedSignal")
fun Checkbox.checked(signal: Signal<Boolean>) {
    fun apply(checked: Boolean) {
        value = checked
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autofocus for Checkbox.
 */
@JvmName("checkboxAutofocusSignal")
fun Checkbox.autofocus(signal: Signal<Boolean>) {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive indeterminate state for Checkbox.
 */
@JvmName("checkboxIndeterminateSignal")
fun Checkbox.indeterminate(signal: Signal<Boolean>) {
    fun apply(indeterminate: Boolean) {
        isIndeterminate = indeterminate
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required indicator for Checkbox.
 */
@JvmName("checkboxRequiredSignal")
fun Checkbox.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

