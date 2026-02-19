package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasPlaceholder

/**
 * Reactive placeholder for input components.
 */
@JvmName("hasPlaceholderPlaceholderSignal")
fun <C> C.placeholder(signal: Signal<String?>): C
        where C : HasPlaceholder, C : AttachNotifier, C : DetachNotifier {
    fun apply(placeholder: String?) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
