package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.messages.MessageList
import com.vaadin.flow.component.messages.MessageListItem

// ============================================
// MessageList extensions
// ============================================

/**
 * Reactive items for MessageList.
 */
fun MessageList.items(signal: Signal<List<MessageListItem>>) {
    fun apply(items: List<MessageListItem>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
