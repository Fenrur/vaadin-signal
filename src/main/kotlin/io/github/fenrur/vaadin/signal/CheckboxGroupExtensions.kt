package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.checkbox.CheckboxGroup
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant

// ============================================
// CheckboxGroup extensions
// ============================================

/**
 * Reactive required indicator for CheckboxGroup.
 */
@JvmName("checkboxGroupRequiredSignal")
fun <TItem> CheckboxGroup<TItem>.required(signal: Signal<Boolean>): CheckboxGroup<TItem> {
    fun apply(required: Boolean) {
        isRequired = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for CheckboxGroup.
 */
@JvmName("checkboxGroupThemeVariantsSignal")
fun <TItem> CheckboxGroup<TItem>.themeVariants(signal: Signal<Set<CheckboxGroupVariant>>): CheckboxGroup<TItem> {
    var previousVariants = emptySet<CheckboxGroupVariant>()

    fun apply(variants: Set<CheckboxGroupVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for CheckboxGroup.
 */
@JvmName("checkboxGroupThemeVariantSignal")
fun <TItem> CheckboxGroup<TItem>.themeVariant(signal: Signal<CheckboxGroupVariant?>): CheckboxGroup<TItem> {
    var previousVariant: CheckboxGroupVariant? = null

    fun apply(variant: CheckboxGroupVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive vertical orientation for CheckboxGroup.
 */
@JvmName("checkboxGroupVerticalSignal")
fun <TItem> CheckboxGroup<TItem>.vertical(signal: Signal<Boolean>): CheckboxGroup<TItem> {
    fun apply(isVertical: Boolean) {
        if (isVertical) {
            addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL)
        } else {
            removeThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper above field for CheckboxGroup.
 */
@JvmName("checkboxGroupHelperAboveFieldSignal")
fun <TItem> CheckboxGroup<TItem>.helperAboveField(signal: Signal<Boolean>): CheckboxGroup<TItem> {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
