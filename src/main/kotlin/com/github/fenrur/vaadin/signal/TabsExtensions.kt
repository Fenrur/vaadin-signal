package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.accordion.AccordionPanel
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.component.tabs.TabsVariant

/**
 * Two-way binding for Tabs selected index.
 */
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
fun Tabs.tabsOrientation(signal: Signal<Tabs.Orientation>) {
    fun apply(orientation: Tabs.Orientation) {
        setOrientation(orientation)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minimal theme for Tabs.
 */
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
 * Reactive centered theme for Tabs.
 */
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
 * Reactive equal width tabs theme.
 */
fun Tabs.equalWidth(signal: Signal<Boolean>) {
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
 * Two-way binding for AccordionPanel opened state.
 */
fun AccordionPanel.opened(signal: MutableSignal<Boolean>) {
    isOpened = signal.value

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        isOpened = it
    }
}

/**
 * Reactive summary text for AccordionPanel.
 */
fun AccordionPanel.summary(signal: Signal<String>) {
    fun apply(summaryText: String) {
        setSummaryText(summaryText)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
