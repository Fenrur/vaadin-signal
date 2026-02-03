package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.*
import com.vaadin.flow.data.value.ValueChangeMode

/**
 * Reactive autofocus for TextField.
 */
@JvmName("textFieldAutofocusSignal")
fun TextField.autofocus(signal: Signal<Boolean>) {
    fun apply(autofocus: Boolean) {
        setAutofocus(autofocus)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autoselect for TextField.
 */
@JvmName("textFieldAutoselectSignal")
fun TextField.autoselect(signal: Signal<Boolean>) {
    fun apply(autoselect: Boolean) {
        setAutoselect(autoselect)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required for TextField.
 */
@JvmName("textFieldRequiredSignal")
fun TextField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for TextField.
 */
@JvmName("textFieldClearButtonVisibleSignal")
fun TextField.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minLength for TextField.
 */
@JvmName("textFieldMinLengthSignal")
fun TextField.minLength(signal: Signal<Int>) {
    fun apply(minLength: Int) {
        setMinLength(minLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive maxLength for TextField.
 */
@JvmName("textFieldMaxLengthSignal")
fun TextField.maxLength(signal: Signal<Int>) {
    fun apply(maxLength: Int) {
        setMaxLength(maxLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive pattern for TextField.
 */
@JvmName("textFieldPatternSignal")
fun TextField.pattern(signal: Signal<String>) {
    fun apply(pattern: String) {
        setPattern(pattern)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly for TextField.
 */
@JvmName("textFieldReadonlySignal")
fun TextField.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for TextField.
 */
@JvmName("textFieldThemeVariantsSignal")
fun TextField.themeVariants(signal: Signal<Set<TextFieldVariant>>) {
    var previousVariants = emptySet<TextFieldVariant>()

    fun apply(variants: Set<TextFieldVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}