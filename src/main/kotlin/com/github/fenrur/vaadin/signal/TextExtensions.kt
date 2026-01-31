package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Anchor
import com.vaadin.flow.component.html.Image

// ============================================
// Text extensions
// ============================================

/**
 * Creates a reactive Text component.
 */
@JvmName("hasComponentsTextSignal")
fun <T> HasComponents.text(
    signal: Signal<T>,
    block: Text.() -> Unit = {},
): Text {
    val text = Text(signal.value.toString())

    (text as Component).effect(signal) {
        text.text = it.toString()
    }

    text.block()
    add(text)
    return text
}


/**
 * Reactive src for Image.
 */
@JvmName("imageSrcSignal")
fun Image.src(signal: Signal<String>) {
    fun apply(src: String) {
        setSrc(src)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive alt text for Image.
 */
@JvmName("imageAltSignal")
fun Image.alt(signal: Signal<String>) {
    fun apply(alt: String) {
        setAlt(alt)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive href for Anchor.
 */
@JvmName("anchorHrefSignal")
fun Anchor.href(signal: Signal<String>) {
    fun apply(href: String) {
        setHref(href)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
