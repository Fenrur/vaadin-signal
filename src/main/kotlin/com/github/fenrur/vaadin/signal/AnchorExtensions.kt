package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.html.Anchor
import com.vaadin.flow.component.html.AnchorTarget
import com.vaadin.flow.server.AbstractStreamResource

// ============================================
// Anchor extensions
// Note: href(signal: Signal<String>) is defined in TextExtensions.kt
// ============================================

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

/**
 * Reactive target for Anchor.
 */
@JvmName("anchorTargetSignal")
fun Anchor.target(signal: Signal<AnchorTarget>) {
    fun apply(target: AnchorTarget) {
        setTarget(target)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive target string for Anchor.
 */
@JvmName("anchorTargetStringSignal")
fun Anchor.target(signal: Signal<String>) {
    fun apply(target: String) {
        setTarget(target)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive router ignore for Anchor.
 */
@JvmName("anchorRouterIgnoreSignal")
fun Anchor.routerIgnore(signal: Signal<Boolean>) {
    fun apply(ignore: Boolean) {
        isRouterIgnore = ignore
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
