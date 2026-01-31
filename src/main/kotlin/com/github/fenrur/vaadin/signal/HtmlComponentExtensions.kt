package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.HtmlComponent

// ============================================
// HtmlComponent extensions
// ============================================

/**
 * Reactive title (tooltip) for any HtmlComponent.
 */
fun <C : HtmlComponent> C.title(signal: Signal<String>): C {
    fun apply(title: String) {
        setTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive nullable title (tooltip) for any HtmlComponent.
 */
@JvmName("titleNullable")
fun <C : HtmlComponent> C.title(signal: Signal<String?>): C {
    fun apply(title: String?) {
        setTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
