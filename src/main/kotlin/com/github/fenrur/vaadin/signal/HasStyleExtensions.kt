package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasStyle

// ============================================
// HasStyle extensions
// ============================================

/**
 * Reactively sets CSS class names on a component.
 */
@JvmName("hasStyleClassNameSignal")
fun <C> C.className(signal: Signal<String>)
        where C : HasStyle, C : AttachNotifier, C : DetachNotifier {
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
}

/**
 * Reactively adds/removes a CSS class based on a boolean condition.
 */
@JvmName("hasStyleClassNameWhenSignal")
fun <C> C.classNameWhen(className: String, signal: Signal<Boolean>)
        where C : HasStyle, C : AttachNotifier, C : DetachNotifier {
    fun apply(hasClass: Boolean) {
        if (hasClass) {
            addClassName(className)
        } else {
            removeClassName(className)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactively sets an inline CSS style property.
 */
@JvmName("hasStyleStyleSignal")
fun <C> C.style(property: String, signal: Signal<String>)
        where C : HasStyle, C : AttachNotifier, C : DetachNotifier {
    fun apply(value: String) {
        style.set(property, value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
