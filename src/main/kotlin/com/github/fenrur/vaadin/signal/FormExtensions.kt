package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasHelper
import com.vaadin.flow.component.HasLabel
import com.vaadin.flow.component.HasPlaceholder
import com.vaadin.flow.component.HasValidation
import com.vaadin.flow.component.checkbox.Checkbox
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.combobox.MultiSelectComboBox
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.datetimepicker.DateTimePicker
import com.vaadin.flow.component.select.Select
import com.vaadin.flow.component.textfield.PasswordField
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.component.timepicker.TimePicker
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Two-way binding for TextField value.
 */
fun TextField.value(signal: MutableSignal<String>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Two-way binding for PasswordField value.
 */
fun PasswordField.value(signal: MutableSignal<String>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Two-way binding for Checkbox checked state.
 */
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
fun DateTimePicker.selectedDateTime(signal: MutableSignal<LocalDateTime?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for components with labels.
 */
fun <C> C.label(signal: Signal<String>): C
        where C : Component, C : HasLabel {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive placeholder for input components.
 */
fun <C> C.placeholder(signal: Signal<String>): C
        where C : Component, C : HasPlaceholder {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper text for form components.
 */
fun <C> C.helperText(signal: Signal<String>): C
        where C : Component, C : HasHelper {
    fun apply(text: String) {
        helperText = text
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive invalid state for form components.
 */
fun <C> C.invalid(signal: Signal<Boolean>): C
        where C : Component, C : HasValidation {
    fun apply(isInvalid: Boolean) {
        setInvalid(isInvalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive error message for form components.
 */
fun <C> C.errorMessage(signal: Signal<String>): C
        where C : Component, C : HasValidation {
    fun apply(message: String) {
        errorMessage = message
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
