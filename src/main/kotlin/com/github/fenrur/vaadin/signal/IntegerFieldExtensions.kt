package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.IntegerField

// =============================================================================
// INTEGERFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive min for IntegerField.
 */
@JvmName("integerFieldMinSignal")
fun IntegerField.min(signal: Signal<Int>) {
    fun apply(min: Int) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max for IntegerField.
 */
@JvmName("integerFieldMaxSignal")
fun IntegerField.max(signal: Signal<Int>) {
    fun apply(max: Int) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive step for IntegerField.
 */
@JvmName("integerFieldStepSignal")
fun IntegerField.step(signal: Signal<Int>) {
    fun apply(step: Int) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive stepButtonsVisible for IntegerField.
 */
@JvmName("integerFieldStepButtonsVisibleSignal")
fun IntegerField.stepButtonsVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        setStepButtonsVisible(visible)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}