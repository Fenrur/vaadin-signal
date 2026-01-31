package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.Scroller
import com.vaadin.flow.component.orderedlayout.ScrollerVariant

// ============================================
// Scroller extensions
// ============================================

/**
 * Reactive scroll direction for Scroller.
 */
fun Scroller.scrollDirection(signal: Signal<Scroller.ScrollDirection>) {
    fun apply(direction: Scroller.ScrollDirection) {
        setScrollDirection(direction)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Scroller.
 */
fun Scroller.themeVariants(signal: Signal<Set<ScrollerVariant>>) {
    var previousVariants = emptySet<ScrollerVariant>()

    fun apply(variants: Set<ScrollerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Scroller.
 */
fun Scroller.themeVariant(signal: Signal<ScrollerVariant?>) {
    var previousVariant: ScrollerVariant? = null

    fun apply(variant: ScrollerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overflow indicators for Scroller.
 */
fun Scroller.overflowIndicators(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(ScrollerVariant.LUMO_OVERFLOW_INDICATORS)
        } else {
            removeThemeVariants(ScrollerVariant.LUMO_OVERFLOW_INDICATORS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
