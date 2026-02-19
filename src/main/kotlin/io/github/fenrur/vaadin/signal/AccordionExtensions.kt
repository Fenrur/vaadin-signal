package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.accordion.Accordion

// ============================================
// Accordion extensions
// ============================================

/**
 * Reactive opened index for Accordion.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("accordionOpenedIndexSignal")
fun Accordion.openedIndex(signal: Signal<Int?>): Accordion {
    fun apply(index: Int?) {
        if (index == null) {
            close()
        } else {
            open(index)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for Accordion opened index.
 */
@JvmName("accordionOpenedIndexMutableSignal")
fun Accordion.openedIndex(signal: MutableSignal<Int?>): Accordion {
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
    return this
}
