package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.accordion.AccordionPanel

// ============================================
// AccordionPanel extensions
// ============================================

/**
 * Reactive opened state for AccordionPanel.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("accordionPanelOpenedSignal")
fun AccordionPanel.opened(signal: Signal<Boolean>): AccordionPanel {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for AccordionPanel opened state.
 */
@JvmName("accordionPanelOpenedMutableSignal")
fun AccordionPanel.opened(signal: MutableSignal<Boolean>): AccordionPanel {
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
 * Reactive summary text for AccordionPanel.
 */
@JvmName("accordionPanelSummaryTextSignal")
fun AccordionPanel.summaryText(signal: Signal<String>): AccordionPanel {
    fun apply(text: String) {
        setSummaryText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
