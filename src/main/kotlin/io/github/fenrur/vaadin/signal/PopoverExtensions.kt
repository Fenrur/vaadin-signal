package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
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
@JvmName("popoverOpenedSignal")
fun Popover.opened(signal: Signal<Boolean>): Popover {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for Popover opened state.
 */
@JvmName("popoverOpenedMutableSignal")
fun Popover.opened(signal: MutableSignal<Boolean>): Popover {
    isOpened = signal.value

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        isOpened = it
    }
    return this
}

/**
 * Reactive position for Popover.
 */
@JvmName("popoverPositionSignal")
fun Popover.position(signal: Signal<PopoverPosition>): Popover {
    fun apply(position: PopoverPosition) {
        setPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive modal state for Popover.
 */
@JvmName("popoverModalSignal")
fun Popover.modal(signal: Signal<Boolean>): Popover {
    fun apply(modal: Boolean) {
        isModal = modal
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive backdrop visible for Popover.
 */
@JvmName("popoverBackdropVisibleSignal")
fun Popover.backdropVisible(signal: Signal<Boolean>): Popover {
    fun apply(visible: Boolean) {
        isBackdropVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive autofocus for Popover.
 */
@JvmName("popoverAutofocusSignal")
fun Popover.autofocus(signal: Signal<Boolean>): Popover {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive close on outside click for Popover.
 */
@JvmName("popoverCloseOnOutsideClickSignal")
fun Popover.closeOnOutsideClick(signal: Signal<Boolean>): Popover {
    fun apply(enabled: Boolean) {
        isCloseOnOutsideClick = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive close on Esc for Popover.
 */
@JvmName("popoverCloseOnEscSignal")
fun Popover.closeOnEsc(signal: Signal<Boolean>): Popover {
    fun apply(enabled: Boolean) {
        isCloseOnEsc = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive width for Popover.
 */
@JvmName("popoverWidthSignal")
fun Popover.popoverWidth(signal: Signal<String?>): Popover {
    fun apply(width: String?) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive height for Popover.
 */
@JvmName("popoverHeightSignal")
fun Popover.popoverHeight(signal: Signal<String?>): Popover {
    fun apply(height: String?) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Popover.
 */
@JvmName("popoverThemeVariantsSignal")
fun Popover.themeVariants(signal: Signal<Set<PopoverVariant>>): Popover {
    var previousVariants = emptySet<PopoverVariant>()

    fun apply(variants: Set<PopoverVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Popover.
 */
@JvmName("popoverThemeVariantSignal")
fun Popover.themeVariant(signal: Signal<PopoverVariant?>): Popover {
    var previousVariant: PopoverVariant? = null

    fun apply(variant: PopoverVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive arrow theme for Popover.
 */
@JvmName("popoverArrowSignal")
fun Popover.arrow(signal: Signal<Boolean>): Popover {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(PopoverVariant.ARROW)
        } else {
            removeThemeVariants(PopoverVariant.ARROW)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive no-padding theme for Popover.
 */
@JvmName("popoverNoPaddingSignal")
fun Popover.noPadding(signal: Signal<Boolean>): Popover {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(PopoverVariant.LUMO_NO_PADDING)
        } else {
            removeThemeVariants(PopoverVariant.LUMO_NO_PADDING)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
