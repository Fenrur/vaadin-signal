package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.formlayout.FormLayout

// ============================================
// FormLayout extensions
// ============================================

/**
 * Reactive responsive steps for FormLayout.
 */
fun FormLayout.responsiveSteps(signal: Signal<List<FormLayout.ResponsiveStep>>) {
    fun apply(steps: List<FormLayout.ResponsiveStep>) {
        setResponsiveSteps(steps)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive colspan for a FormItem.
 */
fun FormLayout.FormItem.colspan(signal: Signal<Int>) {
    fun apply(colspan: Int) {
        element.setAttribute("colspan", colspan.toString())
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive label width for FormLayout.
 */
fun FormLayout.labelWidth(signal: Signal<String?>) {
    fun apply(width: String?) {
        if (width != null) {
            style.set("--vaadin-form-layout-label-width", width)
        } else {
            style.remove("--vaadin-form-layout-label-width")
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
