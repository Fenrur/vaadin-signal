package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.confirmdialog.ConfirmDialog

// ============================================
// ConfirmDialog extensions
// ============================================

/**
 * Reactive opened state for ConfirmDialog.
 */
fun ConfirmDialog.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive header for ConfirmDialog.
 */
fun ConfirmDialog.header(signal: Signal<String>) {
    fun apply(header: String) {
        setHeader(header)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive confirm text for ConfirmDialog.
 */
fun ConfirmDialog.confirmText(signal: Signal<String>) {
    fun apply(text: String) {
        setConfirmText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive confirm button theme for ConfirmDialog.
 */
fun ConfirmDialog.confirmButtonTheme(signal: Signal<String>) {
    fun apply(theme: String) {
        setConfirmButtonTheme(theme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive cancel text for ConfirmDialog.
 */
fun ConfirmDialog.cancelText(signal: Signal<String>) {
    fun apply(text: String) {
        setCancelText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive cancel button theme for ConfirmDialog.
 */
fun ConfirmDialog.cancelButtonTheme(signal: Signal<String>) {
    fun apply(theme: String) {
        setCancelButtonTheme(theme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive reject text for ConfirmDialog.
 */
fun ConfirmDialog.rejectText(signal: Signal<String>) {
    fun apply(text: String) {
        setRejectText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive reject button theme for ConfirmDialog.
 */
fun ConfirmDialog.rejectButtonTheme(signal: Signal<String>) {
    fun apply(theme: String) {
        setRejectButtonTheme(theme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive close on Esc for ConfirmDialog.
 */
fun ConfirmDialog.closeOnEsc(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        isCloseOnEsc = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
