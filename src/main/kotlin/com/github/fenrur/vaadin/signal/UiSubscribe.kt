package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Either
import com.github.fenrur.signal.Signal
import com.github.fenrur.signal.UnSubscriber
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.UI

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
    block: (Either<Throwable, T>) -> Unit,
) where A : AttachNotifier, A : DetachNotifier {
    val ui = UI.getCurrent()
    if (initialCall) {
        block(Either.right(signal.value))
    }
    lateinit var unsubscribe: UnSubscriber
    addAttachListener {
        unsubscribe = signal.subscribe { either ->
            if (ui.isAttached) ui.immediateOrAccess {
                block(either)
            }
        }
    }
    addDetachListener { unsubscribe() }
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
     * Executes only on successful values (Right), ignores errors.
     */
    fun onSuccess(block: (T) -> Unit) {
        target.uiSubscribe(signal, initialCall) { either ->
            either.onRight { value -> block(value) }
        }
    }

    /**
     * Executes only on errors (Left), ignores successful values.
     */
    fun onFailure(block: (Throwable) -> Unit) {
        target.uiSubscribe(signal, initialCall) { either ->
            either.onLeft { error -> block(error) }
        }
    }
}
