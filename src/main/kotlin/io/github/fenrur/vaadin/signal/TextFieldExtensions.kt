package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.*
import com.vaadin.flow.data.value.ValueChangeMode

/**
 * Reactive autofocus for TextField.
 */
@JvmName("textFieldAutofocusSignal")
fun TextField.autofocus(signal: Signal<Boolean>): TextField {
    fun apply(autofocus: Boolean) {
        setAutofocus(autofocus)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive autoselect for TextField.
 */
@JvmName("textFieldAutoselectSignal")
fun TextField.autoselect(signal: Signal<Boolean>): TextField {
    fun apply(autoselect: Boolean) {
        setAutoselect(autoselect)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive required for TextField.
 */
@JvmName("textFieldRequiredSignal")
fun TextField.required(signal: Signal<Boolean>): TextField {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive clear button visible for TextField.
 */
@JvmName("textFieldClearButtonVisibleSignal")
fun TextField.clearButtonVisible(signal: Signal<Boolean>): TextField {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive minLength for TextField.
 */
@JvmName("textFieldMinLengthSignal")
fun TextField.minLength(signal: Signal<Int>): TextField {
    fun apply(minLength: Int) {
        setMinLength(minLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive maxLength for TextField.
 */
@JvmName("textFieldMaxLengthSignal")
fun TextField.maxLength(signal: Signal<Int>): TextField {
    fun apply(maxLength: Int) {
        setMaxLength(maxLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive pattern for TextField.
 */
@JvmName("textFieldPatternSignal")
fun TextField.pattern(signal: Signal<String>): TextField {
    fun apply(pattern: String) {
        setPattern(pattern)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive readonly for TextField.
 */
@JvmName("textFieldReadonlySignal")
fun TextField.readonly(signal: Signal<Boolean>): TextField {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for TextField.
 */
@JvmName("textFieldThemeVariantsSignal")
fun TextField.themeVariants(signal: Signal<Set<TextFieldVariant>>): TextField {
    var previousVariants = emptySet<TextFieldVariant>()

    fun apply(variants: Set<TextFieldVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}