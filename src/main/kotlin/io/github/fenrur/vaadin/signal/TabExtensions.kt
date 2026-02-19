package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.TabVariant

// ============================================
// Tab extensions
// ============================================

/**
 * Reactive label for Tab.
 */
@JvmName("tabLabelSignal")
fun Tab.label(signal: Signal<String>): Tab {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive selected state for Tab.
 */
@JvmName("tabSelectedSignal")
fun Tab.selected(signal: Signal<Boolean>): Tab {
    fun apply(selected: Boolean) {
        isSelected = selected
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive flex grow for Tab.
 */
@JvmName("tabFlexGrowSignal")
fun Tab.flexGrow(signal: Signal<Double>): Tab {
    fun apply(flexGrow: Double) {
        setFlexGrow(flexGrow)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Tab.
 */
@JvmName("tabThemeVariantsSignal")
fun Tab.themeVariants(signal: Signal<Set<TabVariant>>): Tab {
    var previousVariants = emptySet<TabVariant>()

    fun apply(variants: Set<TabVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Tab.
 */
@JvmName("tabThemeVariantSignal")
fun Tab.themeVariant(signal: Signal<TabVariant?>): Tab {
    var previousVariant: TabVariant? = null

    fun apply(variant: TabVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive icon on top theme for Tab.
 */
@JvmName("tabIconOnTopSignal")
fun Tab.iconOnTop(signal: Signal<Boolean>): Tab {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabVariant.LUMO_ICON_ON_TOP)
        } else {
            removeThemeVariants(TabVariant.LUMO_ICON_ON_TOP)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
