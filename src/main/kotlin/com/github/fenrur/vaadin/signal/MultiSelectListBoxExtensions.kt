package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.listbox.MultiSelectListBox
import com.vaadin.flow.data.provider.DataProvider

// ============================================
// MultiSelectListBox extensions
// ============================================

/**
 * Reactive items for MultiSelectListBox.
 */
@JvmName("multiSelectListBoxItemsSignal")
fun <T> MultiSelectListBox<T>.items(signal: Signal<List<T>>) {
    fun apply(items: List<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive DataProvider for MultiSelectListBox.
 */
@JvmName("multiSelectListBoxDataProviderSignal")
fun <T> MultiSelectListBox<T>.dataProvider(signal: Signal<DataProvider<T, *>>) {
    fun apply(provider: DataProvider<T, *>) {
        setDataProvider(provider)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
