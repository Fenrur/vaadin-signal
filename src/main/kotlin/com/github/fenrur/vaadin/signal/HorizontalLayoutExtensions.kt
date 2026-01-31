package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.BoxSizing
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout

// ============================================
// HorizontalLayout extensions
// ============================================

/**
 * Reactive spacing for HorizontalLayout.
 */
fun HorizontalLayout.spacing(signal: Signal<Boolean>): HorizontalLayout {
    fun apply(hasSpacing: Boolean) {
        isSpacing = hasSpacing
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive padding for HorizontalLayout.
 */
fun HorizontalLayout.padding(signal: Signal<Boolean>): HorizontalLayout {
    fun apply(hasPadding: Boolean) {
        isPadding = hasPadding
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive margin for HorizontalLayout.
 */
fun HorizontalLayout.margin(signal: Signal<Boolean>): HorizontalLayout {
    fun apply(hasMargin: Boolean) {
        isMargin = hasMargin
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive justify content for HorizontalLayout.
 */
fun HorizontalLayout.justifyContent(signal: Signal<FlexComponent.JustifyContentMode>) {
    fun apply(mode: FlexComponent.JustifyContentMode) {
        justifyContentMode = mode
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align items for HorizontalLayout.
 */
fun HorizontalLayout.alignItems(signal: Signal<FlexComponent.Alignment>) {
    fun apply(alignment: FlexComponent.Alignment) {
        setDefaultVerticalComponentAlignment(alignment)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive wrap for HorizontalLayout.
 */
fun HorizontalLayout.wrap(signal: Signal<Boolean>): HorizontalLayout {
    fun apply(wrap: Boolean) {
        setWrap(wrap)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive box sizing for HorizontalLayout.
 */
fun HorizontalLayout.boxSizing(signal: Signal<BoxSizing?>): HorizontalLayout {
    fun apply(boxSizing: BoxSizing?) {
        setBoxSizing(boxSizing)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
