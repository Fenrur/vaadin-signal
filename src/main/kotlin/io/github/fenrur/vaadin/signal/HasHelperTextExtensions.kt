package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasHelper

/**
 * Reactive helper text.
 */
@JvmName("hasHelperTextSignal")
fun <C> C.helperText(signal: Signal<String?>): C
        where C : HasHelper, C : AttachNotifier, C : DetachNotifier {
    fun apply(text: String?) {
        helperText = text
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper component.
 */
@JvmName("hasHelperComponentSignal")
fun <C> C.helperComponent(signal: Signal<Component?>): C
        where C : HasHelper, C : AttachNotifier, C : DetachNotifier {
    fun apply(comp: Component?) {
        helperComponent = comp
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
