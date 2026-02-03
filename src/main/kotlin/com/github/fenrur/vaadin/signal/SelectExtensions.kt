package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.select.Select
import com.vaadin.flow.component.select.SelectVariant

// ============================================
// Select extensions
// ============================================

/**
 * Reactive value for Select.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("selectValueSignal")
fun <TItem> Select<TItem>.value(signal: Signal<TItem?>) {
    fun apply(value: TItem?) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autofocus for Select.
 */
@JvmName("selectAutofocusSignal")
fun <TItem> Select<TItem>.autofocus(signal: Signal<Boolean>) {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required indicator for Select.
 */
@JvmName("selectRequiredSignal")
fun <TItem> Select<TItem>.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive empty selection allowed for Select.
 */
@JvmName("selectEmptySelectionAllowedSignal")
fun <TItem> Select<TItem>.emptySelectionAllowed(signal: Signal<Boolean>) {
    fun apply(allowed: Boolean) {
        isEmptySelectionAllowed = allowed
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive empty selection caption for Select.
 */
@JvmName("selectEmptySelectionCaptionSignal")
fun <TItem> Select<TItem>.emptySelectionCaption(signal: Signal<String>) {
    fun apply(caption: String) {
        setEmptySelectionCaption(caption)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive no vertical overlap for Select overlay.
 */
@JvmName("selectNoVerticalOverlapSignal")
fun <TItem> Select<TItem>.noVerticalOverlap(signal: Signal<Boolean>) {
    fun apply(noOverlap: Boolean) {
        isNoVerticalOverlap = noOverlap
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay width for Select.
 */
@JvmName("selectOverlayWidthSignal")
fun <TItem> Select<TItem>.overlayWidth(signal: Signal<String?>) {
    fun apply(width: String?) {
        setOverlayWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay class name for Select.
 */
@JvmName("selectOverlayClassNameSignal")
fun <TItem> Select<TItem>.overlayClassName(signal: Signal<String>) {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Select.
 */
@JvmName("selectThemeVariantsSignal")
fun <TItem> Select<TItem>.themeVariants(signal: Signal<Set<SelectVariant>>) {
    var previousVariants = emptySet<SelectVariant>()

    fun apply(variants: Set<SelectVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Select.
 */
@JvmName("selectThemeVariantSignal")
fun <TItem> Select<TItem>.themeVariant(signal: Signal<SelectVariant?>) {
    var previousVariant: SelectVariant? = null

    fun apply(variant: SelectVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for Select.
 */
@JvmName("selectSmallSignal")
fun <TItem> Select<TItem>.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(SelectVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(SelectVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for Select.
 */
@JvmName("selectHelperAboveFieldSignal")
fun <TItem> Select<TItem>.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(SelectVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(SelectVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
