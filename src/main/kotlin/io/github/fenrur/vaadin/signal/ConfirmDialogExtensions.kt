package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.confirmdialog.ConfirmDialog

// ============================================
// ConfirmDialog extensions
// ============================================

/**
 * Reactive opened state for ConfirmDialog.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("confirmDialogOpenedSignal")
fun ConfirmDialog.opened(signal: Signal<Boolean>): ConfirmDialog {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for ConfirmDialog opened state.
 */
@JvmName("confirmDialogOpenedMutableSignal")
fun ConfirmDialog.opened(signal: MutableSignal<Boolean>): ConfirmDialog {
    isOpened = signal.value

    element.addEventListener("opened-changed") {
        signal.value = isOpened
    }

    effect(signal) {
        isOpened = it
    }
    return this
}

/**
 * Reactive header for ConfirmDialog.
 */
@JvmName("confirmDialogHeaderSignal")
fun ConfirmDialog.header(signal: Signal<String>): ConfirmDialog {
    fun apply(header: String) {
        setHeader(header)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive confirm text for ConfirmDialog.
 */
@JvmName("confirmDialogConfirmTextSignal")
fun ConfirmDialog.confirmText(signal: Signal<String>): ConfirmDialog {
    fun apply(text: String) {
        setConfirmText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive confirm button theme for ConfirmDialog.
 */
@JvmName("confirmDialogConfirmButtonThemeSignal")
fun ConfirmDialog.confirmButtonTheme(signal: Signal<String>): ConfirmDialog {
    fun apply(theme: String) {
        setConfirmButtonTheme(theme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive cancel text for ConfirmDialog.
 */
@JvmName("confirmDialogCancelTextSignal")
fun ConfirmDialog.cancelText(signal: Signal<String>): ConfirmDialog {
    fun apply(text: String) {
        setCancelText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive cancel button theme for ConfirmDialog.
 */
@JvmName("confirmDialogCancelButtonThemeSignal")
fun ConfirmDialog.cancelButtonTheme(signal: Signal<String>): ConfirmDialog {
    fun apply(theme: String) {
        setCancelButtonTheme(theme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive reject text for ConfirmDialog.
 */
@JvmName("confirmDialogRejectTextSignal")
fun ConfirmDialog.rejectText(signal: Signal<String>): ConfirmDialog {
    fun apply(text: String) {
        setRejectText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive reject button theme for ConfirmDialog.
 */
@JvmName("confirmDialogRejectButtonThemeSignal")
fun ConfirmDialog.rejectButtonTheme(signal: Signal<String>): ConfirmDialog {
    fun apply(theme: String) {
        setRejectButtonTheme(theme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive close on Esc for ConfirmDialog.
 */
@JvmName("confirmDialogCloseOnEscSignal")
fun ConfirmDialog.closeOnEsc(signal: Signal<Boolean>): ConfirmDialog {
    fun apply(enabled: Boolean) {
        isCloseOnEsc = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
