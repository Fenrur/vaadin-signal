package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.HtmlComponent

// ============================================
// HtmlComponent extensions
// ============================================

/**
 * Reactive title (tooltip) for any HtmlComponent.
 */
@JvmName("htmlComponentTitleSignal")
fun HtmlComponent.title(signal: Signal<String>) {
    fun apply(title: String) {
        setTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive nullable title (tooltip) for any HtmlComponent.
 */
@JvmName("htmlComponentTitleNullableSignal")
fun HtmlComponent.title(signal: Signal<String?>) {
    fun apply(title: String?) {
        setTitle(title)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
