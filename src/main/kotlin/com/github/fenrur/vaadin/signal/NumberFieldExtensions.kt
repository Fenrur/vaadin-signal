package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.NumberField

// =============================================================================
// NUMBERFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive required for NumberField.
 */
@JvmName("numberFieldRequiredSignal")
fun NumberField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequiredIndicatorVisible(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min for NumberField.
 */
@JvmName("numberFieldMinSignal")
fun NumberField.min(signal: Signal<Double>) {
    fun apply(min: Double) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max for NumberField.
 */
@JvmName("numberFieldMaxSignal")
fun NumberField.max(signal: Signal<Double>) {
    fun apply(max: Double) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive step for NumberField.
 */
@JvmName("numberFieldStepSignal")
fun NumberField.step(signal: Signal<Double>) {
    fun apply(step: Double) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive stepButtonsVisible for NumberField.
 */
@JvmName("numberFieldStepButtonsVisibleSignal")
fun NumberField.stepButtonsVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        setStepButtonsVisible(visible)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}