package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.messages.MessageList
import com.vaadin.flow.component.messages.MessageListItem

// ============================================
// MessageList extensions
// ============================================

/**
 * Reactive items for MessageList.
 */
@JvmName("messageListItemsSignal")
fun MessageList.items(signal: Signal<List<MessageListItem>>): MessageList {
    fun apply(items: List<MessageListItem>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
