package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.sidenav.SideNavItem

// ============================================
// SideNavItem extensions
// ============================================

/**
 * Reactive label for SideNavItem.
 */
@JvmName("sideNavItemLabelSignal")
fun SideNavItem.label(signal: Signal<String>): SideNavItem {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive path for SideNavItem.
 */
@JvmName("sideNavItemPathSignal")
fun SideNavItem.path(signal: Signal<String?>): SideNavItem {
    fun apply(path: String?) {
        setPath(path)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive expanded state for SideNavItem.
 */
@JvmName("sideNavItemExpandedSignal")
fun SideNavItem.expanded(signal: Signal<Boolean>): SideNavItem {
    fun apply(expanded: Boolean) {
        isExpanded = expanded
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
