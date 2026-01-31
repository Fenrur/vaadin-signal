package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.accordion.Accordion

// ============================================
// Accordion extensions
// ============================================

/**
 * Reactive opened index for Accordion.
 * Note: This is a one-way binding (signal to component).
 */
fun Accordion.openedIndex(signal: Signal<Int?>) {
    fun apply(index: Int?) {
        if (index == null) {
            close()
        } else {
            open(index)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for Accordion opened index.
 */
@JvmName("accordionOpenedIndexTwoWay")
fun Accordion.openedIndex(signal: MutableSignal<Int?>) {
    val index = signal.value
    if (index == null) {
        close()
    } else {
        open(index)
    }

    addOpenedChangeListener {
        val openedIndex = it.openedIndex
        signal.value = if (openedIndex.isPresent) openedIndex.asInt else null
    }

    effect(signal) {
        if (it == null) {
            close()
        } else {
            open(it)
        }
    }
}
