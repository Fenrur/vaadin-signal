package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.dialog.DialogVariant

// ============================================
// Dialog extensions
// ============================================

/**
 * Reactive opened state for Dialog.
 * Note: This is a one-way binding (signal to component).
 */
fun Dialog.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for Dialog opened state.
 */
@JvmName("dialogOpenedTwoWay")
fun Dialog.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive modal state for Dialog.
 */
fun Dialog.modal(signal: Signal<Boolean>) {
    fun apply(isModal: Boolean) {
        setModal(isModal)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive resizable state for Dialog.
 */
fun Dialog.resizable(signal: Signal<Boolean>) {
    fun apply(isResizable: Boolean) {
        setResizable(isResizable)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive draggable state for Dialog.
 */
fun Dialog.draggable(signal: Signal<Boolean>) {
    fun apply(isDraggable: Boolean) {
        setDraggable(isDraggable)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive width for Dialog.
 */
fun Dialog.dialogWidth(signal: Signal<String?>) {
    fun apply(width: String?) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive height for Dialog.
 */
fun Dialog.dialogHeight(signal: Signal<String?>) {
    fun apply(height: String?) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min width for Dialog.
 */
fun Dialog.minWidth(signal: Signal<String?>) {
    fun apply(minWidth: String?) {
        setMinWidth(minWidth)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max width for Dialog.
 */
fun Dialog.maxWidth(signal: Signal<String?>) {
    fun apply(maxWidth: String?) {
        setMaxWidth(maxWidth)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min height for Dialog.
 */
fun Dialog.minHeight(signal: Signal<String?>) {
    fun apply(minHeight: String?) {
        setMinHeight(minHeight)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max height for Dialog.
 */
fun Dialog.maxHeight(signal: Signal<String?>) {
    fun apply(maxHeight: String?) {
        setMaxHeight(maxHeight)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive top position for Dialog.
 */
fun Dialog.top(signal: Signal<String?>) {
    fun apply(top: String?) {
        setTop(top)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive left position for Dialog.
 */
fun Dialog.left(signal: Signal<String?>) {
    fun apply(left: String?) {
        setLeft(left)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive header title for Dialog.
 */
fun Dialog.headerTitle(signal: Signal<String>) {
    fun apply(title: String) {
        setHeaderTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive close on outside click for Dialog.
 */
fun Dialog.closeOnOutsideClick(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        setCloseOnOutsideClick(enabled)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive close on Escape for Dialog.
 */
fun Dialog.closeOnEsc(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        setCloseOnEsc(enabled)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Dialog.
 */
fun Dialog.themeVariants(signal: Signal<Set<DialogVariant>>) {
    var previousVariants = emptySet<DialogVariant>()

    fun apply(variants: Set<DialogVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Dialog.
 */
fun Dialog.themeVariant(signal: Signal<DialogVariant?>) {
    var previousVariant: DialogVariant? = null

    fun apply(variant: DialogVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive no-padding theme for Dialog.
 */
fun Dialog.noPadding(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DialogVariant.LUMO_NO_PADDING)
        } else {
            removeThemeVariants(DialogVariant.LUMO_NO_PADDING)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
