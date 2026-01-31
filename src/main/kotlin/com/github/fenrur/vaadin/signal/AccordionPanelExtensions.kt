package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.accordion.AccordionPanel

// ============================================
// AccordionPanel extensions
// ============================================

/**
 * Reactive opened state for AccordionPanel.
 * Note: This is a one-way binding (signal to component).
 */
fun AccordionPanel.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for AccordionPanel opened state.
 */
@JvmName("accordionPanelOpenedTwoWay")
fun AccordionPanel.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    addOpenedChangeListener {
        signal.value = it.isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive summary text for AccordionPanel.
 */
fun AccordionPanel.summaryText(signal: Signal<String>) {
    fun apply(text: String) {
        setSummaryText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
