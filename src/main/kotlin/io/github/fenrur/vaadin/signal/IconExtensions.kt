package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon

// ============================================
// Icon extensions
// ============================================

/**
 * Reactive icon for Icon component.
 */
@JvmName("iconIconSignal")
fun Icon.icon(signal: Signal<VaadinIcon>): Icon {
    fun apply(icon: VaadinIcon) {
        setIcon(icon)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive color for Icon.
 */
@JvmName("iconColorSignal")
fun Icon.color(signal: Signal<String?>): Icon {
    fun apply(color: String?) {
        setColor(color)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive size for Icon.
 */
@JvmName("iconSizeSignal")
fun Icon.size(signal: Signal<String?>): Icon {
    fun apply(size: String?) {
        setSize(size)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
