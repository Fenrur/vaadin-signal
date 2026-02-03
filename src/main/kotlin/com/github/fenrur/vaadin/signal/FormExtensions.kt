package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.checkbox.Checkbox
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.combobox.MultiSelectComboBox
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.datetimepicker.DateTimePicker
import com.vaadin.flow.component.select.Select
import com.vaadin.flow.component.timepicker.TimePicker
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

// ============================================
// Form extensions
// ============================================

/**
 * Two-way binding for Checkbox checked state.
 */
@JvmName("checkboxCheckedMutableSignal")
fun Checkbox.checked(signal: MutableSignal<Boolean>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Two-way binding for Select selected item.
 */
@JvmName("selectSelectedItemMutableSignal")
fun <T> Select<T>.selectedItem(signal: MutableSignal<T?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Two-way binding for ComboBox selected item.
 */
@JvmName("comboBoxSelectedItemMutableSignal")
fun <T> ComboBox<T>.selectedItem(signal: MutableSignal<T?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive items for Select.
 */
@JvmName("selectItemsSignal")
fun <T> Select<T>.items(signal: Signal<List<T>>) {
    fun apply(items: List<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive items for ComboBox.
 */
@JvmName("comboBoxItemsSignal")
fun <T> ComboBox<T>.items(signal: Signal<List<T>>) {
    fun apply(items: List<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive items for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxItemsSignal")
fun <T> MultiSelectComboBox<T>.items(signal: Signal<Set<T>>) {
    fun apply(items: Set<T>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for MultiSelectComboBox selected items.
 */
@JvmName("multiSelectComboBoxSelectedItemsMutableSignal")
fun <T> MultiSelectComboBox<T>.selectedItems(signal: MutableSignal<Set<T>>) {
    fun apply(items: Set<T>) {
        value = items
    }

    apply(signal.value)

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) { apply(it) }
}

/**
 * Two-way binding for DatePicker.
 */
@JvmName("datePickerSelectedDateMutableSignal")
fun DatePicker.selectedDate(signal: MutableSignal<LocalDate?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Two-way binding for TimePicker.
 */
@JvmName("timePickerSelectedTimeMutableSignal")
fun TimePicker.selectedTime(signal: MutableSignal<LocalTime?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Two-way binding for DateTimePicker.
 */
@JvmName("dateTimePickerSelectedDateTimeMutableSignal")
fun DateTimePicker.selectedDateTime(signal: MutableSignal<LocalDateTime?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

