package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.PasswordField

// =============================================================================
// PASSWORDFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive required for PasswordField.
 */
@JvmName("passwordFieldRequiredSignal")
fun PasswordField.required(signal: Signal<Boolean>): PasswordField {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive clear button visible for PasswordField.
 */
@JvmName("passwordFieldClearButtonVisibleSignal")
fun PasswordField.clearButtonVisible(signal: Signal<Boolean>): PasswordField {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive reveal button visible for PasswordField.
 */
@JvmName("passwordFieldRevealButtonVisibleSignal")
fun PasswordField.revealButtonVisible(signal: Signal<Boolean>): PasswordField {
    fun apply(visible: Boolean) {
        isRevealButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive readonly for PasswordField.
 */
@JvmName("passwordFieldReadonlySignal")
fun PasswordField.readonly(signal: Signal<Boolean>): PasswordField {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}