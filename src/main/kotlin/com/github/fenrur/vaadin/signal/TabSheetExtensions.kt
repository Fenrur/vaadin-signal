package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.tabs.TabSheet
import com.vaadin.flow.component.tabs.TabSheetVariant

// ============================================
// TabSheet extensions
// ============================================

/**
 * Reactive selected index for TabSheet.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("tabSheetSelectedIndexSignal")
fun TabSheet.selectedIndex(signal: Signal<Int>) {
    fun apply(index: Int) {
        setSelectedIndex(index)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for TabSheet selected index.
 */
@JvmName("tabSheetSelectedIndexMutableSignal")
fun TabSheet.selectedIndex(signal: MutableSignal<Int>) {
    selectedIndex = signal.value

    addSelectedChangeListener {
        signal.value = selectedIndex
    }

    effect(signal) {
        selectedIndex = it
    }
}

/**
 * Reactive theme variants for TabSheet.
 */
@JvmName("tabSheetThemeVariantsSignal")
fun TabSheet.themeVariants(signal: Signal<Set<TabSheetVariant>>) {
    var previousVariants = emptySet<TabSheetVariant>()

    fun apply(variants: Set<TabSheetVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for TabSheet.
 */
@JvmName("tabSheetThemeVariantSignal")
fun TabSheet.themeVariant(signal: Signal<TabSheetVariant?>) {
    var previousVariant: TabSheetVariant? = null

    fun apply(variant: TabSheetVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive bordered theme for TabSheet.
 */
@JvmName("tabSheetBorderedSignal")
fun TabSheet.bordered(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_BORDERED)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_BORDERED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive no padding theme for TabSheet.
 */
@JvmName("tabSheetNoPaddingSignal")
fun TabSheet.noPadding(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_NO_PADDING)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_NO_PADDING)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tabs centered theme for TabSheet.
 */
@JvmName("tabSheetTabsCenteredSignal")
fun TabSheet.tabsCentered(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tabs small theme for TabSheet.
 */
@JvmName("tabSheetTabsSmallSignal")
fun TabSheet.tabsSmall(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_SMALL)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tabs minimal theme for TabSheet.
 */
@JvmName("tabSheetTabsMinimalSignal")
fun TabSheet.tabsMinimal(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_MINIMAL)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_MINIMAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tabs equal width theme for TabSheet.
 */
@JvmName("tabSheetTabsEqualWidthSignal")
fun TabSheet.tabsEqualWidth(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
