package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.splitlayout.SplitLayout
import com.vaadin.flow.component.splitlayout.SplitLayoutVariant

// ============================================
// SplitLayout extensions
// ============================================

/**
 * Reactive orientation for SplitLayout.
 */
fun SplitLayout.orientation(signal: Signal<SplitLayout.Orientation>) {
    fun apply(orientation: SplitLayout.Orientation) {
        setOrientation(orientation)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive splitter position for SplitLayout.
 * Note: This is a one-way binding (signal to component).
 */
fun SplitLayout.splitterPosition(signal: Signal<Double>) {
    fun apply(position: Double) {
        setSplitterPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for SplitLayout splitter position.
 */
@JvmName("splitLayoutSplitterPositionTwoWay")
fun SplitLayout.splitterPosition(signal: MutableSignal<Double>) {
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
}

/**
 * Reactive theme variants for SplitLayout.
 */
fun SplitLayout.themeVariants(signal: Signal<Set<SplitLayoutVariant>>) {
    var previousVariants = emptySet<SplitLayoutVariant>()

    fun apply(variants: Set<SplitLayoutVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for SplitLayout.
 */
fun SplitLayout.themeVariant(signal: Signal<SplitLayoutVariant?>) {
    var previousVariant: SplitLayoutVariant? = null

    fun apply(variant: SplitLayoutVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minimal theme for SplitLayout.
 */
fun SplitLayout.minimal(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(SplitLayoutVariant.LUMO_MINIMAL)
        } else {
            removeThemeVariants(SplitLayoutVariant.LUMO_MINIMAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for SplitLayout.
 */
fun SplitLayout.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(SplitLayoutVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(SplitLayoutVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
