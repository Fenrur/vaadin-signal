package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.Scroller
import com.vaadin.flow.component.orderedlayout.ScrollerVariant

// ============================================
// Scroller extensions
// ============================================

/**
 * Reactive scroll direction for Scroller.
 */
@JvmName("scrollerScrollDirectionSignal")
fun Scroller.scrollDirection(signal: Signal<Scroller.ScrollDirection>): Scroller {
    fun apply(direction: Scroller.ScrollDirection) {
        setScrollDirection(direction)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Scroller.
 */
@JvmName("scrollerThemeVariantsSignal")
fun Scroller.themeVariants(signal: Signal<Set<ScrollerVariant>>): Scroller {
    var previousVariants = emptySet<ScrollerVariant>()

    fun apply(variants: Set<ScrollerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Scroller.
 */
@JvmName("scrollerThemeVariantSignal")
fun Scroller.themeVariant(signal: Signal<ScrollerVariant?>): Scroller {
    var previousVariant: ScrollerVariant? = null

    fun apply(variant: ScrollerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive overflow indicators for Scroller.
 */
@JvmName("scrollerOverflowIndicatorsSignal")
fun Scroller.overflowIndicators(signal: Signal<Boolean>): Scroller {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(ScrollerVariant.LUMO_OVERFLOW_INDICATORS)
        } else {
            removeThemeVariants(ScrollerVariant.LUMO_OVERFLOW_INDICATORS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
