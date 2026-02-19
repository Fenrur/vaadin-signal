package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.datetimepicker.DateTimePicker
import com.vaadin.flow.component.datetimepicker.DateTimePickerVariant
import java.time.Duration
import java.time.LocalDateTime

// ============================================
// DateTimePicker extensions
// ============================================

/**
 * Reactive min date time for DateTimePicker.
 */
@JvmName("dateTimePickerMinSignal")
fun DateTimePicker.min(signal: Signal<LocalDateTime?>): DateTimePicker {
    fun apply(min: LocalDateTime?) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max date time for DateTimePicker.
 */
@JvmName("dateTimePickerMaxSignal")
fun DateTimePicker.max(signal: Signal<LocalDateTime?>): DateTimePicker {
    fun apply(max: LocalDateTime?) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive step for DateTimePicker.
 */
@JvmName("dateTimePickerStepSignal")
fun DateTimePicker.step(signal: Signal<Duration?>): DateTimePicker {
    fun apply(step: Duration?) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive required indicator for DateTimePicker.
 */
@JvmName("dateTimePickerRequiredSignal")
fun DateTimePicker.required(signal: Signal<Boolean>): DateTimePicker {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive auto open for DateTimePicker.
 */
@JvmName("dateTimePickerAutoOpenSignal")
fun DateTimePicker.autoOpen(signal: Signal<Boolean>): DateTimePicker {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive overlay class name for DateTimePicker.
 */
@JvmName("dateTimePickerOverlayClassNameSignal")
fun DateTimePicker.overlayClassName(signal: Signal<String>): DateTimePicker {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive date placeholder for DateTimePicker.
 */
@JvmName("dateTimePickerDatePlaceholderSignal")
fun DateTimePicker.datePlaceholder(signal: Signal<String>): DateTimePicker {
    fun apply(placeholder: String) {
        setDatePlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive time placeholder for DateTimePicker.
 */
@JvmName("dateTimePickerTimePlaceholderSignal")
fun DateTimePicker.timePlaceholder(signal: Signal<String>): DateTimePicker {
    fun apply(placeholder: String) {
        setTimePlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive date aria label for DateTimePicker.
 */
@JvmName("dateTimePickerDateAriaLabelSignal")
fun DateTimePicker.dateAriaLabel(signal: Signal<String?>): DateTimePicker {
    fun apply(ariaLabel: String?) {
        setDateAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive time aria label for DateTimePicker.
 */
@JvmName("dateTimePickerTimeAriaLabelSignal")
fun DateTimePicker.timeAriaLabel(signal: Signal<String?>): DateTimePicker {
    fun apply(ariaLabel: String?) {
        setTimeAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for DateTimePicker.
 */
@JvmName("dateTimePickerThemeVariantsSignal")
fun DateTimePicker.themeVariants(signal: Signal<Set<DateTimePickerVariant>>): DateTimePicker {
    var previousVariants = emptySet<DateTimePickerVariant>()

    fun apply(variants: Set<DateTimePickerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for DateTimePicker.
 */
@JvmName("dateTimePickerThemeVariantSignal")
fun DateTimePicker.themeVariant(signal: Signal<DateTimePickerVariant?>): DateTimePicker {
    var previousVariant: DateTimePickerVariant? = null

    fun apply(variant: DateTimePickerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small size for DateTimePicker.
 */
@JvmName("dateTimePickerSmallSignal")
fun DateTimePicker.small(signal: Signal<Boolean>): DateTimePicker {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(DateTimePickerVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper above field for DateTimePicker.
 */
@JvmName("dateTimePickerHelperAboveFieldSignal")
fun DateTimePicker.helperAboveField(signal: Signal<Boolean>): DateTimePicker {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(DateTimePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align left for DateTimePicker.
 */
@JvmName("dateTimePickerAlignLeftSignal")
fun DateTimePicker.alignLeft(signal: Signal<Boolean>): DateTimePicker {
    fun apply(alignLeft: Boolean) {
        if (alignLeft) {
            addThemeVariants(DateTimePickerVariant.LUMO_ALIGN_LEFT)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_ALIGN_LEFT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align center for DateTimePicker.
 */
@JvmName("dateTimePickerAlignCenterSignal")
fun DateTimePicker.alignCenter(signal: Signal<Boolean>): DateTimePicker {
    fun apply(alignCenter: Boolean) {
        if (alignCenter) {
            addThemeVariants(DateTimePickerVariant.LUMO_ALIGN_CENTER)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_ALIGN_CENTER)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align right for DateTimePicker.
 */
@JvmName("dateTimePickerAlignRightSignal")
fun DateTimePicker.alignRight(signal: Signal<Boolean>): DateTimePicker {
    fun apply(alignRight: Boolean) {
        if (alignRight) {
            addThemeVariants(DateTimePickerVariant.LUMO_ALIGN_RIGHT)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_ALIGN_RIGHT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive readonly state for DateTimePicker.
 */
@JvmName("dateTimePickerReadonlySignal")
fun DateTimePicker.readonly(signal: Signal<Boolean>): DateTimePicker {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive week numbers visible for DateTimePicker.
 */
@JvmName("dateTimePickerWeekNumbersVisibleSignal")
fun DateTimePicker.weekNumbersVisible(signal: Signal<Boolean>): DateTimePicker {
    fun apply(visible: Boolean) {
        isWeekNumbersVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
