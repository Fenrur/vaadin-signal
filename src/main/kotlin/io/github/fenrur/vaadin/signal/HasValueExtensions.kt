package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasValue

/**
 * Reactive value (one-way binding) for components with HasValue.
 */
@JvmName("hasValueValueSignal")
fun <C, E : HasValue.ValueChangeEvent<V>, V> C.value(signal: Signal<V>): C
        where C : HasValue<E, V>, C : AttachNotifier, C : DetachNotifier {
    fun apply(value: V) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for components with HasValue.
 */
@JvmName("hasValueValueMutableSignal")
fun <C, E : HasValue.ValueChangeEvent<V>, V> C.value(signal: MutableSignal<V>): C
        where C : HasValue<E, V>, C : AttachNotifier, C : DetachNotifier {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }

    return this
}

/**
 * Reactive read-only state for components with HasValue.
 */
@JvmName("hasValueReadOnlySignal")
fun <C, E : HasValue.ValueChangeEvent<V>, V> C.readOnly(signal: Signal<Boolean>): C
        where C : HasValue<E, V>, C : AttachNotifier, C : DetachNotifier {
    fun apply(readOnly: Boolean) {
        isReadOnly = readOnly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive required indicator visibility for components with HasValue.
 */
@JvmName("hasValueRequiredIndicatorVisibleSignal")
fun <C, E : HasValue.ValueChangeEvent<V>, V> C.requiredIndicatorVisible(signal: Signal<Boolean>): C
        where C : HasValue<E, V>, C : AttachNotifier, C : DetachNotifier {
    fun apply(visible: Boolean) {
        isRequiredIndicatorVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
