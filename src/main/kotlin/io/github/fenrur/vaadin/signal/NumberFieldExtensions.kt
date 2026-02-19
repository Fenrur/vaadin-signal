package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.NumberField

// =============================================================================
// NUMBERFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive required for NumberField.
 */
@JvmName("numberFieldRequiredSignal")
fun NumberField.required(signal: Signal<Boolean>): NumberField {
    fun apply(required: Boolean) {
        setRequiredIndicatorVisible(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive min for NumberField.
 */
@JvmName("numberFieldMinSignal")
fun NumberField.min(signal: Signal<Double>): NumberField {
    fun apply(min: Double) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max for NumberField.
 */
@JvmName("numberFieldMaxSignal")
fun NumberField.max(signal: Signal<Double>): NumberField {
    fun apply(max: Double) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive step for NumberField.
 */
@JvmName("numberFieldStepSignal")
fun NumberField.step(signal: Signal<Double>): NumberField {
    fun apply(step: Double) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive stepButtonsVisible for NumberField.
 */
@JvmName("numberFieldStepButtonsVisibleSignal")
fun NumberField.stepButtonsVisible(signal: Signal<Boolean>): NumberField {
    fun apply(visible: Boolean) {
        setStepButtonsVisible(visible)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}