package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.menubar.MenuBar
import com.vaadin.flow.component.menubar.MenuBarVariant

// ============================================
// MenuBar extensions
// ============================================

/**
 * Reactive open on hover for MenuBar.
 */
fun MenuBar.openOnHover(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        isOpenOnHover = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for MenuBar.
 */
fun MenuBar.themeVariants(signal: Signal<Set<MenuBarVariant>>) {
    var previousVariants = emptySet<MenuBarVariant>()

    fun apply(variants: Set<MenuBarVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for MenuBar.
 */
fun MenuBar.themeVariant(signal: Signal<MenuBarVariant?>) {
    var previousVariant: MenuBarVariant? = null

    fun apply(variant: MenuBarVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tertiary theme for MenuBar.
 */
fun MenuBar.tertiary(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(MenuBarVariant.LUMO_TERTIARY)
        } else {
            removeThemeVariants(MenuBarVariant.LUMO_TERTIARY)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tertiary-inline theme for MenuBar.
 */
fun MenuBar.tertiaryInline(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(MenuBarVariant.LUMO_TERTIARY_INLINE)
        } else {
            removeThemeVariants(MenuBarVariant.LUMO_TERTIARY_INLINE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive primary theme for MenuBar.
 */
fun MenuBar.primary(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(MenuBarVariant.LUMO_PRIMARY)
        } else {
            removeThemeVariants(MenuBarVariant.LUMO_PRIMARY)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for MenuBar.
 */
fun MenuBar.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(MenuBarVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(MenuBarVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive icon theme for MenuBar.
 */
fun MenuBar.icon(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(MenuBarVariant.LUMO_ICON)
        } else {
            removeThemeVariants(MenuBarVariant.LUMO_ICON)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
