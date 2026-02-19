package io.github.fenrur.vaadin.signal

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.UI

/**
 * Executes [block] immediately if the current session holds the lock, otherwise via [UI.access].
 */
inline fun UI.immediateOrAccess(crossinline block: () -> Unit) {
    if (session.hasLock()) {
        block()
    } else {
        access { block() }
    }
}

/**
 * Delegates to [UI.immediateOrAccess] using this component's attached UI.
 * @throws IllegalStateException if the component is not attached to a UI
 */
inline fun Component.immediateOrAccess(crossinline block: () -> Unit) {
    val currentUI = ui.orElse(null)
        ?: throw IllegalStateException("Component ${this::class.simpleName} is not attached to a UI")
    currentUI.immediateOrAccess(block)
}
