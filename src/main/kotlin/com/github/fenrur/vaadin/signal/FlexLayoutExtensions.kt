package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexLayout

// ============================================
// FlexLayout extensions
// ============================================

/**
 * Reactive flex direction for FlexLayout.
 */
fun FlexLayout.flexDirection(signal: Signal<FlexLayout.FlexDirection>) {
    fun apply(direction: FlexLayout.FlexDirection) {
        setFlexDirection(direction)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive flex wrap for FlexLayout.
 */
fun FlexLayout.flexWrap(signal: Signal<FlexLayout.FlexWrap>) {
    fun apply(wrap: FlexLayout.FlexWrap) {
        setFlexWrap(wrap)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align content for FlexLayout.
 */
fun FlexLayout.alignContent(signal: Signal<FlexLayout.ContentAlignment>) {
    fun apply(alignment: FlexLayout.ContentAlignment) {
        setAlignContent(alignment)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align items for FlexLayout.
 */
fun FlexLayout.alignItems(signal: Signal<FlexComponent.Alignment?>) {
    fun apply(alignment: FlexComponent.Alignment?) {
        setAlignItems(alignment)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive justify content mode for FlexLayout.
 */
fun FlexLayout.justifyContentMode(signal: Signal<FlexComponent.JustifyContentMode>) {
    fun apply(mode: FlexComponent.JustifyContentMode) {
        setJustifyContentMode(mode)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
