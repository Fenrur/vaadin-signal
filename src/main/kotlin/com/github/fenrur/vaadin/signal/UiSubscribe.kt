package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.github.fenrur.signal.UnSubscriber
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.UI
import java.util.concurrent.atomic.AtomicReference

/**
 * Subscribes to a signal and executes the block on the UI thread.
 * Automatically manages subscription lifecycle with attach/detach events.
 *
 * @param signal The signal to subscribe to
 * @param initialCall If true, calls the block immediately with the current value
 * @param block The block to execute when the signal value changes
 */
fun <T, A> A.uiSubscribe(
    signal: Signal<T>,
    initialCall: Boolean = false,
    block: (Result<T>) -> Unit,
) where A : AttachNotifier, A : DetachNotifier {
    val ui = UI.getCurrent()
    if (initialCall) {
        block(Result.success(signal.value))
    }
    val unsubscribeRef = AtomicReference<UnSubscriber> {}
    addAttachListener {
        unsubscribeRef.set(signal.subscribe { result ->
            if (ui.isAttached) ui.immediateOrAccess {
                block(result)
            }
        })
    }
    addDetachListener {
        unsubscribeRef.getAndSet {}.invoke()
    }
}

/**
 * Creates a UI subscription builder for fluent API.
 */
fun <T, A> A.uiSubscribe(
    signal: Signal<T>,
): UiSubscriptionBuilder<T, A> where A : AttachNotifier, A : DetachNotifier =
    UiSubscriptionBuilder(this, signal, false)

/**
 * Creates a UI subscription builder with initial call option.
 */
fun <T, A> A.uiSubscribe(
    signal: Signal<T>,
    initialCall: Boolean,
): UiSubscriptionBuilder<T, A> where A : AttachNotifier, A : DetachNotifier =
    UiSubscriptionBuilder(this, signal, initialCall)

/**
 * Builder for UI subscriptions with fluent API.
 */
class UiSubscriptionBuilder<T, A>(
    private val target: A,
    private val signal: Signal<T>,
    private val initialCall: Boolean,
) where A : AttachNotifier, A : DetachNotifier {

    /**
     * Executes only on successful values, ignores errors.
     */
    fun onSuccess(block: (T) -> Unit) {
        target.uiSubscribe(signal, initialCall) { result ->
            result.onSuccess { value -> block(value) }
        }
    }

    /**
     * Executes only on errors, ignores successful values.
     */
    fun onFailure(block: (Throwable) -> Unit) {
        target.uiSubscribe(signal, initialCall) { result ->
            result.onFailure { error -> block(error) }
        }
    }
}
