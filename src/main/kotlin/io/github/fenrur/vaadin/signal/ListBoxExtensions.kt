package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.listbox.ListBox
import com.vaadin.flow.data.provider.DataProvider

// ============================================
// ListBox extensions
// ============================================

/**
 * Two-way binding for ListBox selection.
 */
@JvmName("listBoxSelectedItemMutableSignal")
fun <T> ListBox<T>.selectedItem(signal: MutableSignal<T?>): ListBox<T> {
    fun apply(item: T?) {
        value = item
    }

    apply(signal.value)

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive DataProvider for ListBox.
 */
@JvmName("listBoxDataProviderSignal")
fun <T> ListBox<T>.dataProvider(signal: Signal<DataProvider<T, *>>): ListBox<T> {
    fun apply(provider: DataProvider<T, *>) {
        setDataProvider(provider)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
