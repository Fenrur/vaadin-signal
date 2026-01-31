package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.BoxSizing
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout

// ============================================
// VerticalLayout extensions
// ============================================

/**
 * Reactive spacing for VerticalLayout.
 */
fun VerticalLayout.spacing(signal: Signal<Boolean>): VerticalLayout {
    fun apply(hasSpacing: Boolean) {
        isSpacing = hasSpacing
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive padding for VerticalLayout.
 */
fun VerticalLayout.padding(signal: Signal<Boolean>): VerticalLayout {
    fun apply(hasPadding: Boolean) {
        isPadding = hasPadding
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive margin for VerticalLayout.
 */
fun VerticalLayout.margin(signal: Signal<Boolean>): VerticalLayout {
    fun apply(hasMargin: Boolean) {
        isMargin = hasMargin
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive justify content for VerticalLayout.
 */
fun VerticalLayout.justifyContent(signal: Signal<FlexComponent.JustifyContentMode>) {
    fun apply(mode: FlexComponent.JustifyContentMode) {
        justifyContentMode = mode
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align items for VerticalLayout.
 */
fun VerticalLayout.alignItems(signal: Signal<FlexComponent.Alignment>) {
    fun apply(alignment: FlexComponent.Alignment) {
        defaultHorizontalComponentAlignment = alignment
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive wrap for VerticalLayout.
 */
fun VerticalLayout.wrap(signal: Signal<Boolean>): VerticalLayout {
    fun apply(wrap: Boolean) {
        setWrap(wrap)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive box sizing for VerticalLayout.
 */
fun VerticalLayout.boxSizing(signal: Signal<BoxSizing?>): VerticalLayout {
    fun apply(boxSizing: BoxSizing?) {
        setBoxSizing(boxSizing)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
