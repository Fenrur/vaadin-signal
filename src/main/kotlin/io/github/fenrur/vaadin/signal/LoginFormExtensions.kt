package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.login.LoginForm
import com.vaadin.flow.component.login.LoginI18n

// ============================================
// LoginForm extensions
// ============================================

/**
 * Reactive error state for LoginForm.
 */
@JvmName("loginFormErrorSignal")
fun LoginForm.error(signal: Signal<Boolean>): LoginForm {
    fun apply(error: Boolean) {
        isError = error
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive forgot password button visible for LoginForm.
 */
@JvmName("loginFormForgotPasswordButtonVisibleSignal")
fun LoginForm.forgotPasswordButtonVisible(signal: Signal<Boolean>): LoginForm {
    fun apply(visible: Boolean) {
        isForgotPasswordButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive action for LoginForm.
 */
@JvmName("loginFormActionSignal")
fun LoginForm.action(signal: Signal<String?>): LoginForm {
    fun apply(action: String?) {
        setAction(action)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive i18n for LoginForm.
 */
@JvmName("loginFormI18nSignal")
fun LoginForm.i18n(signal: Signal<LoginI18n>): LoginForm {
    fun apply(i18n: LoginI18n) {
        setI18n(i18n)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
