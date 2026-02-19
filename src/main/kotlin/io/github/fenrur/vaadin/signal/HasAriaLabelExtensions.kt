package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasAriaLabel

/**
 * Reactive aria-label for components with accessibility labels.
 */
@JvmName("hasAriaLabelAriaLabelSignal")
fun <C> C.ariaLabel(signal: Signal<String?>): C
        where C : HasAriaLabel, C : AttachNotifier, C : DetachNotifier {
    fun apply(ariaLabel: String?) {
        setAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive aria-labelledby for components with accessibility labels.
 */
@JvmName("hasAriaLabelAriaLabelledBySignal")
fun <C> C.ariaLabelledBy(signal: Signal<String?>): C
        where C : HasAriaLabel, C : AttachNotifier, C : DetachNotifier {
    fun apply(ariaLabelledBy: String?) {
        setAriaLabelledBy(ariaLabelledBy)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
