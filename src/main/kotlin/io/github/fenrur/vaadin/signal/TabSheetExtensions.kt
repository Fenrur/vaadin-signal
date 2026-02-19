package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
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
fun TabSheet.selectedIndex(signal: Signal<Int>): TabSheet {
    fun apply(index: Int) {
        setSelectedIndex(index)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for TabSheet selected index.
 */
@JvmName("tabSheetSelectedIndexMutableSignal")
fun TabSheet.selectedIndex(signal: MutableSignal<Int>): TabSheet {
    selectedIndex = signal.value

    addSelectedChangeListener {
        signal.value = selectedIndex
    }

    effect(signal) {
        selectedIndex = it
    }
    return this
}

/**
 * Reactive theme variants for TabSheet.
 */
@JvmName("tabSheetThemeVariantsSignal")
fun TabSheet.themeVariants(signal: Signal<Set<TabSheetVariant>>): TabSheet {
    var previousVariants = emptySet<TabSheetVariant>()

    fun apply(variants: Set<TabSheetVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for TabSheet.
 */
@JvmName("tabSheetThemeVariantSignal")
fun TabSheet.themeVariant(signal: Signal<TabSheetVariant?>): TabSheet {
    var previousVariant: TabSheetVariant? = null

    fun apply(variant: TabSheetVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive bordered theme for TabSheet.
 */
@JvmName("tabSheetBorderedSignal")
fun TabSheet.bordered(signal: Signal<Boolean>): TabSheet {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_BORDERED)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_BORDERED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive no padding theme for TabSheet.
 */
@JvmName("tabSheetNoPaddingSignal")
fun TabSheet.noPadding(signal: Signal<Boolean>): TabSheet {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_NO_PADDING)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_NO_PADDING)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive tabs centered theme for TabSheet.
 */
@JvmName("tabSheetTabsCenteredSignal")
fun TabSheet.tabsCentered(signal: Signal<Boolean>): TabSheet {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive tabs small theme for TabSheet.
 */
@JvmName("tabSheetTabsSmallSignal")
fun TabSheet.tabsSmall(signal: Signal<Boolean>): TabSheet {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_SMALL)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive tabs minimal theme for TabSheet.
 */
@JvmName("tabSheetTabsMinimalSignal")
fun TabSheet.tabsMinimal(signal: Signal<Boolean>): TabSheet {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_MINIMAL)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_MINIMAL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive tabs equal width theme for TabSheet.
 */
@JvmName("tabSheetTabsEqualWidthSignal")
fun TabSheet.tabsEqualWidth(signal: Signal<Boolean>): TabSheet {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS)
        } else {
            removeThemeVariants(TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
