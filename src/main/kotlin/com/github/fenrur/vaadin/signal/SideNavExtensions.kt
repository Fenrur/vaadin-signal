package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.sidenav.SideNav

// ============================================
// SideNav extensions
// ============================================

/**
 * Reactive label for SideNav.
 */
fun SideNav.label(signal: Signal<String?>) {
    fun apply(label: String?) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive collapsible state for SideNav.
 */
fun SideNav.collapsible(signal: Signal<Boolean>) {
    fun apply(collapsible: Boolean) {
        isCollapsible = collapsible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive expanded state for SideNav.
 */
fun SideNav.expanded(signal: Signal<Boolean>) {
    fun apply(expanded: Boolean) {
        isExpanded = expanded
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
