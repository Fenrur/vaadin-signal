package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.contextmenu.MenuItem

// ============================================
// MenuItem extensions
// ============================================

/**
 * Reactive checked state for MenuItem.
 */
@JvmName("menuItemCheckedSignal")
fun MenuItem.checked(signal: Signal<Boolean>): MenuItem {
    fun apply(checked: Boolean) {
        isChecked = checked
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive checkable state for MenuItem.
 */
@JvmName("menuItemCheckableSignal")
fun MenuItem.checkable(signal: Signal<Boolean>): MenuItem {
    fun apply(checkable: Boolean) {
        isCheckable = checkable
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
