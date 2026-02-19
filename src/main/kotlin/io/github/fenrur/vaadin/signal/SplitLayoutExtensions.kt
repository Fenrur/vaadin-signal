package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.splitlayout.SplitLayout
import com.vaadin.flow.component.splitlayout.SplitLayoutVariant

// ============================================
// SplitLayout extensions
// ============================================

/**
 * Reactive orientation for SplitLayout.
 */
@JvmName("splitLayoutOrientationSignal")
fun SplitLayout.orientation(signal: Signal<SplitLayout.Orientation>): SplitLayout {
    fun apply(orientation: SplitLayout.Orientation) {
        setOrientation(orientation)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive splitter position for SplitLayout.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("splitLayoutSplitterPositionSignal")
fun SplitLayout.splitterPosition(signal: Signal<Double>): SplitLayout {
    fun apply(position: Double) {
        setSplitterPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for SplitLayout splitter position.
 */
@JvmName("splitLayoutSplitterPositionMutableSignal")
fun SplitLayout.splitterPosition(signal: MutableSignal<Double>): SplitLayout {
    setSplitterPosition(signal.value)

    addSplitterDragendListener {
        // Get the splitter position from the primary component's flex-basis
        val primaryElement = primaryComponent?.element
        val flexBasis = primaryElement?.style?.get("flex-basis")
        val position = flexBasis?.removeSuffix("%")?.toDoubleOrNull() ?: 50.0
        signal.value = position
    }

    effect(signal) {
        setSplitterPosition(it)
    }
    return this
}

/**
 * Reactive theme variants for SplitLayout.
 */
@JvmName("splitLayoutThemeVariantsSignal")
fun SplitLayout.themeVariants(signal: Signal<Set<SplitLayoutVariant>>): SplitLayout {
    var previousVariants = emptySet<SplitLayoutVariant>()

    fun apply(variants: Set<SplitLayoutVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for SplitLayout.
 */
@JvmName("splitLayoutThemeVariantSignal")
fun SplitLayout.themeVariant(signal: Signal<SplitLayoutVariant?>): SplitLayout {
    var previousVariant: SplitLayoutVariant? = null

    fun apply(variant: SplitLayoutVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive minimal theme for SplitLayout.
 */
@JvmName("splitLayoutMinimalSignal")
fun SplitLayout.minimal(signal: Signal<Boolean>): SplitLayout {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(SplitLayoutVariant.LUMO_MINIMAL)
        } else {
            removeThemeVariants(SplitLayoutVariant.LUMO_MINIMAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small theme for SplitLayout.
 */
@JvmName("splitLayoutSmallSignal")
fun SplitLayout.small(signal: Signal<Boolean>): SplitLayout {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(SplitLayoutVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(SplitLayoutVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
