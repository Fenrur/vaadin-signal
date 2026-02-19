package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.formlayout.FormLayout

// ============================================
// FormLayout extensions
// ============================================

/**
 * Reactive responsive steps for FormLayout.
 */
@JvmName("formLayoutResponsiveStepsSignal")
fun FormLayout.responsiveSteps(signal: Signal<List<FormLayout.ResponsiveStep>>): FormLayout {
    fun apply(steps: List<FormLayout.ResponsiveStep>) {
        setResponsiveSteps(steps)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive colspan for a FormItem.
 */
@JvmName("formItemColspanSignal")
fun FormLayout.FormItem.colspan(signal: Signal<Int>): FormLayout.FormItem {
    fun apply(colspan: Int) {
        element.setAttribute("colspan", colspan.toString())
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive label width for FormLayout.
 */
@JvmName("formLayoutLabelWidthSignal")
fun FormLayout.labelWidth(signal: Signal<String?>): FormLayout {
    fun apply(width: String?) {
        if (width != null) {
            style.set("--vaadin-form-layout-label-width", width)
        } else {
            style.remove("--vaadin-form-layout-label-width")
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
