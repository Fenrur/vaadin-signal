package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexLayout

// ============================================
// FlexLayout extensions
// ============================================

/**
 * Reactive flex direction for FlexLayout.
 */
@JvmName("flexLayoutFlexDirectionSignal")
fun FlexLayout.flexDirection(signal: Signal<FlexLayout.FlexDirection>): FlexLayout {
    fun apply(direction: FlexLayout.FlexDirection) {
        setFlexDirection(direction)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive flex wrap for FlexLayout.
 */
@JvmName("flexLayoutFlexWrapSignal")
fun FlexLayout.flexWrap(signal: Signal<FlexLayout.FlexWrap>): FlexLayout {
    fun apply(wrap: FlexLayout.FlexWrap) {
        setFlexWrap(wrap)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align content for FlexLayout.
 */
@JvmName("flexLayoutAlignContentSignal")
fun FlexLayout.alignContent(signal: Signal<FlexLayout.ContentAlignment>): FlexLayout {
    fun apply(alignment: FlexLayout.ContentAlignment) {
        setAlignContent(alignment)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align items for FlexLayout.
 */
@JvmName("flexLayoutAlignItemsSignal")
fun FlexLayout.alignItems(signal: Signal<FlexComponent.Alignment?>): FlexLayout {
    fun apply(alignment: FlexComponent.Alignment?) {
        setAlignItems(alignment)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive justify content mode for FlexLayout.
 */
@JvmName("flexLayoutJustifyContentModeSignal")
fun FlexLayout.justifyContentMode(signal: Signal<FlexComponent.JustifyContentMode>): FlexLayout {
    fun apply(mode: FlexComponent.JustifyContentMode) {
        setJustifyContentMode(mode)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
