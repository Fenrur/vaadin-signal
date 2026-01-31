package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.popover.Popover
import com.vaadin.flow.component.popover.PopoverPosition
import com.vaadin.flow.component.popover.PopoverVariant

// ============================================
// Popover extensions
// ============================================

/**
 * Reactive opened state for Popover.
 * Note: This is a one-way binding (signal to component).
 */
fun Popover.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for Popover opened state.
 */
@JvmName("popoverOpenedTwoWay")
fun Popover.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive position for Popover.
 */
fun Popover.position(signal: Signal<PopoverPosition>) {
    fun apply(position: PopoverPosition) {
        setPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive modal state for Popover.
 */
fun Popover.modal(signal: Signal<Boolean>) {
    fun apply(modal: Boolean) {
        isModal = modal
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive backdrop visible for Popover.
 */
fun Popover.backdropVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isBackdropVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autofocus for Popover.
 */
fun Popover.autofocus(signal: Signal<Boolean>) {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive close on outside click for Popover.
 */
fun Popover.closeOnOutsideClick(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        isCloseOnOutsideClick = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive close on Esc for Popover.
 */
fun Popover.closeOnEsc(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        isCloseOnEsc = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive width for Popover.
 */
fun Popover.popoverWidth(signal: Signal<String?>) {
    fun apply(width: String?) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive height for Popover.
 */
fun Popover.popoverHeight(signal: Signal<String?>) {
    fun apply(height: String?) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Popover.
 */
fun Popover.themeVariants(signal: Signal<Set<PopoverVariant>>) {
    var previousVariants = emptySet<PopoverVariant>()

    fun apply(variants: Set<PopoverVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Popover.
 */
fun Popover.themeVariant(signal: Signal<PopoverVariant?>) {
    var previousVariant: PopoverVariant? = null

    fun apply(variant: PopoverVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive arrow theme for Popover.
 */
fun Popover.arrow(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(PopoverVariant.ARROW)
        } else {
            removeThemeVariants(PopoverVariant.ARROW)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive no-padding theme for Popover.
 */
fun Popover.noPadding(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(PopoverVariant.LUMO_NO_PADDING)
        } else {
            removeThemeVariants(PopoverVariant.LUMO_NO_PADDING)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
