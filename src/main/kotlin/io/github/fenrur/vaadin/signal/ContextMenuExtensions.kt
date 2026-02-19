package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.contextmenu.ContextMenu

// ============================================
// ContextMenu extensions
// Note: ContextMenu.isOpened is read-only and cannot be set programmatically.
// ContextMenu is opened by right-clicking on the target element.
// ============================================

/**
 * Reactive open on click for ContextMenu.
 */
@JvmName("contextMenuOpenOnClickSignal")
fun ContextMenu.openOnClick(signal: Signal<Boolean>): ContextMenu {
    fun apply(enabled: Boolean) {
        isOpenOnClick = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
