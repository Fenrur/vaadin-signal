package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.checkbox.Checkbox

// ============================================
// Checkbox extensions
// ============================================

/**
 * Reactive checked state for Checkbox (one-way).
 */
@JvmName("checkboxCheckedSignal")
fun Checkbox.checked(signal: Signal<Boolean>): Checkbox {
    fun apply(checked: Boolean) {
        value = checked
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive autofocus for Checkbox.
 */
@JvmName("checkboxAutofocusSignal")
fun Checkbox.autofocus(signal: Signal<Boolean>): Checkbox {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive indeterminate state for Checkbox.
 */
@JvmName("checkboxIndeterminateSignal")
fun Checkbox.indeterminate(signal: Signal<Boolean>): Checkbox {
    fun apply(indeterminate: Boolean) {
        isIndeterminate = indeterminate
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive required indicator for Checkbox.
 */
@JvmName("checkboxRequiredSignal")
fun Checkbox.required(signal: Signal<Boolean>): Checkbox {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

