package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.GridMultiSelectionModel
import com.vaadin.flow.component.grid.GridVariant
import com.vaadin.flow.data.provider.DataProvider

// ============================================
// Grid extensions
// ============================================

/**
 * Reactive DataProvider for Grid.
 */
@JvmName("gridDataProviderSignal")
fun <T> Grid<T>.dataProvider(signal: Signal<DataProvider<T, *>>) {
    fun apply(provider: DataProvider<T, *>) {
        setDataProvider(provider)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for Grid single selection.
 */
@JvmName("gridSelectedItemMutableSignal")
fun <T> Grid<T>.selectedItem(signal: MutableSignal<T?>) {
    val singleSelect = asSingleSelect()
    singleSelect.value = signal.value

    singleSelect.addValueChangeListener { event ->
        signal.value = event.value
    }

    effect(signal) {
        singleSelect.value = it
    }
}

/**
 * Two-way binding for Grid multi selection.
 */
@JvmName("gridSelectedItemsMutableSignal")
fun <T> Grid<T>.selectedItems(signal: MutableSignal<Set<T>>) {
    setSelectionMode(Grid.SelectionMode.MULTI)
    val multiSelect = selectionModel as GridMultiSelectionModel<T>

    signal.value.forEach { multiSelect.select(it) }

    multiSelect.addSelectionListener { event ->
        signal.value = event.allSelectedItems
    }

    effect(signal) {
        multiSelect.deselectAll()
        it.forEach { item -> multiSelect.select(item) }
    }
}

/**
 * Reactive selection mode for Grid.
 */
@JvmName("gridSelectionModeSignal")
fun <T> Grid<T>.selectionMode(signal: Signal<Grid.SelectionMode>) {
    fun apply(mode: Grid.SelectionMode) {
        setSelectionMode(mode)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive alternating rows theme for Grid.
 */
@JvmName("gridAlternatingRowsSignal")
fun <T> Grid<T>.alternatingRows(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(GridVariant.LUMO_ROW_STRIPES)
        } else {
            removeThemeVariants(GridVariant.LUMO_ROW_STRIPES)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive compact theme for Grid.
 */
@JvmName("gridCompactSignal")
fun <T> Grid<T>.compact(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(GridVariant.LUMO_COMPACT)
        } else {
            removeThemeVariants(GridVariant.LUMO_COMPACT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive column borders for Grid.
 */
@JvmName("gridColumnBordersSignal")
fun <T> Grid<T>.columnBorders(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS)
        } else {
            removeThemeVariants(GridVariant.LUMO_COLUMN_BORDERS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive column reordering for Grid.
 */
@JvmName("gridColumnReorderingSignal")
fun <T> Grid<T>.columnReordering(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        isColumnReorderingAllowed = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive loading state for Grid.
 */
@JvmName("gridLoadingSignal")
fun <T> Grid<T>.loading(signal: Signal<Boolean>) {
    fun apply(isLoading: Boolean) {
        element.setProperty("loading", isLoading)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
