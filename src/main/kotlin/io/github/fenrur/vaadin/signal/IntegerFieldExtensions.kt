package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.IntegerField

// =============================================================================
// INTEGERFIELD EXTENSIONS
// =============================================================================

/**
 * Reactive min for IntegerField.
 */
@JvmName("integerFieldMinSignal")
fun IntegerField.min(signal: Signal<Int>): IntegerField {
    fun apply(min: Int) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max for IntegerField.
 */
@JvmName("integerFieldMaxSignal")
fun IntegerField.max(signal: Signal<Int>): IntegerField {
    fun apply(max: Int) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive step for IntegerField.
 */
@JvmName("integerFieldStepSignal")
fun IntegerField.step(signal: Signal<Int>): IntegerField {
    fun apply(step: Int) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive stepButtonsVisible for IntegerField.
 */
@JvmName("integerFieldStepButtonsVisibleSignal")
fun IntegerField.stepButtonsVisible(signal: Signal<Boolean>): IntegerField {
    fun apply(visible: Boolean) {
        setStepButtonsVisible(visible)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}