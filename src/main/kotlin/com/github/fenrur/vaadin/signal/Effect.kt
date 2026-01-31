package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.github.fenrur.signal.operators.combine
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier

/**
 * Creates a reactive effect that executes when the signal value changes.
 * Similar to SolidJS createEffect.
 *
 * @param signal The signal to observe
 * @param initialCall If true, executes immediately with the current value
 * @param block The effect to execute on value changes
 */
fun <A, T> A.effect(
    signal: Signal<T>,
    initialCall: Boolean = false,
    block: (T) -> Unit,
) where A : AttachNotifier, A : DetachNotifier {
    uiSubscribe(signal, initialCall).onSuccess { block(it) }
}

/**
 * Creates a reactive effect with two signals.
 */
fun <A, T1, T2> A.effect(
    signal1: Signal<T1>,
    signal2: Signal<T2>,
    initialCall: Boolean = false,
    block: (T1, T2) -> Unit,
) where A : AttachNotifier, A : DetachNotifier {
    val combined = combine(signal1, signal2) { a, b -> Pair(a, b) }
    uiSubscribe(combined, initialCall).onSuccess { (a, b) -> block(a, b) }
}

/**
 * Creates a reactive effect with three signals.
 */
fun <A, T1, T2, T3> A.effect(
    signal1: Signal<T1>,
    signal2: Signal<T2>,
    signal3: Signal<T3>,
    initialCall: Boolean = false,
    block: (T1, T2, T3) -> Unit,
) where A : AttachNotifier, A : DetachNotifier {
    val combined = combine(signal1, signal2, signal3) { a, b, c -> Triple(a, b, c) }
    uiSubscribe(combined, initialCall).onSuccess { (a, b, c) -> block(a, b, c) }
}
