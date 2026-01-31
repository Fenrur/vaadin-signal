package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.contextmenu.MenuItem

// ============================================
// MenuItem extensions
// ============================================

/**
 * Reactive checked state for MenuItem.
 */
fun MenuItem.checked(signal: Signal<Boolean>) {
    fun apply(checked: Boolean) {
        isChecked = checked
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive checkable state for MenuItem.
 */
fun MenuItem.checkable(signal: Signal<Boolean>) {
    fun apply(checkable: Boolean) {
        isCheckable = checkable
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
