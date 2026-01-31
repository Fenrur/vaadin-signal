package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.sidenav.SideNavItem

// ============================================
// SideNavItem extensions
// ============================================

/**
 * Reactive label for SideNavItem.
 */
fun SideNavItem.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive path for SideNavItem.
 */
fun SideNavItem.path(signal: Signal<String?>) {
    fun apply(path: String?) {
        setPath(path)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive expanded state for SideNavItem.
 */
fun SideNavItem.expanded(signal: Signal<Boolean>) {
    fun apply(expanded: Boolean) {
        isExpanded = expanded
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
