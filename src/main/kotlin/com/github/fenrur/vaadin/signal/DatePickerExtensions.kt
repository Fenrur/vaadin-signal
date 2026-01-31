package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.datepicker.DatePickerVariant
import java.time.LocalDate

// ============================================
// DatePicker extensions
// ============================================

/**
 * Reactive value for DatePicker.
 * Note: This is a one-way binding (signal to component).
 */
fun DatePicker.value(signal: Signal<LocalDate?>) {
    fun apply(value: LocalDate?) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Two-way binding for DatePicker value.
 */
@JvmName("datePickerValueTwoWay")
fun DatePicker.value(signal: MutableSignal<LocalDate?>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for DatePicker.
 */
fun DatePicker.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for DatePicker.
 */
fun DatePicker.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min date for DatePicker.
 */
fun DatePicker.min(signal: Signal<LocalDate?>) {
    fun apply(min: LocalDate?) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max date for DatePicker.
 */
fun DatePicker.max(signal: Signal<LocalDate?>) {
    fun apply(max: LocalDate?) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required indicator for DatePicker.
 */
fun DatePicker.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequired = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for DatePicker.
 */
fun DatePicker.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        isInvalid = invalid
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for DatePicker.
 */
fun DatePicker.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visibility for DatePicker.
 */
fun DatePicker.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive auto open for DatePicker.
 */
fun DatePicker.autoOpen(signal: Signal<Boolean>) {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive opened state for DatePicker.
 */
fun DatePicker.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        setOpened(opened)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay class name for DatePicker.
 */
fun DatePicker.overlayClassName(signal: Signal<String>) {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive aria label for DatePicker.
 */
fun DatePicker.ariaLabel(signal: Signal<String?>) {
    fun apply(ariaLabel: String?) {
        setAriaLabel(ariaLabel)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive aria labelled by for DatePicker.
 */
fun DatePicker.ariaLabelledBy(signal: Signal<String?>) {
    fun apply(labelledBy: String?) {
        setAriaLabelledBy(labelledBy)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for DatePicker.
 */
fun DatePicker.themeVariants(signal: Signal<Set<DatePickerVariant>>) {
    var previousVariants = emptySet<DatePickerVariant>()

    fun apply(variants: Set<DatePickerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for DatePicker.
 */
fun DatePicker.themeVariant(signal: Signal<DatePickerVariant?>) {
    var previousVariant: DatePickerVariant? = null

    fun apply(variant: DatePickerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for DatePicker.
 */
fun DatePicker.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(DatePickerVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for DatePicker.
 */
fun DatePicker.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(DatePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align left for DatePicker.
 */
fun DatePicker.alignLeft(signal: Signal<Boolean>) {
    fun apply(alignLeft: Boolean) {
        if (alignLeft) {
            addThemeVariants(DatePickerVariant.LUMO_ALIGN_LEFT)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_ALIGN_LEFT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align center for DatePicker.
 */
fun DatePicker.alignCenter(signal: Signal<Boolean>) {
    fun apply(alignCenter: Boolean) {
        if (alignCenter) {
            addThemeVariants(DatePickerVariant.LUMO_ALIGN_CENTER)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_ALIGN_CENTER)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive align right for DatePicker.
 */
fun DatePicker.alignRight(signal: Signal<Boolean>) {
    fun apply(alignRight: Boolean) {
        if (alignRight) {
            addThemeVariants(DatePickerVariant.LUMO_ALIGN_RIGHT)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_ALIGN_RIGHT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly state for DatePicker.
 */
fun DatePicker.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive name for DatePicker.
 */
fun DatePicker.name(signal: Signal<String>) {
    fun apply(name: String) {
        setName(name)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive week numbers visible for DatePicker.
 */
fun DatePicker.weekNumbersVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isWeekNumbersVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive initial position for DatePicker.
 */
fun DatePicker.initialPosition(signal: Signal<LocalDate?>) {
    fun apply(position: LocalDate?) {
        setInitialPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
