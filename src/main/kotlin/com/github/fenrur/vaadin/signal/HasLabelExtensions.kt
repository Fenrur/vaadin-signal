package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasLabel

/**
 * Reactive label for components with labels.
 */
@JvmName("hasLabelLabelSignal")
fun <C> C.label(signal: Signal<String?>): C
        where C : HasLabel, C : AttachNotifier, C : DetachNotifier {
    fun apply(label: String?) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}