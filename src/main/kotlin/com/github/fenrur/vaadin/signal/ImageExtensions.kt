package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.html.Image

// ============================================
// Image extensions
// ============================================

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
