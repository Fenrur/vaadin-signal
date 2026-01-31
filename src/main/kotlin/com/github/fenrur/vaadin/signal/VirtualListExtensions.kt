package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.virtuallist.VirtualList

// ============================================
// VirtualList extensions
// ============================================

/**
 * Reactive items for VirtualList.
 */
fun <T> VirtualList<T>.items(signal: Signal<List<T>>) {
    fun apply(items: List<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
