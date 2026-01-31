package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle

// ============================================
// AppLayout extensions
// ============================================

/**
 * Reactive drawer opened state for AppLayout.
 */
fun AppLayout.drawerOpened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isDrawerOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive primary section for AppLayout.
 */
fun AppLayout.primarySection(signal: Signal<AppLayout.Section>) {
    fun apply(section: AppLayout.Section) {
        setPrimarySection(section)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive navbar content for AppLayout.
 */
fun AppLayout.navbarContent(signal: Signal<Component?>) {
    fun apply(component: Component?) {
        // Remove existing navbar content first
        element.children
            .filter { it.getAttribute("slot") == "navbar" }
            .forEach { element.removeChild(it) }

        component?.let { addToNavbar(it) }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive drawer content for AppLayout.
 */
fun AppLayout.drawerContent(signal: Signal<Component?>) {
    fun apply(component: Component?) {
        // Remove existing drawer content first
        element.children
            .filter { it.getAttribute("slot") == "drawer" }
            .forEach { element.removeChild(it) }

        component?.let { addToDrawer(it) }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// ============================================
// DrawerToggle extensions
// ============================================

/**
 * Reactive aria label for DrawerToggle.
 */
fun DrawerToggle.ariaLabel(signal: Signal<String?>) {
    fun apply(label: String?) {
        element.setAttribute("aria-label", label ?: "")
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
