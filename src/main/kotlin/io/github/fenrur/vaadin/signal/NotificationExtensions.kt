package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.notification.NotificationVariant

// ============================================
// Notification extensions
// ============================================

/**
 * Two-way binding for Notification opened state.
 */
@JvmName("notificationOpenedMutableSignal")
fun Notification.opened(signal: MutableSignal<Boolean>): Notification {
    isOpened = signal.value

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        isOpened = it
    }
    return this
}

/**
 * Reactive duration for Notification.
 */
@JvmName("notificationDurationSignal")
fun Notification.duration(signal: Signal<Int>): Notification {
    fun apply(duration: Int) {
        setDuration(duration)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive position for Notification.
 */
@JvmName("notificationPositionSignal")
fun Notification.position(signal: Signal<Notification.Position>): Notification {
    fun apply(position: Notification.Position) {
        setPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Shows a notification when the signal value changes (non-empty).
 */
@JvmName("componentNotificationSignal")
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
@JvmName("componentNotificationWithVariantSignal")
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
