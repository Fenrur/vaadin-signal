package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.login.LoginI18n
import com.vaadin.flow.component.login.LoginOverlay

// ============================================
// LoginOverlay extensions
// ============================================

/**
 * Reactive opened state for LoginOverlay.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("loginOverlayOpenedSignal")
fun LoginOverlay.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for LoginOverlay opened state.
 */
@JvmName("loginOverlayOpenedMutableSignal")
fun LoginOverlay.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    element.addEventListener("opened-changed") {
        signal.value = isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive error state for LoginOverlay.
 */
@JvmName("loginOverlayErrorSignal")
fun LoginOverlay.error(signal: Signal<Boolean>) {
    fun apply(error: Boolean) {
        isError = error
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive title for LoginOverlay.
 */
@JvmName("loginOverlayTitleSignal")
fun LoginOverlay.title(signal: Signal<String>) {
    fun apply(title: String) {
        setTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive description for LoginOverlay.
 */
@JvmName("loginOverlayDescriptionSignal")
fun LoginOverlay.description(signal: Signal<String?>) {
    fun apply(description: String?) {
        setDescription(description)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive forgot password button visible for LoginOverlay.
 */
@JvmName("loginOverlayForgotPasswordButtonVisibleSignal")
fun LoginOverlay.forgotPasswordButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isForgotPasswordButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive action for LoginOverlay.
 */
@JvmName("loginOverlayActionSignal")
fun LoginOverlay.action(signal: Signal<String?>) {
    fun apply(action: String?) {
        setAction(action)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive i18n for LoginOverlay.
 */
@JvmName("loginOverlayI18nSignal")
fun LoginOverlay.i18n(signal: Signal<LoginI18n>) {
    fun apply(i18n: LoginI18n) {
        setI18n(i18n)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
