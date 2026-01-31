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
@JvmName("checkboxValueTwoWay")
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
fun Checkbox.checked(signal: Signal<Boolean>) {
    fun apply(checked: Boolean) {
        value = checked
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive label for Checkbox.
 */
fun Checkbox.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autofocus for Checkbox.
 */
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
fun Checkbox.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for Checkbox.
 */
fun Checkbox.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        isInvalid = invalid
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for Checkbox.
 */
fun Checkbox.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive aria label for Checkbox.
 */
fun Checkbox.ariaLabel(signal: Signal<String?>) {
    fun apply(ariaLabel: String?) {
        setAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive aria labelled by for Checkbox.
 */
fun Checkbox.ariaLabelledBy(signal: Signal<String?>) {
    fun apply(labelledBy: String?) {
        setAriaLabelledBy(labelledBy)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
