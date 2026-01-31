package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.listbox.ListBox
import com.vaadin.flow.data.provider.DataProvider

// ============================================
// ListBox extensions
// ============================================

/**
 * Reactive items for ListBox.
 */
@JvmName("listBoxItemsSignal")
fun <T> ListBox<T>.items(signal: Signal<List<T>>) {
    fun apply(items: List<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for ListBox selection.
 */
@JvmName("listBoxSelectedItemMutableSignal")
fun <T> ListBox<T>.selectedItem(signal: MutableSignal<T?>) {
    fun apply(item: T?) {
        value = item
    }

    apply(signal.value)

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) { apply(it) }
}

/**
 * Two-way binding for ListBox value.
 */
@JvmName("listBoxValueMutableSignal")
fun <T> ListBox<T>.value(signal: MutableSignal<T?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive DataProvider for ListBox.
 */
@JvmName("listBoxDataProviderSignal")
fun <T> ListBox<T>.dataProvider(signal: Signal<DataProvider<T, *>>) {
    fun apply(provider: DataProvider<T, *>) {
        setDataProvider(provider)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
