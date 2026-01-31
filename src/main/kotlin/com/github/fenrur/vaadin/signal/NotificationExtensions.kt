package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.notification.NotificationVariant

/**
 * Two-way binding for Notification opened state.
 */
fun Notification.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive duration for Notification.
 */
fun Notification.duration(signal: Signal<Int>) {
    fun apply(duration: Int) {
        setDuration(duration)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive position for Notification.
 */
fun Notification.position(signal: Signal<Notification.Position>) {
    fun apply(position: Notification.Position) {
        setPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Shows a notification when the signal value changes (non-empty).
 */
fun <A> A.notification(
    messageSignal: Signal<String?>,
    duration: Int = 3000,
) where A : AttachNotifier, A : DetachNotifier {
    effect(messageSignal) { message ->
        if (!message.isNullOrBlank()) {
            Notification.show(message, duration, Notification.Position.BOTTOM_CENTER)
        }
    }
}

/**
 * Shows a notification with variant when the signal value changes.
 */
fun <A> A.notification(
    messageSignal: Signal<String>,
    variant: NotificationVariant,
    position: Notification.Position,
    duration: Int = 3000
) where A : AttachNotifier, A : DetachNotifier {
    effect(messageSignal) { message ->
        if (message.isNotEmpty()) {
            val notification = Notification.show(message, duration, position)
            notification.addThemeVariants(variant)
        }
    }
}
