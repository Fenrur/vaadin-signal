package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.customfield.CustomField
import com.vaadin.flow.component.customfield.CustomFieldVariant

// ============================================
// CustomField extensions
// ============================================

/**
 * Two-way binding for CustomField value.
 */
@JvmName("customFieldValueMutableSignal")
fun <T> CustomField<T>.value(signal: MutableSignal<T?>) {
    value = signal.value

    addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive theme variants for CustomField.
 */
@JvmName("customFieldThemeVariantsSignal")
fun <T> CustomField<T>.themeVariants(signal: Signal<Set<CustomFieldVariant>>) {
    var previousVariants = emptySet<CustomFieldVariant>()

    fun apply(variants: Set<CustomFieldVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for CustomField.
 */
@JvmName("customFieldThemeVariantSignal")
fun <T> CustomField<T>.themeVariant(signal: Signal<CustomFieldVariant?>) {
    var previousVariant: CustomFieldVariant? = null

    fun apply(variant: CustomFieldVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for CustomField.
 */
@JvmName("customFieldSmallSignal")
fun <T> CustomField<T>.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(CustomFieldVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(CustomFieldVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field theme for CustomField.
 */
@JvmName("customFieldHelperAboveFieldSignal")
fun <T> CustomField<T>.helperAboveField(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(CustomFieldVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(CustomFieldVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive whitespace theme for CustomField.
 */
@JvmName("customFieldWhitespaceSignal")
fun <T> CustomField<T>.whitespace(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(CustomFieldVariant.LUMO_WHITESPACE)
        } else {
            removeThemeVariants(CustomFieldVariant.LUMO_WHITESPACE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
