package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.timepicker.TimePicker
import com.vaadin.flow.component.timepicker.TimePickerVariant
import java.time.Duration
import java.time.LocalTime

// ============================================
// TimePicker extensions
// ============================================

/**
 * Reactive min time for TimePicker.
 */
@JvmName("timePickerMinSignal")
fun TimePicker.min(signal: Signal<LocalTime?>) {
    fun apply(min: LocalTime?) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max time for TimePicker.
 */
@JvmName("timePickerMaxSignal")
fun TimePicker.max(signal: Signal<LocalTime?>) {
    fun apply(max: LocalTime?) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive step for TimePicker.
 */
@JvmName("timePickerStepSignal")
fun TimePicker.step(signal: Signal<Duration?>) {
    fun apply(step: Duration?) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required indicator for TimePicker.
 */
@JvmName("timePickerRequiredSignal")
fun TimePicker.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visibility for TimePicker.
 */
@JvmName("timePickerClearButtonVisibleSignal")
fun TimePicker.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive auto open for TimePicker.
 */
@JvmName("timePickerAutoOpenSignal")
fun TimePicker.autoOpen(signal: Signal<Boolean>) {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay class name for TimePicker.
 */
@JvmName("timePickerOverlayClassNameSignal")
fun TimePicker.overlayClassName(signal: Signal<String>) {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for TimePicker.
 */
@JvmName("timePickerThemeVariantsSignal")
fun TimePicker.themeVariants(signal: Signal<Set<TimePickerVariant>>) {
    var previousVariants = emptySet<TimePickerVariant>()

    fun apply(variants: Set<TimePickerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for TimePicker.
 */
@JvmName("timePickerThemeVariantSignal")
fun TimePicker.themeVariant(signal: Signal<TimePickerVariant?>) {
    var previousVariant: TimePickerVariant? = null

    fun apply(variant: TimePickerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for TimePicker.
 */
@JvmName("timePickerSmallSignal")
fun TimePicker.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(TimePickerVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(TimePickerVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for TimePicker.
 */
@JvmName("timePickerHelperAboveFieldSignal")
fun TimePicker.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(TimePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(TimePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align left for TimePicker.
 */
@JvmName("timePickerAlignLeftSignal")
fun TimePicker.alignLeft(signal: Signal<Boolean>) {
    fun apply(alignLeft: Boolean) {
        if (alignLeft) {
            addThemeVariants(TimePickerVariant.LUMO_ALIGN_LEFT)
        } else {
            removeThemeVariants(TimePickerVariant.LUMO_ALIGN_LEFT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align center for TimePicker.
 */
@JvmName("timePickerAlignCenterSignal")
fun TimePicker.alignCenter(signal: Signal<Boolean>) {
    fun apply(alignCenter: Boolean) {
        if (alignCenter) {
            addThemeVariants(TimePickerVariant.LUMO_ALIGN_CENTER)
        } else {
            removeThemeVariants(TimePickerVariant.LUMO_ALIGN_CENTER)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align right for TimePicker.
 */
@JvmName("timePickerAlignRightSignal")
fun TimePicker.alignRight(signal: Signal<Boolean>) {
    fun apply(alignRight: Boolean) {
        if (alignRight) {
            addThemeVariants(TimePickerVariant.LUMO_ALIGN_RIGHT)
        } else {
            removeThemeVariants(TimePickerVariant.LUMO_ALIGN_RIGHT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly state for TimePicker.
 */
@JvmName("timePickerReadonlySignal")
fun TimePicker.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
