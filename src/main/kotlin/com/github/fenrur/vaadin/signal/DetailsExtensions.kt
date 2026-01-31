package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.details.Details
import com.vaadin.flow.component.details.DetailsVariant

// ============================================
// Details extensions
// ============================================

/**
 * Reactive opened state for Details.
 * Note: This is a one-way binding (signal to component).
 */
fun Details.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for Details opened state.
 */
@JvmName("detailsOpenedTwoWay")
fun Details.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    addOpenedChangeListener {
        signal.value = it.isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive summary text for Details.
 */
fun Details.summaryText(signal: Signal<String>) {
    fun apply(text: String) {
        setSummaryText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Details.
 */
fun Details.themeVariants(signal: Signal<Set<DetailsVariant>>) {
    var previousVariants = emptySet<DetailsVariant>()

    fun apply(variants: Set<DetailsVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Details.
 */
fun Details.themeVariant(signal: Signal<DetailsVariant?>) {
    var previousVariant: DetailsVariant? = null

    fun apply(variant: DetailsVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive filled theme for Details.
 */
fun Details.filled(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DetailsVariant.FILLED)
        } else {
            removeThemeVariants(DetailsVariant.FILLED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive reverse theme for Details.
 */
fun Details.reverse(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DetailsVariant.REVERSE)
        } else {
            removeThemeVariants(DetailsVariant.REVERSE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for Details.
 */
fun Details.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DetailsVariant.SMALL)
        } else {
            removeThemeVariants(DetailsVariant.SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
