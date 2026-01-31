package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.progressbar.ProgressBar

/**
 * Reactive value for ProgressBar.
 */
fun ProgressBar.progress(signal: Signal<Double>) {
    fun apply(value: Double) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive indeterminate state for ProgressBar.
 */
fun ProgressBar.indeterminate(signal: Signal<Boolean>) {
    fun apply(isIndeterminate: Boolean) {
        setIndeterminate(isIndeterminate)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
