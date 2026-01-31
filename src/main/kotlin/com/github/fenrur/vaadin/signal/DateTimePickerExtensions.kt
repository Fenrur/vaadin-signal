package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.datetimepicker.DateTimePicker
import com.vaadin.flow.component.datetimepicker.DateTimePickerVariant
import java.time.Duration
import java.time.LocalDateTime

// ============================================
// DateTimePicker extensions
// ============================================

/**
 * Reactive value for DateTimePicker.
 * Note: This is a one-way binding (signal to component).
 */
fun DateTimePicker.value(signal: Signal<LocalDateTime?>) {
    fun apply(value: LocalDateTime?) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for DateTimePicker value.
 */
@JvmName("dateTimePickerValueTwoWay")
fun DateTimePicker.value(signal: MutableSignal<LocalDateTime?>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for DateTimePicker.
 */
fun DateTimePicker.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min date time for DateTimePicker.
 */
fun DateTimePicker.min(signal: Signal<LocalDateTime?>) {
    fun apply(min: LocalDateTime?) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max date time for DateTimePicker.
 */
fun DateTimePicker.max(signal: Signal<LocalDateTime?>) {
    fun apply(max: LocalDateTime?) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive step for DateTimePicker.
 */
fun DateTimePicker.step(signal: Signal<Duration?>) {
    fun apply(step: Duration?) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required indicator for DateTimePicker.
 */
fun DateTimePicker.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequiredIndicatorVisible = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for DateTimePicker.
 */
fun DateTimePicker.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        isInvalid = invalid
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for DateTimePicker.
 */
fun DateTimePicker.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive auto open for DateTimePicker.
 */
fun DateTimePicker.autoOpen(signal: Signal<Boolean>) {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay class name for DateTimePicker.
 */
fun DateTimePicker.overlayClassName(signal: Signal<String>) {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive date placeholder for DateTimePicker.
 */
fun DateTimePicker.datePlaceholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setDatePlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive time placeholder for DateTimePicker.
 */
fun DateTimePicker.timePlaceholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setTimePlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive date aria label for DateTimePicker.
 */
fun DateTimePicker.dateAriaLabel(signal: Signal<String?>) {
    fun apply(ariaLabel: String?) {
        setDateAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive time aria label for DateTimePicker.
 */
fun DateTimePicker.timeAriaLabel(signal: Signal<String?>) {
    fun apply(ariaLabel: String?) {
        setTimeAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for DateTimePicker.
 */
fun DateTimePicker.themeVariants(signal: Signal<Set<DateTimePickerVariant>>) {
    var previousVariants = emptySet<DateTimePickerVariant>()

    fun apply(variants: Set<DateTimePickerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for DateTimePicker.
 */
fun DateTimePicker.themeVariant(signal: Signal<DateTimePickerVariant?>) {
    var previousVariant: DateTimePickerVariant? = null

    fun apply(variant: DateTimePickerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for DateTimePicker.
 */
fun DateTimePicker.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(DateTimePickerVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for DateTimePicker.
 */
fun DateTimePicker.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(DateTimePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align left for DateTimePicker.
 */
fun DateTimePicker.alignLeft(signal: Signal<Boolean>) {
    fun apply(alignLeft: Boolean) {
        if (alignLeft) {
            addThemeVariants(DateTimePickerVariant.LUMO_ALIGN_LEFT)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_ALIGN_LEFT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align center for DateTimePicker.
 */
fun DateTimePicker.alignCenter(signal: Signal<Boolean>) {
    fun apply(alignCenter: Boolean) {
        if (alignCenter) {
            addThemeVariants(DateTimePickerVariant.LUMO_ALIGN_CENTER)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_ALIGN_CENTER)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align right for DateTimePicker.
 */
fun DateTimePicker.alignRight(signal: Signal<Boolean>) {
    fun apply(alignRight: Boolean) {
        if (alignRight) {
            addThemeVariants(DateTimePickerVariant.LUMO_ALIGN_RIGHT)
        } else {
            removeThemeVariants(DateTimePickerVariant.LUMO_ALIGN_RIGHT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly state for DateTimePicker.
 */
fun DateTimePicker.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive week numbers visible for DateTimePicker.
 */
fun DateTimePicker.weekNumbersVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isWeekNumbersVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
