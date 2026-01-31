package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.progressbar.ProgressBar
import com.vaadin.flow.component.progressbar.ProgressBarVariant

// ============================================
// ProgressBar extensions
// ============================================

/**
 * Reactive value for ProgressBar.
 */
@JvmName("progressBarValueSignal")
fun ProgressBar.value(signal: Signal<Double>) {
    fun apply(value: Double) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min for ProgressBar.
 */
@JvmName("progressBarMinSignal")
fun ProgressBar.min(signal: Signal<Double>) {
    fun apply(min: Double) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max for ProgressBar.
 */
@JvmName("progressBarMaxSignal")
fun ProgressBar.max(signal: Signal<Double>) {
    fun apply(max: Double) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive indeterminate state for ProgressBar.
 */
@JvmName("progressBarIndeterminateSignal")
fun ProgressBar.indeterminate(signal: Signal<Boolean>) {
    fun apply(indeterminate: Boolean) {
        isIndeterminate = indeterminate
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for ProgressBar.
 */
@JvmName("progressBarThemeVariantsSignal")
fun ProgressBar.themeVariants(signal: Signal<Set<ProgressBarVariant>>) {
    var previousVariants = emptySet<ProgressBarVariant>()

    fun apply(variants: Set<ProgressBarVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for ProgressBar.
 */
@JvmName("progressBarThemeVariantSignal")
fun ProgressBar.themeVariant(signal: Signal<ProgressBarVariant?>) {
    var previousVariant: ProgressBarVariant? = null

    fun apply(variant: ProgressBarVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive contrast theme for ProgressBar.
 */
@JvmName("progressBarContrastSignal")
fun ProgressBar.contrast(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(ProgressBarVariant.LUMO_CONTRAST)
        } else {
            removeThemeVariants(ProgressBarVariant.LUMO_CONTRAST)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error theme for ProgressBar.
 */
@JvmName("progressBarErrorSignal")
fun ProgressBar.error(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(ProgressBarVariant.LUMO_ERROR)
        } else {
            removeThemeVariants(ProgressBarVariant.LUMO_ERROR)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive success theme for ProgressBar.
 */
@JvmName("progressBarSuccessSignal")
fun ProgressBar.success(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(ProgressBarVariant.LUMO_SUCCESS)
        } else {
            removeThemeVariants(ProgressBarVariant.LUMO_SUCCESS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
