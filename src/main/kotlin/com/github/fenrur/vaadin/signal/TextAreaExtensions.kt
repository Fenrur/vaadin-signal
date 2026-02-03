package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.component.textfield.TextAreaVariant
import kotlin.collections.forEach

// =============================================================================
// TEXTAREA EXTENSIONS
// =============================================================================

/**
 * Reactive required for TextArea.
 */
@JvmName("textAreaRequiredSignal")
fun TextArea.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for TextArea.
 */
@JvmName("textAreaClearButtonVisibleSignal")
fun TextArea.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minLength for TextArea.
 */
@JvmName("textAreaMinLengthSignal")
fun TextArea.minLength(signal: Signal<Int>) {
    fun apply(minLength: Int) {
        setMinLength(minLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive maxLength for TextArea.
 */
@JvmName("textAreaMaxLengthSignal")
fun TextArea.maxLength(signal: Signal<Int>) {
    fun apply(maxLength: Int) {
        setMaxLength(maxLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly for TextArea.
 */
@JvmName("textAreaReadonlySignal")
fun TextArea.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for TextArea.
 */
@JvmName("textAreaThemeVariantsSignal")
fun TextArea.themeVariants(signal: Signal<Set<TextAreaVariant>>) {
    var previousVariants = emptySet<TextAreaVariant>()

    fun apply(variants: Set<TextAreaVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}