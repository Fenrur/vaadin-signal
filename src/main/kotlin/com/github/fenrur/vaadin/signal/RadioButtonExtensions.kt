package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.radiobutton.RadioButtonGroup
import com.vaadin.flow.component.radiobutton.RadioGroupVariant

// ============================================
// RadioButtonGroup extensions
// ============================================

/**
 * Reactive value for RadioButtonGroup.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("radioButtonGroupValueSignal")
fun <TItem> RadioButtonGroup<TItem>.value(signal: Signal<TItem?>) {
    fun apply(value: TItem?) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for RadioButtonGroup selected item.
 */
@JvmName("radioButtonGroupValueMutableSignal")
fun <TItem> RadioButtonGroup<TItem>.value(signal: MutableSignal<TItem?>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive required indicator for RadioButtonGroup.
 */
@JvmName("radioButtonGroupRequiredSignal")
fun <TItem> RadioButtonGroup<TItem>.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for RadioButtonGroup.
 */
@JvmName("radioButtonGroupThemeVariantsSignal")
fun <TItem> RadioButtonGroup<TItem>.themeVariants(signal: Signal<Set<RadioGroupVariant>>) {
    var previousVariants = emptySet<RadioGroupVariant>()

    fun apply(variants: Set<RadioGroupVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for RadioButtonGroup.
 */
@JvmName("radioButtonGroupThemeVariantSignal")
fun <TItem> RadioButtonGroup<TItem>.themeVariant(signal: Signal<RadioGroupVariant?>) {
    var previousVariant: RadioGroupVariant? = null

    fun apply(variant: RadioGroupVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive vertical orientation for RadioButtonGroup.
 */
@JvmName("radioButtonGroupVerticalSignal")
fun <TItem> RadioButtonGroup<TItem>.vertical(signal: Signal<Boolean>) {
    fun apply(isVertical: Boolean) {
        if (isVertical) {
            addThemeVariants(RadioGroupVariant.LUMO_VERTICAL)
        } else {
            removeThemeVariants(RadioGroupVariant.LUMO_VERTICAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for RadioButtonGroup.
 */
@JvmName("radioButtonGroupHelperAboveFieldSignal")
fun <TItem> RadioButtonGroup<TItem>.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(RadioGroupVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(RadioGroupVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly state for RadioButtonGroup.
 */
@JvmName("radioButtonGroupReadonlySignal")
fun <TItem> RadioButtonGroup<TItem>.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
