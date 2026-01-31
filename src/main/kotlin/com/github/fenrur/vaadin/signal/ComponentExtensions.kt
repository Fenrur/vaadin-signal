package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasEnabled

// ============================================
// Component extensions
// ============================================

/**
 * Reactively controls the visibility of a component.
 */
fun <C : Component> C.visible(signal: Signal<Boolean>): C {
    fun apply(v: Boolean) {
        isVisible = v
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactively controls the enabled state of a component.
 */
fun <C> C.enabled(signal: Signal<Boolean>): C
        where C : Component, C : HasEnabled {

    fun apply(v: Boolean) {
        isEnabled = v
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactively sets CSS class names on a component.
 */
fun <C : Component> C.className(signal: Signal<String>): C {
    var previousClasses = ""

    fun apply(newClasses: String) {
        if (previousClasses.isNotEmpty()) {
            removeClassNames(*previousClasses.split(" ").toTypedArray())
        }
        if (newClasses.isNotEmpty()) {
            addClassNames(*newClasses.split(" ").toTypedArray())
        }
        previousClasses = newClasses
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactively adds/removes a CSS class based on a boolean condition.
 */
fun <C : Component> C.classNameWhen(className: String, signal: Signal<Boolean>): C {
    fun apply(hasClass: Boolean) {
        if (hasClass) {
            addClassName(className)
        } else {
            removeClassName(className)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactively sets an inline CSS style property.
 */
fun <C : Component> C.style(property: String, signal: Signal<String>): C {
    fun apply(value: String) {
        style.set(property, value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

