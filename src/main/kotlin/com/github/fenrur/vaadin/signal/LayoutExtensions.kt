package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout

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
