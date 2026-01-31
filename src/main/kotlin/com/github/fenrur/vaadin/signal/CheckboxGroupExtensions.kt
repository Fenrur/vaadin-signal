package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.checkbox.CheckboxGroup
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant

// ============================================
// CheckboxGroup extensions
// ============================================

/**
 * Reactive value for CheckboxGroup.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("checkboxGroupValueSignal")
fun <TItem> CheckboxGroup<TItem>.value(signal: Signal<Set<TItem>>) {
    fun apply(value: Set<TItem>) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for CheckboxGroup selected items.
 */
@JvmName("checkboxGroupValueMutableSignal")
fun <TItem> CheckboxGroup<TItem>.value(signal: MutableSignal<Set<TItem>>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for CheckboxGroup.
 */
@JvmName("checkboxGroupLabelSignal")
fun <TItem> CheckboxGroup<TItem>.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

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
 * Reactive invalid state for CheckboxGroup.
 */
@JvmName("checkboxGroupInvalidSignal")
fun <TItem> CheckboxGroup<TItem>.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        isInvalid = invalid
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for CheckboxGroup.
 */
@JvmName("checkboxGroupErrorMessageSignal")
fun <TItem> CheckboxGroup<TItem>.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive aria label for CheckboxGroup.
 */
@JvmName("checkboxGroupAriaLabelSignal")
fun <TItem> CheckboxGroup<TItem>.ariaLabel(signal: Signal<String?>) {
    fun apply(ariaLabel: String?) {
        setAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive aria labelled by for CheckboxGroup.
 */
@JvmName("checkboxGroupAriaLabelledBySignal")
fun <TItem> CheckboxGroup<TItem>.ariaLabelledBy(signal: Signal<String?>) {
    fun apply(labelledBy: String?) {
        setAriaLabelledBy(labelledBy)
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
