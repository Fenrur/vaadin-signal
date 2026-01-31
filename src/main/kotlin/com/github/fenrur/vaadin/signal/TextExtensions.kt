package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Anchor
import com.vaadin.flow.component.html.Image

/**
 * Creates a reactive Text component.
 */
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
 * Reactive text for Button.
 */
fun Button.text(signal: Signal<String>) {
    fun apply(text: String) {
        setText(text)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive icon for Button.
 */
fun Button.icon(signal: Signal<Component?>) {
    fun apply(icon: Component?) {
        setIcon(icon)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme for Button.
 */
fun Button.theme(signal: Signal<String>) {
    var previousTheme = ""

    fun apply(theme: String) {
        if (previousTheme.isNotEmpty()) {
            removeThemeNames(*previousTheme.split(" ").toTypedArray())
        }
        if (theme.isNotEmpty()) {
            addThemeNames(*theme.split(" ").toTypedArray())
        }
        previousTheme = theme
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive src for Image.
 */
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
fun Anchor.href(signal: Signal<String>) {
    fun apply(href: String) {
        setHref(href)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
