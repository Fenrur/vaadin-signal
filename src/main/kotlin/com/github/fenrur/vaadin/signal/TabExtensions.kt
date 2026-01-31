package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.TabVariant

// ============================================
// Tab extensions
// ============================================

/**
 * Reactive label for Tab.
 */
fun Tab.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive selected state for Tab.
 */
fun Tab.selected(signal: Signal<Boolean>) {
    fun apply(selected: Boolean) {
        isSelected = selected
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive flex grow for Tab.
 */
fun Tab.flexGrow(signal: Signal<Double>) {
    fun apply(flexGrow: Double) {
        setFlexGrow(flexGrow)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Tab.
 */
fun Tab.themeVariants(signal: Signal<Set<TabVariant>>) {
    var previousVariants = emptySet<TabVariant>()

    fun apply(variants: Set<TabVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Tab.
 */
fun Tab.themeVariant(signal: Signal<TabVariant?>) {
    var previousVariant: TabVariant? = null

    fun apply(variant: TabVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive icon on top theme for Tab.
 */
fun Tab.iconOnTop(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabVariant.LUMO_ICON_ON_TOP)
        } else {
            removeThemeVariants(TabVariant.LUMO_ICON_ON_TOP)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
