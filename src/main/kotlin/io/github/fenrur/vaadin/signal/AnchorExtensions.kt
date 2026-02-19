package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
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
fun Anchor.href(signal: Signal<String>): Anchor {
    fun apply(href: String) {
        setHref(href)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive target for Anchor.
 */
@JvmName("anchorTargetSignal")
fun Anchor.target(signal: Signal<AnchorTarget>): Anchor {
    fun apply(target: AnchorTarget) {
        setTarget(target)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive target string for Anchor.
 */
@JvmName("anchorTargetStringSignal")
fun Anchor.target(signal: Signal<String>): Anchor {
    fun apply(target: String) {
        setTarget(target)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive router ignore for Anchor.
 */
@JvmName("anchorRouterIgnoreSignal")
fun Anchor.routerIgnore(signal: Signal<Boolean>): Anchor {
    fun apply(ignore: Boolean) {
        isRouterIgnore = ignore
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
