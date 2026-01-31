package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.component.tabs.TabsVariant

// ============================================
// Tabs extensions
// ============================================

/**
 * Reactive selected index for Tabs.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("tabsSelectedIndexSignal")
fun Tabs.selectedIndex(signal: Signal<Int>) {
    fun apply(index: Int) {
        setSelectedIndex(index)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for Tabs selected index.
 */
@JvmName("tabsSelectedIndexMutableSignal")
fun Tabs.selectedIndex(signal: MutableSignal<Int>) {
    selectedIndex = signal.value

    addSelectedChangeListener {
        signal.value = selectedIndex
    }

    effect(signal) {
        selectedIndex = it
    }
}

/**
 * Two-way binding for Tabs selected tab.
 */
@JvmName("tabsSelectedTabMutableSignal")
fun Tabs.selectedTab(signal: MutableSignal<Tab?>) {
    selectedTab = signal.value

    addSelectedChangeListener {
        signal.value = selectedTab
    }

    effect(signal) {
        selectedTab = it
    }
}

/**
 * Reactive orientation for Tabs.
 */
@JvmName("tabsOrientationSignal")
fun Tabs.orientation(signal: Signal<Tabs.Orientation>) {
    fun apply(orientation: Tabs.Orientation) {
        setOrientation(orientation)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autoselect for Tabs.
 */
@JvmName("tabsAutoselectSignal")
fun Tabs.autoselect(signal: Signal<Boolean>) {
    fun apply(autoselect: Boolean) {
        isAutoselect = autoselect
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Tabs.
 */
@JvmName("tabsThemeVariantsSignal")
fun Tabs.themeVariants(signal: Signal<Set<TabsVariant>>) {
    var previousVariants = emptySet<TabsVariant>()

    fun apply(variants: Set<TabsVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Tabs.
 */
@JvmName("tabsThemeVariantSignal")
fun Tabs.themeVariant(signal: Signal<TabsVariant?>) {
    var previousVariant: TabsVariant? = null

    fun apply(variant: TabsVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive centered theme for Tabs.
 */
@JvmName("tabsCenteredSignal")
fun Tabs.centered(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabsVariant.LUMO_CENTERED)
        } else {
            removeThemeVariants(TabsVariant.LUMO_CENTERED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for Tabs.
 */
@JvmName("tabsSmallSignal")
fun Tabs.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabsVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(TabsVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minimal theme for Tabs.
 */
@JvmName("tabsMinimalSignal")
fun Tabs.minimal(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabsVariant.LUMO_MINIMAL)
        } else {
            removeThemeVariants(TabsVariant.LUMO_MINIMAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive equal width tabs theme for Tabs.
 */
@JvmName("tabsEqualWidthTabsSignal")
fun Tabs.equalWidthTabs(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS)
        } else {
            removeThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive hide scroll buttons theme for Tabs.
 */
@JvmName("tabsHideScrollButtonsSignal")
fun Tabs.hideScrollButtons(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS)
        } else {
            removeThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
