package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle

// ============================================
// AppLayout extensions
// ============================================

/**
 * Reactive drawer opened state for AppLayout.
 */
@JvmName("appLayoutDrawerOpenedSignal")
fun AppLayout.drawerOpened(signal: Signal<Boolean>): AppLayout {
    fun apply(opened: Boolean) {
        isDrawerOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive primary section for AppLayout.
 */
@JvmName("appLayoutPrimarySectionSignal")
fun AppLayout.primarySection(signal: Signal<AppLayout.Section>): AppLayout {
    fun apply(section: AppLayout.Section) {
        setPrimarySection(section)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive navbar content for AppLayout.
 */
@JvmName("appLayoutNavbarContentSignal")
fun AppLayout.navbarContent(signal: Signal<Component?>): AppLayout {
    fun apply(component: Component?) {
        // Remove existing navbar content first
        element.children
            .filter { it.getAttribute("slot") == "navbar" }
            .forEach { element.removeChild(it) }

        component?.let { addToNavbar(it) }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive drawer content for AppLayout.
 */
@JvmName("appLayoutDrawerContentSignal")
fun AppLayout.drawerContent(signal: Signal<Component?>): AppLayout {
    fun apply(component: Component?) {
        // Remove existing drawer content first
        element.children
            .filter { it.getAttribute("slot") == "drawer" }
            .forEach { element.removeChild(it) }

        component?.let { addToDrawer(it) }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

// ============================================
// DrawerToggle extensions
// ============================================

/**
 * Reactive aria label for DrawerToggle.
 */
@JvmName("drawerToggleAriaLabelSignal")
fun DrawerToggle.ariaLabel(signal: Signal<String?>): DrawerToggle {
    fun apply(label: String?) {
        element.setAttribute("aria-label", label ?: "")
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
