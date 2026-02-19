package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.details.Details
import com.vaadin.flow.component.details.DetailsVariant

// ============================================
// Details extensions
// ============================================

/**
 * Reactive opened state for Details.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("detailsOpenedSignal")
fun Details.opened(signal: Signal<Boolean>): Details {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for Details opened state.
 */
@JvmName("detailsOpenedMutableSignal")
fun Details.opened(signal: MutableSignal<Boolean>): Details {
    isOpened = signal.value

    addOpenedChangeListener {
        signal.value = it.isOpened
    }

    effect(signal) {
        isOpened = it
    }
    return this
}

/**
 * Reactive summary text for Details.
 */
@JvmName("detailsSummaryTextSignal")
fun Details.summaryText(signal: Signal<String>): Details {
    fun apply(text: String) {
        setSummaryText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Details.
 */
@JvmName("detailsThemeVariantsSignal")
fun Details.themeVariants(signal: Signal<Set<DetailsVariant>>): Details {
    var previousVariants = emptySet<DetailsVariant>()

    fun apply(variants: Set<DetailsVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Details.
 */
@JvmName("detailsThemeVariantSignal")
fun Details.themeVariant(signal: Signal<DetailsVariant?>): Details {
    var previousVariant: DetailsVariant? = null

    fun apply(variant: DetailsVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive filled theme for Details.
 */
@JvmName("detailsFilledSignal")
fun Details.filled(signal: Signal<Boolean>): Details {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DetailsVariant.FILLED)
        } else {
            removeThemeVariants(DetailsVariant.FILLED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive reverse theme for Details.
 */
@JvmName("detailsReverseSignal")
fun Details.reverse(signal: Signal<Boolean>): Details {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DetailsVariant.REVERSE)
        } else {
            removeThemeVariants(DetailsVariant.REVERSE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small theme for Details.
 */
@JvmName("detailsSmallSignal")
fun Details.small(signal: Signal<Boolean>): Details {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DetailsVariant.SMALL)
        } else {
            removeThemeVariants(DetailsVariant.SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
