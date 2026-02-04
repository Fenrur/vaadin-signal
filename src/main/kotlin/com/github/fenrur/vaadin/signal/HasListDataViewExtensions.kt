package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.data.provider.HasListDataView
import com.vaadin.flow.data.provider.ListDataView

// ============================================
// HasListDataView extensions
// ============================================

/**
 * Reactive items for any component implementing HasListDataView.
 *
 * Binds a signal of items to the component's list data view. When the signal
 * value changes, the component's items are updated accordingly.
 *
 * Supported components include: Grid, Select, ComboBox, MultiSelectComboBox,
 * ListBox, MultiSelectListBox, RadioButtonGroup, CheckboxGroup, etc.
 */
@JvmName("hasListDataViewItemsSignal")
fun <C, T, V : ListDataView<T, *>> C.items(signal: Signal<Collection<T>>): C
        where C : HasListDataView<T, V>, C : AttachNotifier, C : DetachNotifier {
    fun apply(items: Collection<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
