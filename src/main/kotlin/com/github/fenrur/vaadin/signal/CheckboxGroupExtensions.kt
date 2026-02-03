package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.checkbox.CheckboxGroup
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant

// ============================================
// CheckboxGroup extensions
// ============================================

/**
 * Reactive required indicator for CheckboxGroup.
 */
@JvmName("checkboxGroupRequiredSignal")
fun <TItem> CheckboxGroup<TItem>.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequired = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for CheckboxGroup.
 */
@JvmName("checkboxGroupThemeVariantsSignal")
fun <TItem> CheckboxGroup<TItem>.themeVariants(signal: Signal<Set<CheckboxGroupVariant>>) {
    var previousVariants = emptySet<CheckboxGroupVariant>()

    fun apply(variants: Set<CheckboxGroupVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for CheckboxGroup.
 */
@JvmName("checkboxGroupThemeVariantSignal")
fun <TItem> CheckboxGroup<TItem>.themeVariant(signal: Signal<CheckboxGroupVariant?>) {
    var previousVariant: CheckboxGroupVariant? = null

    fun apply(variant: CheckboxGroupVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive vertical orientation for CheckboxGroup.
 */
@JvmName("checkboxGroupVerticalSignal")
fun <TItem> CheckboxGroup<TItem>.vertical(signal: Signal<Boolean>) {
    fun apply(isVertical: Boolean) {
        if (isVertical) {
            addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL)
        } else {
            removeThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for CheckboxGroup.
 */
@JvmName("checkboxGroupHelperAboveFieldSignal")
fun <TItem> CheckboxGroup<TItem>.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
