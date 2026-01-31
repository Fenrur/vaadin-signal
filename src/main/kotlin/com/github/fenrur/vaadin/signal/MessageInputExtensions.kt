package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.vaadin.flow.component.messages.MessageInput

// ============================================
// MessageInput extensions
// ============================================

/**
 * Two-way binding for MessageInput value.
 */
fun MessageInput.value(signal: MutableSignal<String>) {
    // MessageInput doesn't have a direct value property, but we can listen for submit
    addSubmitListener { event ->
        signal.value = event.value
    }
}

/**
 * Reactive on submit handler for MessageInput.
 * The signal will be updated with the submitted message.
 */
fun MessageInput.onSubmit(signal: MutableSignal<String?>) {
    addSubmitListener { event ->
        signal.value = event.value
    }
}
