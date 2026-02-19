package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.dialog.DialogVariant

// ============================================
// Dialog extensions
// ============================================

/**
 * Reactive opened state for Dialog.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("dialogOpenedSignal")
fun Dialog.opened(signal: Signal<Boolean>): Dialog {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for Dialog opened state.
 */
@JvmName("dialogOpenedMutableSignal")
fun Dialog.opened(signal: MutableSignal<Boolean>): Dialog {
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
 * Reactive modal state for Dialog.
 */
@JvmName("dialogModalSignal")
fun Dialog.modal(signal: Signal<Boolean>): Dialog {
    fun apply(isModal: Boolean) {
        setModal(isModal)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive resizable state for Dialog.
 */
@JvmName("dialogResizableSignal")
fun Dialog.resizable(signal: Signal<Boolean>): Dialog {
    fun apply(isResizable: Boolean) {
        setResizable(isResizable)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive draggable state for Dialog.
 */
@JvmName("dialogDraggableSignal")
fun Dialog.draggable(signal: Signal<Boolean>): Dialog {
    fun apply(isDraggable: Boolean) {
        setDraggable(isDraggable)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive width for Dialog.
 */
@JvmName("dialogDialogWidthSignal")
fun Dialog.dialogWidth(signal: Signal<String?>): Dialog {
    fun apply(width: String?) {
        setWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive height for Dialog.
 */
@JvmName("dialogDialogHeightSignal")
fun Dialog.dialogHeight(signal: Signal<String?>): Dialog {
    fun apply(height: String?) {
        setHeight(height)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive top position for Dialog.
 */
@JvmName("dialogTopSignal")
fun Dialog.top(signal: Signal<String?>): Dialog {
    fun apply(top: String?) {
        setTop(top)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive left position for Dialog.
 */
@JvmName("dialogLeftSignal")
fun Dialog.left(signal: Signal<String?>): Dialog {
    fun apply(left: String?) {
        setLeft(left)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive header title for Dialog.
 */
@JvmName("dialogHeaderTitleSignal")
fun Dialog.headerTitle(signal: Signal<String>): Dialog {
    fun apply(title: String) {
        setHeaderTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive close on outside click for Dialog.
 */
@JvmName("dialogCloseOnOutsideClickSignal")
fun Dialog.closeOnOutsideClick(signal: Signal<Boolean>): Dialog {
    fun apply(enabled: Boolean) {
        setCloseOnOutsideClick(enabled)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive close on Escape for Dialog.
 */
@JvmName("dialogCloseOnEscSignal")
fun Dialog.closeOnEsc(signal: Signal<Boolean>): Dialog {
    fun apply(enabled: Boolean) {
        setCloseOnEsc(enabled)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Dialog.
 */
@JvmName("dialogThemeVariantsSignal")
fun Dialog.themeVariants(signal: Signal<Set<DialogVariant>>): Dialog {
    var previousVariants = emptySet<DialogVariant>()

    fun apply(variants: Set<DialogVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Dialog.
 */
@JvmName("dialogThemeVariantSignal")
fun Dialog.themeVariant(signal: Signal<DialogVariant?>): Dialog {
    var previousVariant: DialogVariant? = null

    fun apply(variant: DialogVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive no-padding theme for Dialog.
 */
@JvmName("dialogNoPaddingSignal")
fun Dialog.noPadding(signal: Signal<Boolean>): Dialog {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(DialogVariant.LUMO_NO_PADDING)
        } else {
            removeThemeVariants(DialogVariant.LUMO_NO_PADDING)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
