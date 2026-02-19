package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasValidation

/**
 * Reactive manual validation mode for components with validation.
 */
@JvmName("hasValidationManualValidationSignal")
fun <C> C.manualValidation(signal: Signal<Boolean>): C
        where C : HasValidation, C : AttachNotifier, C : DetachNotifier {
    fun apply(enabled: Boolean) {
        setManualValidation(enabled)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive error message for components with validation.
 */
@JvmName("hasValidationErrorMessageSignal")
fun <C> C.errorMessage(signal: Signal<String?>): C
        where C : HasValidation, C : AttachNotifier, C : DetachNotifier {
    fun apply(errorMessage: String?) {
        setErrorMessage(errorMessage)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive invalid state for components with validation.
 */
@JvmName("hasValidationInvalidSignal")
fun <C> C.invalid(signal: Signal<Boolean>): C
        where C : HasValidation, C : AttachNotifier, C : DetachNotifier {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
